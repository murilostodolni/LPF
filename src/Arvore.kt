abstract class Arvore

data class NodeArvore(val info: Int, val esquerda: Arvore, val direita: Arvore): Arvore()

object Vazio: Arvore()

//fun tamanho arvore
fun tamanhoArvore(arv: Arvore): Int = when(arv){
	is NodeArvore -> {
		val e = tamanhoArvore(arv.esquerda)
		val d = tamanhoArvore(arv.direita)
		
		if(e > d) e + 1  else d + 1
	}
	else -> -1
}

//maior valor da arvore
fun maiorValor(arv: Arvore): Int = when(arv){
	is NodeArvore -> {if(arv.direita != Vazio && arv.esquerda != Vazio) maiorValor(arv.direita) else arv.info}
	else -> 0
}
		//if(arv is NodeArvore)
			//if(arv.direita != Vazio) maiorValor(arv.direita) else arv.info


fun main(args: Array<String>) {
	val arvore = NodeArvore(10,NodeArvore(8,NodeArvore(2,NodeArvore(1,Vazio,Vazio),
			NodeArvore(6,Vazio,NodeArvore(7,Vazio,Vazio))),Vazio), NodeArvore(20,NodeArvore(11,Vazio, Vazio),
			NodeArvore(21,NodeArvore(17, Vazio, Vazio), NodeArvore(22, Vazio, Vazio))))
// DESENHO ARVORE
//			   10
//		  8	         20
//		2	     11     21
//    1	  6           17  22
//			7

	println(tamanhoArvore(arvore)) //retorno esperado: 4 -> OK
	println(maiorValor(arvore)) // retorno esperado: 22 -> OK


}
