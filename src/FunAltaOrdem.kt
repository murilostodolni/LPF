
//multiplicadar cada elemento por uma funcao
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
