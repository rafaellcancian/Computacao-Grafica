'''
2. Escolha um dos algoritmos de rasterização de círculos. Está aplicação deverá:

- Pedir para o usuário informar o valor do raio do círculo (r);
- Pedir para o usuário informar o ponto central do círculo;
- A partir do raio e do ponto central, gerar os pontos (x,y) que formam o círculo e apresentar os mesmos na tela.
'''

import math

raioCirculo = int(input('Digite o raio do circulo: '))
pontoCentralCirculo = int(input('Digite o ponto central do circulo: '))

raio = raioCirculo

x = pontoCentralCirculo
limite = raio * math.cos(math.radians(45))

while x <= limite:
    y = math.sqrt(raio*raio - x*x)
    yArredondado = round(y)
    print("(" , x , "," , yArredondado , ")")
    print("(" , yArredondado , "," , x , ")")
    print("(" , yArredondado , "," , -x , ")")
    print("(" , x , "," , -yArredondado , ")")
    print("(" , -x , "," , -yArredondado , ")")
    print("(" , -yArredondado , "," , -x , ")")
    print("(" , -yArredondado , "," , x , ")")
    print("(" , -x , "," , yArredondado , ")")
    x += 1
