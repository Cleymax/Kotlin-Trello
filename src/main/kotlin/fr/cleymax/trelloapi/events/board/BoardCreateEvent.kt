package fr.cleymax.trelloapi.events.board

import fr.cleymax.trelloapi.domain.Board

class BoardCreateEvent(override val board: Board) : BoardEvent(board) {

    override fun getName(): String = "BordCreateEvent"
    override fun toString(): String = "BordCreateEvent(board=$board)"
}
