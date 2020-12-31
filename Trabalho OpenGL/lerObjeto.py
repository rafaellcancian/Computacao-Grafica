vertices = []
verticesNormais = []

facesVertices = []
facesNormais = []

arquivo = open("obj/cubo.obj", "r")

while True:
    linha = arquivo.readline()

    if (linha == ""):
        arquivo.close()
        break
    elif (linha[0:1] == "f"):
        tipo = 0
        aux = ""
        for i in range(len(linha)):
            if ((linha[i] != "f") and (linha[i] != "\n")):
                if ((linha[i] != "/") and (linha[i] != " ")):
                    aux += linha[i]
                else:
                    if ((tipo == 0) and (aux != "")): # Vértice
                        facesVertices.append(aux)
                        tipo = 1
                        aux = ""
                    elif ((tipo == 1) and (aux != "")): # Normal
                        facesNormais.append(aux)
                        tipo = 0
                        aux = ""
        facesNormais.append(aux)
    elif (linha[0:2] == "v "):
        vertices.append(linha[1:].split())
    elif (linha[0:2] == "vn"):
        verticesNormais.append(linha[2:].split())

print(facesVertices, "\n")
print(facesNormais)

pontos = []

for i in facesVertices:
    tmp = vertices[int(i)-1]
    pontos += [tmp[0], tmp[1], tmp[2]]

normais = []

for i in facesNormais:
    tmp = verticesNormais[int(i)-1]
    normais += [tmp[0], tmp[1], tmp[2]]
