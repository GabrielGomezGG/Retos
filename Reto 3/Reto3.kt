fun main() {
    val numerosAleatorios = intArrayOf(21, 12, 53, 4, 57, 62, 47, 8, 89, 10)
    val (mayor, menor) = encontrarMayorYMenor(numerosAleatorios)
    println("El numero mayor es: $mayor")
    println("El numero menor es: $menor")
}

fun encontrarMayorYMenor(numeros: IntArray) : Pair<Int, Int>{

    // Variable para almacenar el numero mayor y menor
    var max = numeros[0]
    var min = numeros[0]

    numeros.forEach {
        // Preguntamos si max es menor que el numero actual, si lo es, significa que el numero actual es mayor
        if(max < it) max = it
        
        // Preguntamos si min es mayor que el numero actual, si lo es, significa que el numero actual es menor
        if(min > it) min = it
    }

    return Pair(max, min)
}