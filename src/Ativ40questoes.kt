abstract class Lista<out T>

data class NoLista<T> (val info: T, val prox: Lista<T>): Lista<T>()

object Null: Lista<Nothing>()

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

//questao 11
fun maiorQue(l: Lista<Int>, x: Int): Lista<Int> = when {
	l is NoLista -> if(l.info > x) NoLista(l.info, maiorQue(l.prox, x)) else maiorQue(l.prox, x)
	else -> Null
}

//questao 12
fun <T> concatena(l1: Lista<T>, l2: Lista<T>): Lista<T> = when(l1){
	is NoLista -> NoLista(l1.info, concatena(l1.prox, l2))
	else -> l2
}

fun <T> removeOcorrencia(l:Lista<T>, elem: T): Lista <T> = when{
	l is NoLista -> if(l.info == elem) l.prox else NoLista(l.info, removeOcorrencia(l.prox, elem))
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

fun <T> diminui(inicio: Int, fim: Int, l: Lista<T>): Lista<T> = when{
	l is NoLista && inicio < 1 && fim > -1 -> NoLista(l.info, diminui(inicio-1, fim-1, l.prox))
	l is NoLista -> diminui(inicio-1, fim-1, l.prox)
	else -> Null
}

//questao 16 -> igual a questao 11

//questao 17
fun geraSequencia(num: Int): Lista<Int> = when {
	num > 0 -> {
		val n = -1*num
	NoLista(num, NoLista(n, geraSequencia(num-1)))
	}
	else -> Null
}

//questao 18
fun <T> inverte(l: Lista<T>): Lista<T> = when(l){
	is NoLista -> concatena(inverte(l.prox), NoLista(l.info, Null))
	else -> Null
}

//FAZER questao 19

//questao 20
fun <T> intercala(l1: Lista<T>, l2: Lista<T>): Lista<T> = when(l1){
	is NoLista -> NoLista(l1.info, intercala(l2, l1.prox))
	else -> l2
}

//questao 21
fun <T> uniao(l1: Lista<T>, l2: Lista<T>): Lista<T> = when(l1){
	is NoLista -> NoLista(l1.info, uniao(l1.prox, removeOcorrencia(l2, l1.info)))
	else -> l2
}

//questao 22
fun <T> interseccao(l1: Lista<T>, l2: Lista<T>): Lista<T> = when(l1){
	is NoLista -> if(contains(l2, l1.info)) NoLista(l1.info, interseccao(l1.prox, l2)) else interseccao(l1.prox, l2)
	else -> Null
}

//questao 23
fun sequencia(n: Int, m: Int): Lista<Int> = when{
	n > 0 -> NoLista(m, sequencia(n-1, m+1))
	else -> Null
}

//questao 24

fun insereOrdenado(l: Lista<Int>, num: Int): Lista<Int> = when(l){
	is NoLista -> if(l.info > num) NoLista(num, l) else NoLista(l.info, insereOrdenado(l.prox, num))
	else -> NoLista(num, l)
}

// FAZER questao 25

//questao 26
fun ordena(l: Lista<Int>): Lista<Int> = when {
	l is NoLista -> insereNaOrdem(ordena(l.prox), l.info)
	else -> Null
}
//aux para questao 26
fun insereNaOrdem(l: Lista<Int>, n: Int): Lista<Int> = when(l){
	is NoLista -> if(n > l.info) NoLista(l.info, insereNaOrdem(l.prox, n)) else NoLista(n, l)
	else -> NoLista(n, Null)
}

// questao 27
fun <T>rodarEsquerda(l: Lista<T>, num: Int): Lista<T> = when{
	l is NoLista && num == 0 -> l
	l is NoLista && num > 0 -> concatena(rodarEsquerda(l.prox, num-1), NoLista(l.info,Null))
	else -> Null
}


//questao da prova		
fun <T> verificaSequencia(l1: Lista<T>, l2: Lista<T>): Boolean = when {
	l1 is NoLista && l2 is NoLista -> if(l1.info == l2.info) verificaSequencia(l1.prox, l2.prox) else verificaSequencia(l1.prox, l2)
	l2 is Null -> true
	else -> false
}

fun main(args: Array<String>) {
	//val no = NoLista(7, NoLista(4, NoLista(3, NoLista(5, NoLista(7, NoLista(4, NoLista(4, NoLista(6, NoLista(7, Null)))))))))

	//println(removeTodasOco(no))
	//println(maiorQue(no, 5))
 
	val l = NoLista(4, NoLista(2, NoLista(1, NoLista(3, Null))))
	val l1 = NoLista(6, NoLista(7, Null))
 
	//println(diminui(1, 4, l))
 
	//println(intercala(l, l1))
	//println(uniao(l, l1))
	//println(interseccao(l, l1))
 
	//println(sequencia(0, 2))
 
	//println(inverte(l))
 
	//val q27 = NoLista('a', NoLista('s', NoLista('d', NoLista('f', NoLista('g', Null)))))
 
	//println(rodarEsquerda(q27, 3))
 
	//println(verificaSequencia(l, l1))
 
	println(ordena(l))
 
	println(l)
}