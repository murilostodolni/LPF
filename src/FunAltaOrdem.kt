
//multiplica cada elemento por uma funcao
fun map(l: List, f: (Int) -> Int): List = when(l){
	is Node -> Node(f(l.info), map(l.prox, f))
	else -> Nil
}

//filtrar uma lista
fun filter(l: List, f: (Int) -> Boolean): List = when(l){
	is Node -> if(f(l.info)) Node(l.info, filter(l.prox, f)) else filter(l.prox, f)
	else -> Nil
}

//reduzir uma lista
fun reduci(l: List, f: (Int, Int) -> Int, base: Int): Int = when(l){
	is Node -> f(l.info, reduci(l.prox, f, base))
	else -> base
}

// o que era (A, B) -> C agora é (A) -> (B) -> C
fun <A, B, C>curry(f: (A, B) -> C): (A) -> (B) -> C = {x: A -> {y: B -> f(x,y)}}

fun soma1(a: Int, b: Int): Int = a + b

fun main(args: Array<String>) {
	val parcial = curry(::soma1)
 
	val resul = parcial(2)
	
	println(resul(2))

	val list = Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, Node(7, Node(8, Node(9, Node(10, Nil))))))))))
 
	//soma dos quadrados dos numeros pares
	val r = reduci(map(filter(list, {x -> x%2 == 0}), {x -> x*x}), {x, y -> x + y}, 0)
	
	print(r)
}