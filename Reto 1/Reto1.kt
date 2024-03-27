/*
Reto 1

Indicar si un String es palindromo o no.
 */

fun main() {
    val text1 = "dabale arroz a la zorra el abad"
    println("¿La palabra '$text1' es palindrome? : ${isPalindrome(text1)}")

    val text2 = "anita lava la tina"
    println("¿La palabra '$text2' es palindrome? : ${isPalindrome(text2)}")
}

fun isPalindrome(text: String):Boolean{
    // Elimino todos los espacios del string
    val textWithoutSpaces = text.replace(" ", "")

    // Invierto el string sin espacios
    val reversedText = textWithoutSpaces.reversed()

    // Comparo si el string sin espacios es igual al string invertido
    return textWithoutSpaces == reversedText
}