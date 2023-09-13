package ru.smak.polynomial104

import ru.smak.polynomial104.math.Polynomial
import kotlin.random.Random

//var t: Polynomial? = null
fun main() {
    val p1 = Polynomial(mapOf(-1 to 5.0, 2 to -3.0, 5 to 1.0))
    println(p1)
    val p2 = Polynomial(0.0, -5.0, 7.0, -4.0)
    println(p2)

    val p3 = p1 * 0.0
    println(p3)
    val p4 = (p1 + p2).also { println(it) }
    val p5 = (p1 * p2).also { println(it) }
    val p6 = (p1 - p2).also { println(it) }

//
//    val rnd = Random.nextBoolean()
//    if (rnd) t = Polynomial(3.0, 9.0, 5.0)
//    println(t?.let {
//        print("Количество коэффициентов: ")
//        it.coeffs.size
//    })
//
//    val p = Polynomial(3.5, 5.3).also { println(it) }
//    val pp = Polynomial(2.3).apply {
//        a = 3
//        b = 7
//    }
}