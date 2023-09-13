package ru.smak.polynomial104.math

class Polynomial(coeffs: Map<Int, Double>) {
    private val _coeffs: MutableMap<Int, Double>


    /* ---
    var a = 1
    var b = 4 */
    init {
        _coeffs = coeffs.filter { (k, v) -> v != 0.0 && k >= 0}.toMutableMap()
        if (_coeffs.isEmpty()) _coeffs[0]=0.0
    }

    val coeffs = _coeffs.toMap()

    constructor(vararg coeffs: Double) : this (coeffs.mapIndexed { index, value -> index to value }.toMap())



    operator fun times(scalar: Double) = Polynomial(_coeffs.map { (k, v) -> k to scalar*v }.toMap())

    operator fun plus(other: Polynomial) = Polynomial(_coeffs.toMutableMap().also {
        other._coeffs.forEach{(k2,v2) -> it[k2] = v2 + (it[k2]?:0.0)}
    } )

    operator fun minus(other: Polynomial) = Polynomial(_coeffs.toMutableMap().also {
        other._coeffs.forEach{(k2,v2) -> it[k2] = -v2 + (it[k2]?:0.0)}
    } )

    operator fun times(other: Polynomial) = Polynomial(mutableMapOf<Int, Double>().also {
        _coeffs.forEach{ (k1, v1) ->
            other._coeffs.forEach { (k2, v2) ->
                it[k1+k2] = v1*v2 + (it[k1+k2]?:0.0)
            }
        }
    })


    override fun toString() =
        _coeffs.toList().joinToString(separator = "; ") { "${it.first}: ${it.second}" }
}