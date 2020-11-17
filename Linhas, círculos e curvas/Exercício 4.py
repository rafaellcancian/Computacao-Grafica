'''
4. Desenvolva uma aplicação para geração de um circuíto automotivo a partir de 4 curvas de Bézier. 
Para isso, inicialmente gere aleatoriamente os 13 pontos que fazem parte da curva (P0, P1, P2... P12), 
sendo que P0, P3, P6, P9 e P12 são os pontos de ligação entre as curvas (e que P0 = P12, de modo a ser um circuíto fechado), 
e os demais são pontos de controle. Após, defina a quantidade de segmentos a curva terá e então calcule os pontos que farão parte da mesma, apresentando o resultado na tela.
'''

import random

aux = 0

pontoInicialX = random.randint(-10, 10)
pontoInicialY = random.randint(-10, 10)

Pon0x = pontoInicialX + random.randint(-5, 5)
Pon0y = pontoInicialY + random.randint(-5, 5)
Pon1x = Pon0x + random.randint(-5, 5)
Pon1y = Pon0y + random.randint(-5, 5)
Pon2x = Pon1x + random.randint(-5, 5)
Pon2y = Pon1y + random.randint(-5, 5)
Pon3x = Pon2x + random.randint(-5, 5)
Pon3y = Pon2y + random.randint(-5, 5)
Pon4x = Pon3x + random.randint(-5, 5)
Pon4y = Pon3y + random.randint(-5, 5)
Pon5x = Pon4x + random.randint(-5, 5)
Pon5y = Pon4y + random.randint(-5, 5)
Pon6x = Pon5x + random.randint(-5, 5)
Pon6y = Pon5y + random.randint(-5, 5)
Pon7x = Pon6x + random.randint(-5, 5)
Pon7y = Pon6y + random.randint(-5, 5)
Pon8x = Pon7x + random.randint(-5, 5)
Pon8y = Pon7y + random.randint(-5, 5)
Pon9x = Pon8x + random.randint(-5, 5)
Pon9y = Pon8y + random.randint(-5, 5)
Pon10x = Pon9x + random.randint(-5, 5)
Pon10y = Pon9y + random.randint(-5, 5)

while aux < 4:
  if aux == 0:
    P0x = pontoInicialX
    P0y = pontoInicialY
    P1x = Pon0x
    P1y = Pon0y
    P2x = Pon1x
    P2y = Pon1y
    P3x = Pon2x
    P3y = Pon2y
  elif aux == 1:
    P0x = Pon2x
    P0y = Pon2y
    P1x = Pon3x
    P1y = Pon3y
    P2x = Pon4x
    P2y = Pon4y
    P3x = Pon5x
    P3y = Pon5y
  elif aux == 2:
    P0x = Pon5x
    P0y = Pon5y
    P1x = Pon6x
    P1y = Pon6y
    P2x = Pon7x
    P2y = Pon7y
    P3x = Pon8x
    P3y = Pon8y
  else:
    P0x = Pon8x
    P0y = Pon8y
    P1x = Pon9x
    P1y = Pon9y
    P2x = Pon10x
    P2y = Pon10y
    P3x = pontoInicialX
    P3y = pontoInicialY
  
  t = 0

  while t <= 1:
      x = ((1 - t) * (1 - t) * (1 - t) * P0x) + (3 * (1 - t) * (1 - t) * t * P1x) + (3 * (1 - t) * t * t * P2x) + (t * t * t * P3x)
      y = ((1 - t) * (1 - t) * (1 - t) * P0y) + (3 * (1 - t) * (1 - t) * t * P1y) + (3 * (1 - t) * t * t * P2y) + (t * t * t * P3y)

      print("(" , x , "," , y , ")")
      t += 0.01

  aux = aux + 1
