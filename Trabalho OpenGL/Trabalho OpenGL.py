import glfw
from OpenGL.GL import *
import OpenGL.GL.shaders
import numpy as np

Window = None
Shader_programm = None
Vao = None
WIDTH = 1280
HEIGHT = 720

# Declaração das variáveis referentes aos pontos e as normais que serão gerados a partir das faces do objeto
pontos = []
normais = []

travarObjeto = 0 # Variável que serve para o usuário apertar somente uma vez a tecla de ação E

luz = [1.0, 1.0, 1.0]
travarLuz = 0

Tempo_entre_frames = 0 #variavel utilizada para movimentar a camera

#Variáveis referentes a câmera virtual e sua projeção

Cam_speed = 5.0 #velocidade da camera
Cam_yaw_speed = 50.0 #velocidade de rotação da câmera em y
Cam_pitch_speed = 50.0 #velocidade de rotação da câmera em x
Cam_pos = np.array([80.0, 25.0, -30.0]) #posicao inicial da câmera
Cam_yaw = 0.0 #ângulo de rotação da câmera em y
Cam_pitch = 0.0 #ângulo de rotação da câmera em x

def redimensionaCallback(window, w, h):
    global WIDTH, HEIGHT
    WIDTH = w
    HEIGHT = h

def inicializaOpenGL():
    global Window, WIDTH, HEIGHT

    #Inicializa GLFW
    glfw.init()

    #Criação de uma janela
    Window = glfw.create_window(WIDTH, HEIGHT, "Trabalho OpenGL", None, None)
    if not Window:
        glfw.terminate()
        exit()

    glfw.set_window_size_callback(Window, redimensionaCallback)
    glfw.make_context_current(Window)

    print("Placa de vídeo: ",OpenGL.GL.glGetString(OpenGL.GL.GL_RENDERER))
    print("Versão do OpenGL: ",OpenGL.GL.glGetString(OpenGL.GL.GL_VERSION))

def inicializaObjetos():

    global Vao, pontos, normais
    # Vao do cubo
    Vao = glGenVertexArrays(1)
    glBindVertexArray(Vao)

    pontos = np.array(pontos, dtype=np.float32)
    pvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, pvbo)
    glBufferData(GL_ARRAY_BUFFER, pontos, GL_STATIC_DRAW)
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, None)

    normais = np.array(normais, dtype=np.float32)
    nvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, nvbo)
    glBufferData(GL_ARRAY_BUFFER, normais, GL_STATIC_DRAW)
    glEnableVertexAttribArray(1)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 0, None)

