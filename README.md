
QUESTOES DA CLASSE Ativ40questoes
Exerc�cios de Programa��o Funcional
Os itens est�o mais ou menos em ordem de dificuldade.
1. menorDeDois: recebe dois valores e retorna o menor
2. menorDeTres: recebe tr�s valores e retorna o menor
3. fatorial: recebe um numero natural e retorna o seu fatorial
4. fibonacci: recebe um n�mero inteiro positivo e retorna o n-�simo elemento da seq��ncia de
Fibonacci (especificar no programa se sua seq��ncia come�a com 0 e 1 ou com 1 e 1)
5. elemento: recebe uma lista e um n�mero inteiro positivo para retornar o n-�simo elemento
da lista
ex.: (elemento 1 '(3 7 4 2)) ==> 3
6. pertence: recebe uma lista e um elemento qualquer e verifica se o elemento pertence �
lista
ex.: pertence 1 [3,7,4,2] = False
7. nro-elementos: recebe uma lista qualquer e retorna o n�mero de elementos na lista
obs.: n�o usar a fun��o length
8. maior: recebe uma lista de n�meros e retorna o maior
obs.: n�o usar a fun��o max
9. conta-ocorrencias: recebe um elemento e uma lista qualquer, retorna o n�mero de
ocorr�ncias do elemento na lista
10. unica-ocorrencia: recebe um elemento e uma lista e verifica se existe uma �nica ocorr�ncia
do elemento na lista
ex.:
unica-ocorrencia 2 [1,2,3,2] = False
unica-ocorrencia 2 [3,1] = False
unica-ocorrencia 2 [2] = True
11. maiores-que: recebe um n�mero e uma lista de n�meros, retorna uma lista com os
n�meros que s�o maiores que o fornecido
ex.:
(maiores-que 10 '(4 6 30 3 15 3 10 7)) ==> (30 15)
12. concatena: recebe duas listas quaisquer e retorna uma terceira lista com os elementos da
primeira no in�cio e os elementos da segunda no fim
ex.:
(concatena '() '()) ==> ()
(concatena '(1 2) '(3 4)) ==> (1 2 3 4)
13. remover: recebe um elemento e uma lista e retorna a lista sem a primeira ocorr�ncia do
elemento
14. remover-ultimo: recebe uma lista e remove o �ltimo elemento da lista
15. remover-repetidos: recebe uma lista e retorna outra lista sem repeti��o de elementos
ex.:
(remover-repetidos '(7 4 3 5 7 4 4 6 4 1 2)) ==> (7 4 3 5 6 1 2)
16. maiores: recebe um numero natural n e uma lista de n�meros, retorna uma lista com os n
maiores n�meros sem alterar a ordem entre os elementos
ex.:
(maiores 4 '(9 3 5 7 8 4 4 7)) ==> (9 7 8 7)
17. gera-sequencia: recebe um n�mero inteiro n positivo e retorna a lista (1 -1 2 -2 3 -3 ... n
-n)
18. inverte: recebe uma lista e retorna outra, que cont�m os mesmos elementos da primeira,
em ordem invertida
19. divide: recebe uma lista e um n�mero natural n, retorna um par onde o primeiro elemento �
uma lista com os n primeiros n�meros da lista original e o segundo elemento � uma lista
com o resto dos elementos da lista original
ex.:
(divide '(1 2 3 4) 0) ==> (() 1 2 3 4)
(divide '(1 2 3 4) 2) ==> ((1 2) 3 4)
20. intercala: recebe duas listas e retorna outra lista com os elementos das listas originais
intercalados.
ex.:
(intercala '(1 2 3) '(8 9)) ==> (1 8 2 8 3)
(intercala '() '(1 2 6)) ==> (1 2 6)
21. uniao: recebe duas listas que n�o contenham elementos repetidos e retorna uma nova com
todos os elementos das duas listas originais (sem repeti��o)
ex.:
(uniao '(3 6 5 7) '(2 9 7 5 1)) ==> (3 6 5 7 2 9 1)
22. interseccao: recebe duas listas sem elementos repetidos e retorna uma lista com os
elementos que s�o comuns �s duas
ex.:
(interseccao '(3 6 5 7) '(9 7 5 1 3)) ==> (3 5 7)
23. sequencia: recebe dois numeros naturais n e m, e retorna uma lista com n elementos, onde
o primeiro � m, o segundo � m+1, etc...
ex.:
(sequencia 0 2) ==> ( ) (sequencia 3 4) ==> (4 5 6)
24. insere-ordenado: recebe uma lista de n�meros em ordem crescente e um n�mero
qualquer, retorna uma lista de n�meros em ordem crescente com os elementos da lista
inicial mais o n�mero passado.
25. ordenado?: recebe uma lista de n�meros e verifica se eles est�o ordenados ou n�o
26. ordena: recebe uma lista com n�meros e retorna outra lista com os n�meros ordenados
ex.:
(ordena '(7 3 5 7 8 4 4)) ==> (3 4 4 5 7 7 8)
27. rodar-esquerda: recebe um n�mero natural, uma lista e retorna uma nova lista onde a
posi��o dos elementos mudou como se eles tivessem sido "rodados"
ex.:
(rodar-esquerda 0 '(a s d f g)) ==> (a s d f g) (rodar-esquerda 1 '(a s d f g)) ==> (s d f
g a)
(rodar-esquerda 3 '(a s d f g)) ==> (f g a s d) (rodar-esquerda 4 '(a s d f g)) ==> (g a s
d f)
28. rodar-direita: recebe um n�mero natural, uma lista e retorna uma nova lista onde a posi��o
dos elementos mudou como se eles tivessem sido "rodados"
ex.:
(rodar-direita 0 '(a s d f g)) ==> (a s d f g)
(rodar-direita 1 '(a s d f g)) ==> (g a s d f)
(rodar-direita 3 '(a s d f g)) ==> (d f g a s)
(rodar-direita 4 '(a s d f g)) ==> (s d f g a)
29. todas-maiusculas: Recebe uma string qualquer e retorna outra string onde todas as letras
s�o mai�sculas. Pode ser �til saber os seguintes c�digos ASCII: a=97, z=122, A=65, Z=90,
0=48, 9=57, espa�o=32.
ex.: todas-maiusculas "abc 123" = "ABC 123"
30. primeiras-maiusculas: recebe uma string qualquer e retorna outra string onde somente as
iniciais s�o ma�usculas
ex.:
(primeiras-maiusculas "FuLaNo bElTrAnO silva") ==>
"Fulano Beltrano Silva"
31. seleciona: recebe uma lista qualquer e uma lista de posi��es, retorna uma lista com os
elementos da primeira que estavam nas posi��es indicadas
ex.:
(seleciona '(a b c d e f) '(0 3 2 3)) ==> (a d c d)
32. palindrome?: recebe uma string e verifica se ela � uma pal�ndrome ou nao
ex.:
(palindrome? "ana") ==> #t
(palindrome? "abbccbba") ==> #t
(palindrome? "abbdbbaa") ==> #f
33. primo?: verifica se um n�mero � primo ou n�o
34. soma-digitos: recebe um n�mero natural e retorna a soma de seus d�gitos
ex.:
(soma-digitos 328464584658) ==> 63
35. bolha: recebe uma lista de n�meros e retorna a lista ordenada, pelo m�todo da bolha
(bolha burra)
36. compactar: recebe uma lista de n�meros e transforma todas as repeti��es em sub-listas de
dois elementos: sendo o primeiro elemento o n�mero de repeti��es encontradas e o
segundo elemento � o n�mero que repete na lista original. Os n�meros que n�o repetem
na lista original n�o devem ser alterados.
ex.:
(compactar '(2 2 2 3 4 4 2 9 5 2 4 5 5 5)) ==> ((3 2) 3 (2 4) 2 9 5 2 4 (3 5))
Em Haskell, como n�o � poss�vel implementar listas heterog�neas, a fun��o deve retornar
uma lista de listas. Ex.:
compactar [2,2,2,3,4,4,2,9,5,2,4,5,5,5] = [[3,2],[3],[2,4],[2],[9],[5],[2],[4],[3,5]]
37. Fa�a um programa que dada uma lista, retorne uma tupla lista-lista (de inteiros) onde a
lista da esquerda cont�m os n�meros impares e a lista da direita os n�meros pares
ex:
func :: [Int] -> ([Int],[Int])
[1,2,3,4,5,6,7] => ([1,3,5,7],[2,4,6])
38. Dizemos que um quadrado perfeito � um numero cuja raiz quadrada � um n�mero inteiro.
Sabemos o que a raiz quadrada � um c�lculo lento quando comparado � opera��es como
adi��o ou multiplica��o. Implemente uma fun��o que verifica se um n�mero � um
quadrado perfeito sem usar uma fun��o que calcula raiz quadrada.
39. Fa�a um programa que encontra a representa��o de um n�mero natural numa base b
qualquer (1 < b < 37). Exemplo:
(muda_base 17 2) ==> "10001"(muda_base 26 16) ==> "1A"
40. O conjunto de todos os subconjuntos de um segundo conjunto � denominado conjuntos
das partes desse segundo conjunto. Fa�a um programa que encontra o conjunto das
partes de uma lista. Exemplo:
partes [2,3,2,31] = [[],[2],[3],[31],[2,2],[2,3],[2,31],[3,31],[2,2,3],[2,2,31],[2,3,31],[2,2,3,31]]