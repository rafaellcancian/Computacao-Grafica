'''
1. Desenvolva uma aplicação em que o usuário insere os pontos referentes aos vértices 
de um triângulo (P0, P1 e P2), e então calcule, de acordo com um dos algoritmos de rasterização de linhas, os pontos que fazem parte das arestas do triângulo especificado.
'''

Ponto0x = int(input('Digite o x do vértice P0 do triângulo: '))
Ponto0y = int(input('Digite o y do vértice P0 do triângulo: '))
Ponto1x = int(input('Digite o x do vértice P1 do triângulo: '))
Ponto1y = int(input('Digite o y do vértice P1 do triângulo: '))
Ponto2x = int(input('Digite o x do vértice P2 do triângulo: '))
Ponto2y = int(input('Digite o y do vértice P1 do triângulo: '))

controlador = 0

while controlador < 3:
  if controlador == 0:
    P0x = Ponto0x
    P0y = Ponto0y
    P1x = Ponto1x
    P1y = Ponto1y
    print('\nP0 até P1:')
  elif controlador == 1:
    P0x = Ponto0x
    P0y = Ponto0y
    P1x = Ponto2x
    P1y = Ponto2y
    print('\nP0 até P2:')
  else:
    P0x = Ponto1x
    P0y = Ponto1y
    P1x = Ponto2x
    P1y = Ponto2y
    print('\nP1 até P2:')

  deltaX = P1x - P0x
  deltaY = P1y - P0y

  if deltaX == 0:
      print("A reta é vertical.")
      y = P0y
      while y <= P1y:
          print(P0x , " , " , y)
          y = y + 1
  else:
      m = deltaY/deltaX
      b = P0y - m * P0x
      print("m = " , m)
      print("b = " , b)
      if m <= 1:
          print("A reta está mais deitada.")
          x = P0x
          while(x <= P1x):
              y = m * x + b
              print(x , " , " , round(y))
              x = x + 1
      elif m > 1:
          print("A reta está mais de pé.")
          y = P0y
          while(y <= P1y):
              x = (y - b) / m
              print(round(x) , " , " , y)
              y = y + 1
  controlador = controlador + 1
