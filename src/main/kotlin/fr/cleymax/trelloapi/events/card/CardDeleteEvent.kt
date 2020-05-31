package fr.cleymax.trelloapi.events.card

import fr.cleymax.trelloapi.domain.Card

class CardDeleteEvent(override val card: Card) : CardEvent(card) {

    override fun getName(): String = "CardDeleteEvent"
    override fun toString(): String = "CardDeleteEvent(card=$card)"
}