package fr.cleymax.trelloapi.events.list

import fr.cleymax.trelloapi.domain.TList

class ListDeleteEvent(override val list: TList) : ListEvent(list) {

    override fun getName(): String = "ListDeleteEvent"
    override fun toString(): String = "ListDeleteEvent(list=$list)"
}