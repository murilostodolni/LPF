abstract class Lista<out T>

data class NoLista<T> (val info: T, val prox: Lista<T>): Lista<T>()

object Null: Lista <Nothing>()

fun menorDeDois(x: Int, y: Int) = if(x<y) x else y

// fun menorDeTres(x: Int, y: Int, z: Int) =

fun fatorial(x: Int): Int = if(x == 1) 1 else x * fatorial(x-1)

fun <T> get(l: Lista<T>, x: Int): T? = when {
	l is NoLista && x != 0 -> get(l, x-1)
	l is NoLista && x == 0 -> l.info
	else -> null
}

fun <T> contains(l: Lista<T>, elem: T): Boolean = when{
	l is NoLista -> if(l.info == elem) true else contains(l.prox, elem)
	else -> false
}

fun <T> length(l: Lista<T>): Int = when(l){
	is NoLista -> 1 + length(l.prox)
	else -> 0
}

fun maiorDeDois(x: Int, y: Int): Int = if(x>y) x else y

fun maiorElem(l: Lista<Int>): Int = when(l){
	is NoLista -> maiorDeDois(l.info, maiorElem(l.prox))
	else -> 0
}

fun <T> ocorrencias(l: Lista<T>, x: T): Int = when{
	l is NoLista && l.info == x -> 1 + ocorrencias(l.prox, x)
	else -> 0
}

fun <T> unicaOcorrencia(l: Lista<T>, elem: T): Boolean = ocorrencias(l, elem) == 1

fun maiorQue(l: Lista<Int>, x: Int): Lista<Int> = when {
	l is NoLista -> if(l.info > x) NoLista(l.info, maiorQue(l.prox, x)) else maiorQue(l.prox, x)
	else -> Null
}

fun <T> concatena(l1: Lista<T>, l2: Lista<T>): Lista<T> = when(l1){
	is NoLista -> NoLista(l1.info, concatena(l1.prox, l2))
	else -> l2
}

fun <T> removeOcorrencia(l:Lista<T>, elem: T): Lista <T> = when{
	l is NoLista -> if(l.info == elem) l.prox else NoLista(l.info, removeOcorrencia(l, elem))
	else -> Null
}

fun <T> removeUltimo(l: Lista<T>): Lista<T> = when (l){
	is NoLista -> if(l.prox is Null) removeUltimo(l.prox) else NoLista(l.info, removeUltimo(l.prox))
	else -> Null
}

fun <T> removeOcorrencias(l:Lista<T>, elem: T): Lista <T> = when(l){
	is NoLista -> if(l.info == elem) removeOcorrencias(l.prox, elem) else NoLista(l.info, removeOcorrencias(l.prox, elem))
	else -> Null
}

fun <T> removeTodasOco(l: Lista<T>) : Lista<T> = when(l){
	is NoLista -> NoLista(l.info, removeTodasOco(removeOcorrencias(l.prox, l.info)))
	else -> Null
}




fun main(args: Array<String>) {
	val no = NoLista(7, NoLista(4, NoLista(3, NoLista(5, NoLista(7, NoLista(4, NoLista(4, NoLista(6, NoLista(7, Null)))))))))

	println(removeTodasOco(no))
	println(maiorQue(no, 5))
}