def inicializaShaders():
    global Shader_programm
    # Especificação do Vertex Shader:
    vertex_shader = """
        #version 400
        layout(location = 0) in vec3 vertex_posicao;
        layout(location = 1) in vec3 vertex_normal;
        out vec3 vertex_posicao_cam, vertex_normal_cam;
        uniform mat4 matriz, viewLado, viewCima, proj;
        void main () {
            vertex_posicao_cam = vec3 (viewLado * viewCima * matriz * vec4 (vertex_posicao, 1.0)); //posição do objeto em relação a CÂMERA
            vertex_normal_cam = vec3 (viewLado * viewCima * matriz * vec4 (vertex_normal, 0.0)); //normais do objeto em relação a CÂMERA
            gl_Position = proj * viewLado * viewCima * matriz * vec4 (vertex_posicao, 1.0);
        }
    """
    vs = OpenGL.GL.shaders.compileShader(vertex_shader, GL_VERTEX_SHADER)
    if not glGetShaderiv(vs, GL_COMPILE_STATUS):
        infoLog = glGetShaderInfoLog(vs, 512, None)
        print("Erro no vertex shader:\n", infoLog)

    # Especificação do Fragment Shader:
    fragment_shader = """
        #version 400
		in vec3 vertex_posicao_cam, vertex_normal_cam;
        
        //propriedades de uma luz pontual
        uniform vec3 luz_posicao;
        uniform vec3 Ls;// luz especular
		uniform vec3 Ld;// luz difusa
		uniform vec3 La;// luz ambiente

        //propriedades de reflexão da superficie
		uniform vec3 Ks;//reflexão especular
		uniform vec3 Kd;//reflexão difusa
		uniform vec3 Ka;//reflexão ambiente
        uniform float especular_exp;//expoente especular
        
        uniform mat4 viewLado;
		out vec4 frag_colour;
		void main () {
            /*
            Cálculo de Intensidade de Luz Ambiente (Ia)
            O cálculo da intensidade de luz ambiente é o mais simples:
            basta multiplicar a cor da luz ambiente pela refletância de luz ambiente da superfície
            */
            vec3 Ia = La * Ka;

            /*
            Cálculo de Intensidade de Luz Difusa (Id)
            Para calcularmos a intensidade de luz difusa, precisamos, primeiramente, 
            calcular a posição da luz em relação a câmera (luz_posicao_cam)
            */
            vec3 luz_posicao_cam = vec3 (viewLado * vec4 (luz_posicao, 1.0));//posicao da luz em relação a câmera
            /*A posição da luz (luz_posicao_cam) calculada acima representa um vetor que sai da origem (0,0,0) e
		aponta para a luz. Para a luz difusa, precisamos calcular um vetor que saia de cada vértice do objeto
		(vertex_posicao_cam) e aponte para essa luz. Para isso, basta calcularmos a diferença entre luz_posicao_cam
		e vertex_posicao_cam.*/
            vec3 luz_vetor_cam = luz_posicao_cam - vertex_posicao_cam;//vetor apontando para a luz em relação a posicao do vértice 
            /*Por fim, normalizamos o vetor da luz em relação ao vértice do objeto e calculamos o cosseno do angulo
		entre o mesmo e a normal da superficie utilizando o produto escalar*/
            vec3 luz_vetor_cam_normalizada = normalize(luz_vetor_cam);//vetor da luz normalizada
            vec3 vertex_normal_cam_normalizada = normalize(vertex_normal_cam);
            float cosseno_difusa = dot(vertex_normal_cam_normalizada,luz_vetor_cam_normalizada);//cosseno do angulo entre o vetor da luz e a normal da superficie
            
            vec3 Id = Ld * Kd * cosseno_difusa;

            /*
            Cálculo de Intensidade de Luz Especular (Is)
            Para o cálculo da intensidade de luz especular, precisamos primeiramente calcular o vetor que representa 
            a luz refletida em relação a normal da superfície */
            vec3 luz_reflexao_vetor_cam = reflect(-luz_vetor_cam_normalizada, vertex_normal_cam_normalizada);
            /*Como a intensidade de luz especular depende da posição da câmera, definimos um vetor que sai da superficie
		    do objeto e aponta para a camera, e então normalizamos, pois utilizaremos ele no cálculo do produto escalar*/
            vec3 superficie_camera_vetor = normalize(-vertex_posicao_cam);
            /*E então calculamos o ângulo entre o vetor de reflexão da luz e o vetor em relação a posicao do observador*/
            float cosseno_especular = dot(luz_reflexao_vetor_cam, superficie_camera_vetor);
            cosseno_especular = max(cosseno_especular, 0.0);//se o cosseno der negativo, atribui 0 para ele
            /*Na intensidade especular, precisamos elevar o cosseno calculado acima ao expoente especular*/
            float fator_especular = pow (cosseno_especular, especular_exp);
            /*E, por fim, calculamos a intensidade de luz especular refletida (Is) */

            vec3 Is = Ls * Ks * fator_especular;

            /*A cor final do fragmento é a soma das 3 componentes de iluminação*/
		    frag_colour = vec4 (Ia+Id+Is,1.0);
		}
    """
    fs = OpenGL.GL.shaders.compileShader(fragment_shader, GL_FRAGMENT_SHADER)
    if not glGetShaderiv(fs, GL_COMPILE_STATUS):
        infoLog = glGetShaderInfoLog(fs, 512, None)
        print("Erro no fragment shader:\n", infoLog)

    # Especificação do Shader Programm:
    Shader_programm = OpenGL.GL.shaders.compileProgram(vs, fs)
    if not glGetProgramiv(Shader_programm, GL_LINK_STATUS):
        infoLog = glGetProgramInfoLog(Shader_programm, 512, None)
        print("Erro na linkagem do shader:\n", infoLog)

    glDeleteShader(vs)
    glDeleteShader(fs)

