'''
3. Implemente uma aplicação que leia pelo teclado o raio de um círculo (r) e um ponto (x,y), 
e apresente na tela se o ponto está dentro ou fora do círculo. Considere que o ponto central do círculo está na origem.
'''

import math

raioCirculo = int(input('Digite o raio do circulo: '))
x = int(input('Digite o ponto x: '))
y = int(input('Digite o ponto y: '))

raio = raioCirculo

pontoCentral = 0

if (math.pow(x,2) + math.pow(y,2)) > math.sqrt(raio):
  print("\nO ponto está fora do círculo.")
else:
  print("\nO ponto está dentro do círculo.")
