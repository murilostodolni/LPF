//classe do no
data class No(val info: Int, val prox: No?)

//tamanho do nó
fun size(no: No?): Int =
		if(no == null)
			0
		else
			size(no.prox) + 1

//procurando um elemento na lista
fun find(no: No?, i: Int): Int =
		if (no == null)
			-1
		else if (no.info == i)
			no.info
		else
			find(no.prox, i)

//concatenar dois nós
fun concatenar(no1: No?, no2: No?): No? =
	if(no1 == null)
		no2
	else if(no2 == null)
		no1
	else
			No(no1.info, concatenar(no1.prox, no2))

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

fun reverse(no: No?): No? =
		if(no != null){
			if(no.prox == null)
				no
			else
				No(no.info, reverse(no.prox))
		}		
		else
			null

fun auxReverse(no1: No?, i: Int): No? =
		if(no1 == null)
			No(i, null)
		else
			No(no1.info, auxReverse(no1.prox, i))


fun main(args: Array<String>) {
	val no = No(1, No(2, No(3, No(4, null))))
    

    println(reverse(no))
}