def transformarObjeto(tx, ty, tz, sx, sy, sz, rx, ry, rz):
    #matriz de translação
    translacao = np.array([
        [1.0, 0.0, 0.0, tx], 
        [0.0, 1.0, 0.0, ty], 
        [0.0, 0.0, 1.0, tz], 
        [0.0, 0.0, 0.0, 1.0]], np.float32)

    #matriz de escala
    escala = np.array([
        [sx, 0.0, 0.0, 0.0], 
        [0.0, sy, 0.0, 0.0], 
        [0.0, 0.0, sz, 0.0], 
        [0.0, 0.0, 0.0, 1.0]], np.float32)

    #matriz de rotação em torno do eixo X
    angulo = np.radians(rx)
    cos, sen = np.cos(angulo), np.sin(angulo)
    rotacaoX= np.array([
        [1.0, 0.0, 0.0, 0.0],
        [0.0, cos, -sen, 0.0],
        [0.0, sen, cos, 0.0],
        [0.0, 0.0, 0.0, 1.0]
    ])

    #matriz de rotação em torno do eixo Y
    angulo = np.radians(ry)
    cos, sen = np.cos(angulo), np.sin(angulo)
    rotacaoY= np.array([
        [cos, 0.0,sen, 0.0],
        [0.0, 1.0, 0.0, 0.0],
        [-sen, 0.0, cos, 0.0],
        [0.0, 0.0, 0.0, 1.0]
    ])

    #matriz de rotação em torno do eixo Z
    angulo = np.radians(rz)
    cos, sen = np.cos(angulo), np.sin(angulo)
    rotacaoZ= np.array([
        [cos, -sen, 0.0, 0.0],
        [sen, cos, 0.0, 0.0],
        [0.0, 0.0, 1.0, 0.0],
        [0.0, 0.0, 0.0, 1.0]
    ])

    #combinacao das rotacoes
    rotacoes = rotacaoZ.dot(rotacaoY.dot(rotacaoX)) #rotação em X primeiro, seguido de Y, seguido de Z

    #matriz de transformação do cubo combinando translação, escala e as 3 rotações
    transformacao = translacao.dot(escala.dot(rotacoes)) #rotacao primeiro, escala em seguida, , translação depois

    #E passamos a matriz para o Vertex Shader.
    transformLoc = glGetUniformLocation(Shader_programm, "matriz")
    glUniformMatrix4fv(transformLoc, 1, GL_TRUE, transformacao)

