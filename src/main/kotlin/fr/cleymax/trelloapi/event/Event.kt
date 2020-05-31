package fr.cleymax.trelloapi.event

interface Event {

    fun getName(): String
    override fun toString(): String
}
