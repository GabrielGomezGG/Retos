/*
Reto 2

Dividir dos numeros sin utilizar el simbolo de division ni multiplicacion.
 */

fun main() {
    println(dividirDosNumeros(45044,25))
}

fun dividirDosNumeros(dividendo: Int, divisor: Int): Int{

    // Si el divisor es 0, lanzamos una excepción
    if(divisor == 0){
        throw ArithmeticException("No se puede dividir por 0")
    }

    // Conter para almacenar el resultado
    var counter = 0;
    var dividendoNum = dividendo

    // Mientras el dividendo sea mayor o igual al divisor, restamos el divisor al dividendo y sumamos 1 al contador
    while (dividendoNum >= divisor){
        dividendoNum -= divisor
        counter++
    }
    return counter
}