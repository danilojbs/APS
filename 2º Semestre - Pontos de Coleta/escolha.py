from d_mat import distancia

def iniciar(longit, lat):
    executando = True
    while(executando): #escolhas de materias
    
        print('\n1 - Metal')
        print('2 - Vidro')
        print('3 - Plástico')
        print('4 - Papel')
        print('5 - Finalizar')
        resposta = int(input('\nEscolha uma opção: '))
        if(resposta == 1):
            distancia(longit,lat,'metal')
            executando = escolher()
        if(resposta == 2):
            distancia(longit,lat,'vidro')
            executando = escolher()
        if(resposta == 3):
            distancia(longit,lat,'plastico')
            executando = escolher()
        if(resposta == 4):
            distancia(longit,lat,'papel')
            executando = escolher()
        if(resposta == 5):
            print('\nObrigado por utilizar nosso Sistema.\n')
            executando = False


def escolher(): 
    while True: 
        print('1 - Escolher outro tipo de material')
        print('2 - Finalizar')
        resposta = int(input('\nEscolha uma opção: '))
    
        if resposta == 1:
            return True
        if resposta == 2:
            print('\nObrigado por utilizar nosso Sistema.\n')
            return False
        else:
            print('\nOpção inválida.')