package fr.cleymax.trelloapi.events.card

import fr.cleymax.trelloapi.domain.Card

class CardUpdateEvent(override val card: Card) : CardEvent(card) {

    override fun getName(): String = "CardCreateEvent"
    override fun toString(): String = "CardCreateEvent(card=$card)"
}