def especificaMatrizVisualizacao():

    # Especificação da matriz de visualização, que é definida com valores de translação e
	# rotação inversos da "posição" da câmera, pois é o mundo que se movimenta ao redor da
	# câmera, e não a câmera que se movimenta ao redor do mundo.
    visualizacaoLado = np.identity(4)
    visualizacaoCima = np.identity(4)

    # Posicao da camera
    translacaoCamera = np.array([
        [1.0, 0.0, 0.0, -Cam_pos[0]], 
        [0.0, 1.0, 0.0, -Cam_pos[1]], 
        [0.0, 0.0, 1.0, -Cam_pos[2]], 
        [0.0, 0.0, 0.0, 1.0]], np.float32)
    
    # Rotação em Y/yaw
    angulo = np.radians(-Cam_yaw)
    cos, sen = np.cos(angulo), np.sin(angulo)
    rotacaoCameraY = np.array([
        [cos, 0.0, sen, 0.0],
        [0.0, 1.0, 0.0, 0.0],
        [-sen, 0.0, cos, 0.0],
        [0.0, 0.0, 0.0, 1.0]
    ])

    # Rotação em X/pitch
    angulo = np.radians(-Cam_pitch)
    cos, sen = np.cos(angulo), np.sin(angulo)
    rotacaoCameraX = np.array([
        [1.0, 0.0, 0.0, 0.0],
        [0.0, cos, -sen, 0.0],
        [0.0, sen, cos, 0.0],
        [0.0, 0.0, 0.0, 1.0]
    ])

    visualizacaoLado = rotacaoCameraY.dot(translacaoCamera)
    visualizacaoCima = rotacaoCameraX.dot(translacaoCamera)

    transformLocLado = glGetUniformLocation(Shader_programm, "viewLado")
    transformLocCima = glGetUniformLocation(Shader_programm, "viewCima")

    glUniformMatrix4fv(transformLocLado, 1, GL_TRUE, visualizacaoLado)
    glUniformMatrix4fv(transformLocCima, 1, GL_TRUE, visualizacaoCima)

def especificaMatrizProjecao():
    #Especificação da matriz de projeção perspectiva.
    znear = 0.1 #recorte z-near
    zfar = 100.0 #recorte z-far
    fov = np.radians(67.0) #campo de visão
    aspecto = WIDTH/HEIGHT #aspecto

    a = 1/(np.tan(fov/2)*aspecto)
    b = 1/(np.tan(fov/2))
    c = (zfar + znear) / (znear - zfar)
    d = (2*znear*zfar) / (znear - zfar)
    projecao = np.array([
        [a,   0.0, 0.0,  0.0],
        [0.0, b,   0.0,  0.0],
        [0.0, 0.0, c,    d],
        [0.0, 0.0, -1.0, 1.0]
    ])

    transformLoc = glGetUniformLocation(Shader_programm, "proj")
    glUniformMatrix4fv(transformLoc, 1, GL_TRUE, projecao)

def inicializaCamera():
    especificaMatrizVisualizacao()
    especificaMatrizProjecao()

def trataTeclado():
    global Cam_pos, Cam_yaw, Cam_yaw_speed, Cam_pitch, Cam_pitch_speed, Tempo_entre_frames, pontos, normais, travarObjeto, luz, travarLuz

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_ESCAPE)):
        glfw.set_window_should_close(Window, True)

    # Movimentação (W, A, S e D)

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_W)):
        Cam_pos[2] -= Cam_speed * Tempo_entre_frames

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_A)):
        Cam_pos[0] -= Cam_speed * Tempo_entre_frames

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_S)):
        Cam_pos[2] += Cam_speed * Tempo_entre_frames

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_D)):
        Cam_pos[0] += Cam_speed * Tempo_entre_frames

    # Subir/Descer (ESPAÇO e X)

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_SPACE)):
        Cam_pos[1] += Cam_speed * Tempo_entre_frames

    if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_X)):
        Cam_pos[1] -= Cam_speed * Tempo_entre_frames

    # Olhar para cima e para os lados com o mouse

    if (glfw.get_cursor_pos(Window)[0] < int(glfw.get_window_size(Window)[0])/3):
        Cam_yaw += Cam_yaw_speed * Tempo_entre_frames

    if (glfw.get_cursor_pos(Window)[0] > int(glfw.get_window_size(Window)[0])/1.7):
        Cam_yaw -= Cam_yaw_speed * Tempo_entre_frames

    if (glfw.get_cursor_pos(Window)[1] < int(glfw.get_window_size(Window)[1])/3):
        if (Cam_pitch <= 40):
            Cam_pitch += Cam_pitch_speed * Tempo_entre_frames

    if (glfw.get_cursor_pos(Window)[1] > int(glfw.get_window_size(Window)[1])/1.3):
        if (Cam_pitch >= -20):
            Cam_pitch -= Cam_pitch_speed * Tempo_entre_frames

    # Interação com a cena/objetos (Quebrar o vaso)

    if ((glfw.PRESS == glfw.get_key(Window, glfw.KEY_E) and (travarObjeto == 0))):
        pontos = []
        normais = []
        travarObjeto = 1

        carregarObjeto("obj/casa")
        carregarObjeto("obj/mesa")
        carregarObjeto("obj/vasoQuebrado")
        carregarObjeto("obj/lixeira")
        inicializaObjetos()

    # Interação com uma fonte de luz (ligar/desligar)

    if ((glfw.PRESS == glfw.get_key(Window, glfw.KEY_C) and (travarLuz == 1))):
        luz = [1.0, 1.0, 1.0]
        travarLuz = 0

    if ((glfw.PRESS == glfw.get_key(Window, glfw.KEY_V) and (travarLuz == 0))):
        luz = [0.0, 0.0, 0.0]
        travarLuz = 1

