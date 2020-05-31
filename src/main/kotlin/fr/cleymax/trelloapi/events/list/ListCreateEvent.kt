package fr.cleymax.trelloapi.events.list

import fr.cleymax.trelloapi.domain.TList

class ListCreateEvent(override val list: TList) : ListEvent(list) {

    override fun getName(): String = "ListCreateEvent"
    override fun toString(): String = "ListCreateEvent(list=$list)"
}