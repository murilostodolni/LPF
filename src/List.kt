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

//comprimir
fun comprimir(l: List): List = when(l){
	is Node -> auxComprimir(l.prox, l.info)
	else -> Nil
}

fun auxComprimir(l1: List, i: Int): List = when{
	l1 is Node -> if (l1.info == i) Node(l1.info, auxComprimir(l1.prox, i)) else auxComprimir(l1.prox, l1.info)
	else -> Nil
}

fun main(args: Array<String>) {
	val lista = Node(1, Node(2, Node(3, Nil)))
	val lista1 = Node(1, Node(5, Node(5, Node(6, Node(6, Node(7, Nil))))))

	//val listdList = listdList(Node(1, Node(2, Node(3, Nil))), listdList(Node(5, Node(5, Node(6, Node(6, Node(7, Nil))))), Nil))
 
	println(concatenar(lista, lista1))
 
	println(tamanho(lista))
	println(tamanho(lista1))
 
	println(get(lista, 3))
 
	println(reverso(lista))
 
	println(palindromo(lista1))
 
	println(comprimir(lista1))
 
	
}