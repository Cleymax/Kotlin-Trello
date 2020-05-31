package fr.cleymax.trelloapi.events.list

import fr.cleymax.trelloapi.domain.TList

class ListUpdateEvent(override val list: TList) : ListEvent(list) {

    override fun getName(): String = "ListUpdateEvent"
    override fun toString(): String = "ListUpdateEvent(list=$list)"
}