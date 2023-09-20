package ru.smak.polynomial104

import ru.smak.polynomial104.math.Polynomial
import ru.smak.polynomial104.math.eq
import kotlin.math.ulp

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

    val polynomial = Polynomial( 2.0,4.0,1.0)
    val polynomial2 = polynomial/2.0
    println("Результат деления: $polynomial2")

    println(polynomial(2.0))
    println(polynomial[2])


    val a = 0.6 + 0.1
    val b = 0.8 - 0.1
    println(a.eq(b))
    println("a = $a, b = $b")
    println(1e20*a/3.0)
    println(0.0.ulp)
    // val divisor = 2

    //val result = polynomial.map { it/divisor }
    // println("Результат деления полинома $polynomial на число $divisor: $result")
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