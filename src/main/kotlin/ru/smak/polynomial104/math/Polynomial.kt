package ru.smak.polynomial104.math

import kotlin.math.abs
import kotlin.math.pow

class Polynomial(coeffs: Map<Int, Double>) {
    private val _coeffs: MutableMap<Int, Double>


    /* ---
    var a = 1
    var b = 4 */
    init {
        _coeffs = coeffs.filter { (k, v) -> v != 0.0 && k >= 0 }.toMutableMap()
        if (_coeffs.isEmpty()) _coeffs[0] = 0.0
    }

    val coeffs = _coeffs.toMap()

    constructor(vararg coeffs: Double) : this(coeffs.mapIndexed { index, value -> index to value }.toMap())

    operator fun times(scalar: Double) = Polynomial(_coeffs.map { (k, v) -> k to scalar * v }.toMap())


    operator fun div(scalar: Double) =
        Polynomial(_coeffs.map { (k, v) -> if (scalar == 0.0) throw ArithmeticException("Division by zero") else k to 1.0 / scalar * v }
            .toMap())

    operator fun plus(other: Polynomial) = Polynomial(_coeffs.toMutableMap().also {
        other._coeffs.forEach { (k2, v2) -> it[k2] = v2 + (it[k2] ?: 0.0) }
    })

    operator fun minus(other: Polynomial) = Polynomial(_coeffs.toMutableMap().also {
        other._coeffs.forEach { (k2, v2) -> it[k2] = -v2 + (it[k2] ?: 0.0) }
    })

    operator fun times(other: Polynomial) = Polynomial(mutableMapOf<Int, Double>().also {
        _coeffs.forEach { (k1, v1) ->
            other._coeffs.forEach { (k2, v2) ->
                it[k1 + k2] = v1 * v2 + (it[k1 + k2] ?: 0.0)
            }
        }
    })

    operator fun invoke(scalar: Double) = _coeffs.entries.sumOf { (k, v) -> v * scalar.pow(k) }

    operator fun get(degree: Int) = _coeffs[degree] ?: 0.0

    override fun toString() = toString("x")

    fun toString(arg:String) = buildString {

        _coeffs.toSortedMap(reverseOrder()).forEach { (k, v) ->
            append(if (v >= 0.0) if (_coeffs.keys.max() == k) "" else "+" else "-")
            if (abs(v) != 1.0 || k == 0 ) append(abs(v))
            if(k > 0) {
                append(arg)
                if (k > 1) append("^$k")
            }
        } //sort by key

    }
}

fun Double.eq(other: Double, eps: Double) = abs(this - other) < eps
