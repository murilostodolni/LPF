//soma de duas funcoes que retorna outra funcao
fun soma(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int =
		{x: Int -> f(x) + g(x)}

//retorna a maior funcao
fun maior(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = {x -> when {
	f(x) > g(x) -> f(x)
	else -> g(x)
	}
}

//funcao para combinar duas funcoes
fun combina(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int =
		{x: Int -> f(g(x))}

//funcao soma n
fun somaN(n: Int): (Int) -> Int = {x: Int -> x + n}

//funcao dobro
fun dobro(x: Int): Int = 2*x

//funcao sucessor
fun sucessor(x: Int): Int = x + 1

//funcao antecessor
fun antecessor(x: Int): Int = x - 1

//funcao quadratica
fun quadratica(x: Int): Int = x*x

fun main(args: Array<String>) {
	val d = ::dobro
	val s = ::sucessor
	val a = ::antecessor
	val q = ::quadratica

	val com = combina(d, s) //operacao: 2*(x+1)
	println(com(2))

	val soma = soma(s, a) //operacao: (x + 1) + (x - 1)
	println(soma(2))

	val maior = maior(d, q) // 2*x > x*x ? x*x ; 2*x

	println(maior(3))

	val somaN = somaN(5)

	println(somaN(3)) // operacao: x + 5 = 3 + 5 = 8
}