def especificaMaterialObjeto(KaR, KaG, KaB, KdR, KdG, KdB, KsR, KsG, KsB, n):
    global Shader_programm
    #Coeficiente de reflexão ambiente
    Ka = np.array([KaR, KaG, KaB])#reflete 100% da luz ambiente
    Ka_loc = glGetUniformLocation(Shader_programm, "Ka")
    glUniform3fv(Ka_loc, 1, Ka)

    #Coeficiente de reflexão difusa
    Kd = np.array([KdR, KdG, KdB])#reflete luz difusa laranja
    Kd_loc = glGetUniformLocation(Shader_programm, "Kd")
    glUniform3fv(Kd_loc, 1, Kd)

    #Coeficiente de reflexão especular
    Ks = np.array([KsR, KsG, KsB])#reflete 100% da luz especular
    Ks_loc = glGetUniformLocation(Shader_programm, "Ks")
    glUniform3fv(Ks_loc, 1, Ks)

    #expoente expecular
    especular_exp = n
    especular_exp_loc = glGetUniformLocation(Shader_programm, "especular_exp")
    glUniform1f(especular_exp_loc, especular_exp)

def especificaLuz():
    global Shader_programm, luz
    #posição da luz
    luz_posicao = np.array([80.0, 100.0, -30.0])
    luz_posicaoloc = glGetUniformLocation(Shader_programm, "luz_posicao")#envia o array da posição da luz para o shader
    glUniform3fv(luz_posicaoloc, 1, luz_posicao)

    #Fonte de luz ambiente
    La = np.array([0.2, 0.2, 0.2])
    La_loc = glGetUniformLocation(Shader_programm, "La")#envia o array da Luz Ambiente para o shader
    glUniform3fv(La_loc, 1, La)

    #Fonte de luz difusa
    Ld = np.array(luz)
    Ld_loc = glGetUniformLocation(Shader_programm, "Ld")#envia o array da Luz Difusa para o shader
    glUniform3fv(Ld_loc, 1, Ld)
    
    #Fonte de luz especular
    Ls = np.array([1.0, 1.0, 1.0])
    Ls_loc = glGetUniformLocation(Shader_programm, "Ls")#envia o array da Luz Especular para o shader
    glUniform3fv(Ls_loc, 1, Ls)

