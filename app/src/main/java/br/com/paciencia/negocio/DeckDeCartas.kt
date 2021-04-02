package br.com.paciencia.negocio

import java.util.*

class DeckDeCartas(private val deck: Stack<Carta> = Stack<Carta>()) {
    init {
        provideNumbers(Nipe.COPAS)
        provideNumbers(Nipe.ESPADAS)
        provideNumbers(Nipe.OUROS)
        provideNumbers(Nipe.PAUS)
    }

    private fun provideNumbers(nipe: Nipe) {
        for (i in 1 until 12) {
            deck.add(object : Carta {
                override val numero: Int
                    get() = i
                override val nipe: Nipe
                    get() = nipe
                override var isVisible: Boolean = false

            })
        }
    }

    fun embaralhar() {
        deck.shuffle()
    }

    fun pegarCarta(quantidade: Int): Stack<Carta> {
        val cartas = Stack<Carta>()
        for (i in 0 until quantidade) {
            cartas.add(deck.pop())
        }
        return cartas
    }
}