package fr.cleymax.trelloapi.events.board

import fr.cleymax.trelloapi.domain.Board

class BoardUpdateEvent(override val board: Board) : BoardEvent(board) {
    override fun getName(): String = "BoardUpdateEvent"
    override fun toString(): String = "BoardUpdateEvent(board=$board)"
}