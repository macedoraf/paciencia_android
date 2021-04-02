package br.com.paciencia.negocio

interface Carta {
    val numero: Int
    val nipe: Nipe
    var isVisible: Boolean
}