def inicializaRenderizacao():
    global Window, Shader_programm, Vao, WIDTH, HEIGHT, Tempo_entre_frames, pontos

    tempo_anterior = glfw.get_time()

    #Ativação do teste de profundidade. Sem ele, o OpenGL não sabe que faces devem ficar na frente e que faces devem ficar atrás.
    glEnable(GL_DEPTH_TEST)
    while not glfw.window_should_close(Window):
        #calcula quantos segundos se passaram entre um frame e outro
        tempo_frame_atual = glfw.get_time()
        Tempo_entre_frames = tempo_frame_atual - tempo_anterior
        tempo_anterior = tempo_frame_atual

        #limpa a tela e os buffers
        glClearColor(0.2, 0.3, 0.3, 1.0)        
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        
        #configura a viewport para pegar toda a janela
        glViewport(0, 0, WIDTH, HEIGHT)

        #ativa o shader
        glUseProgram(Shader_programm)
        especificaLuz() #parâmetros da fonte de luz
                                
        inicializaCamera()#configuramos a câmera
        glBindVertexArray(Vao) #ativamos o objeto (cubo) que queremos renderizar

        #                         Cor ambiente   Cor difusa    Cor especular  n 
        especificaMaterialObjeto(1.0, 1.0, 1.0, 0.2, 0.2, 0.2, 0.1, 0.1, 0.1, 1) # Parâmetros do material do objeto
        transformarObjeto(0,0,0,1,1,1,0,0,0) # Modifica os parâmetros de transformações geométricas para o objeto
        glDrawArrays(GL_TRIANGLES, 0, len(pontos)) # Renderiza o objeto

        glfw.poll_events()

        glfw.swap_buffers(Window)
        
        trataTeclado()
    
    glfw.terminate()

def carregarObjeto(objeto):
    # Variáveis referentes aos pontos e as normais que serão gerados a partir das faces do objeto
    global pontos, normais

    vertices = [] # Lista para alocar todos os vértices
    verticesNormais = [] # Lista para alocar todos os vértices normais

    facesVertices = [] # Lista para alocar todas as faces dos vértices
    facesNormais = [] # Lista para alocar todas as faces das normais

    arquivo = open(objeto + ".obj", "r") # Abre um arquivo .obj no modo leitura

    while True:
        linha = arquivo.readline() # Lê linha por linha do arquivo

        if (linha == ""): # Se for EOF sai do loop
            arquivo.close()
            break
        elif (linha[0:1] == "f"): # Se tiver f na linha entra nessa condição
            tipo = 0
            aux = ""
            for i in range(len(linha)): # Lê carácter por carácter da linha
                if ((linha[i] != "f") and (linha[i] != "\n")): # Se o carácter for f ou \n não entra
                    if ((linha[i] != "/") and (linha[i] != " ")): # Concatena a string até encontrar uma / ou um espaço em branco (serve para se as faces tiverem mais de 1 casa)
                        aux += linha[i]
                    else: # Se encontrou uma / ou um espaço em branco despeja a string concatenada na lista, limpa o auxiliar e altera o tipo (Vértice ou Normal)
                        if ((tipo == 0) and (aux != "")): # Vértice
                            facesVertices.append(aux)
                            tipo = 1
                            aux = ""
                        elif ((tipo == 1) and (aux != "")): # Normal
                            facesNormais.append(aux)
                            tipo = 0
                            aux = ""
            facesNormais.append(aux)
        elif (linha[0:2] == "v "): # Se tiver v na linha entra nessa condição
            vertices.append(linha[1:].split())
        elif (linha[0:2] == "vn"): # Se tiver vn na linha entra nessa condição
            verticesNormais.append(linha[2:].split())

    for i in facesVertices:
        tmp = vertices[int(i)-1]
        pontos += [tmp[0], tmp[1], tmp[2]]
    for i in facesNormais:
        tmp = verticesNormais[int(i)-1]
        normais += [tmp[0], tmp[1], tmp[2]]

# Função principal
def main():
    carregarObjeto("obj/casa")
    carregarObjeto("obj/mesa")
    carregarObjeto("obj/vasoFlor")
    carregarObjeto("obj/lixeira")

    inicializaOpenGL()
    inicializaObjetos()
    inicializaShaders()
    inicializaRenderizacao()

if __name__ == "__main__":
    main()