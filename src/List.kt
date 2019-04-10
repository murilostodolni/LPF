abstract class List

data class Node(val info: Int, val prox: List): List()

object Nil: List()

//tamanho da list
fun tamanho(l: List): Int = when (l){
	is Node -> 1 + tamanho(l.prox)
	else -> 0
}

//concatenar
fun concatenar(l1: List, l2: List): List = when(l1){
	is Node -> Node(l1.info, concatenar(l1.prox, l2))
	else -> l2
}

//get
fun get(l: List, pos: Int): Int? = when {
	l is Node && pos != 0 -> get(l.prox, pos-1)
	l is Node && pos == 0 -> l.info
	else -> null
}

//reserso
fun reverso(l: List): List = when(l){
	is Node -> concatenar(reverso(l.prox), Node(l.info, Nil))
	else -> Nil
}

//palindromo
fun palindromo(l: List):Boolean = l == reverso(l)

fun main(args: Array<String>) {
	val lista = Node(1, Node(2, Node(3, Node(4, Nil))))
	val lista1 = Node(5, Node(6, Node(5, Nil)))
 
	println(concatenar(lista, lista1))
 
	println(tamanho(lista))
	println(tamanho(lista1))
 
	println("Tamnho da Lista: ${get(lista, 3)}")
 
	println(reverso(lista))
 
	println(palindromo(lista))
 
	
}