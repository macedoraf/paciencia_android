package br.com.paciencia.negocio

import java.util.*

class Mesa {
    private val deck = DeckDeCartas()
     val colunas = mutableListOf<Stack<Carta>>()

    init {
        for (i in 1 until 7) {
            provideColuna(i)
        }
    }

    private fun provideColuna(quantidade: Int) {
        val stack = Stack<Carta>().apply { addAll(deck.pegarCarta(quantidade)) }.apply {
            lastElement().isVisible = true
        }
        colunas.add(stack)
    }

}