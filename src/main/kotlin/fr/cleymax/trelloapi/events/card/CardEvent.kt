package fr.cleymax.trelloapi.events.card

import fr.cleymax.trelloapi.domain.Card
import fr.cleymax.trelloapi.event.Event

abstract class CardEvent(open val card: Card) : Event {

    override fun toString(): String = "CardEvent(card=$card)"
}
