package fr.cleymax.trelloapi.events.list

import fr.cleymax.trelloapi.domain.TList
import fr.cleymax.trelloapi.event.Event

abstract class ListEvent(open val list: TList) : Event {

    override fun toString(): String = "ListEvent(list=$list)"
}
