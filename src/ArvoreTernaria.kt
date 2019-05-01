abstract class ArvoreT<out T>

data class NoArv<T>(val info: T, val dir: ArvoreT<T>, val meio: ArvoreT<T>, val esq: ArvoreT<T>): ArvoreT<T>()
		
object Nulo: ArvoreT<Nothing>()

fun <T>alturaArv(arv: ArvoreT<T>): Int = when(arv){
	is NoArv -> {
		val e = alturaArv(arv.dir)
		val m = alturaArv(arv.meio)
		val d = alturaArv(arv.esq)
		
		if(e > m && e > d)
			e + 1
		else if(m > e && m > d)
			m + 1
		else
			d + 1
	}
	else -> -1
}

//primeiro pensamento!
fun <T> criaLista(arv: ArvoreT<T>, n: Int): Lista<ArvoreT<T>> = when {
	arv is NoArv && n > 1 -> {
		val a = criaLista(arv.dir, n-1)
		val b = criaLista(arv.meio, n-1)
		val c = criaLista(arv.esq, n-1)
		
		concatena(a, concatena(b, c))
	}
	arv is NoArv && n == 1 -> {
		val d = retornaInfo(arv.dir)
		val m = retornaInfo(arv.meio)
		val e = retornaInfo(arv.esq)
		
		concatena(d, concatena(m, e))
	}
	else -> Null
}

//auxiliar para a funcao acima
fun <T> retornaInfo(arv: ArvoreT<T>): Lista<ArvoreT<T>> = if(arv is NoArv) NoLista(NoArv(arv.info,Nulo, Nulo, Nulo), Null) else Null

// mesma coisa da funcao de cima, só que melhorada
fun <T> criaListaAbax(arv: ArvoreT<T>, n: Int): Lista<ArvoreT<T>> = when {
	arv is NoArv && n > 1 -> concatena(criaLista(arv.dir, n-1), concatena(criaLista(arv.meio, n-1), criaLista(arv.esq, n-1)))
	arv is NoArv -> NoLista(arv, Null)
	else -> Null
}


fun main(args: Array<String>) {
	val t = NoArv(20, NoArv(10, NoArv(8, Nulo, Nulo, Nulo), NoArv(10, Nulo, Nulo, Nulo), NoArv(12, NoArv(11, Nulo, Nulo, Nulo), NoArv(12, Nulo, Nulo, Nulo), NoArv(15, Nulo, Nulo, Nulo))), NoArv(20,NoArv(19, Nulo, Nulo, Nulo),NoArv(20, Nulo, Nulo, Nulo),NoArv(21, Nulo, Nulo, Nulo)), NoArv(30,NoArv(25, Nulo, Nulo, Nulo),NoArv(30, Nulo, Nulo, Nulo),NoArv(40, NoArv(35, Nulo, Nulo, Nulo), NoArv(40, Nulo, Nulo, Nulo), NoArv(50, Nulo, Nulo, Nulo))))
 
	println(alturaArv(t))
	println(criaLista(t, 2))
 
	println(criaListaAbax(t, 2))
}