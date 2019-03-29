//classe do no
data class No(val info: Int, val prox: No?)

//tamanho do nó
fun size(no: No?): Int =
		if(no == null)
			0
		else
			size(no.prox) + 1

//procurando um elemento na lista
fun find(no: No?, i: Int): Boolean =
		if (no == null)
			false
		else if (no.info == i)
			true
		else
			find(no.prox, i)

//concatenar dois nós
fun concatenar(no1: No?, no2: No?): No? =
	if(no1 != null && no2 != null)
		if(no1.prox == null)
			No(no1.info, no2)
		else
			No(no1.info, concatenar(no1.prox, no2))
	else
		null

fun intercalar(no1: No?, no2: No?): No? =
		if(no1 != null)
			No(no1.info, intercalar(no2, no1.prox))
		else
			if(no2 != null)
				No(no2.info, no2.prox)
			else
				null
				
fun remove(no: No?, posicao: Int): No? =
	if(no != null)
		if(posicao != 0)
			No(no.info, remove(no.prox, posicao-1))
		else
			remove(no.prox, posicao-1)
	else
		null

fun inserir(no:No?, valor: Int, posicao: Int): No? =
		if(no != null)
			if(posicao != 0)
				No(no.info, inserir(no.prox, valor, posicao-1))
			else
				No(valor, no)
		else
			null

fun main(args: Array<String>) {
	val no = No(1, No(2, null))
    val no1 = No(4, No(5, No(6, null)))

    println(concatenar(no, no1))
    println(intercalar(no, no1))

    println(remove(no1, 1))
    println(no1)

    println(inserir(no, 3, 2))
    println(no)
}
