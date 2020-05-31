package fr.cleymax.trelloapi.events.board

import fr.cleymax.trelloapi.domain.Board

class BoardDeleteEvent(override val board: Board) : BoardEvent(board) {
    override fun getName(): String = "BoardDeleteEvent"
    override fun toString(): String = "BordCreateEvent(board=$board)"
}