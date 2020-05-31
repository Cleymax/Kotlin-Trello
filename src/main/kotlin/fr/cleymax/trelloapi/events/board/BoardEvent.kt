package fr.cleymax.trelloapi.events.board

import fr.cleymax.trelloapi.domain.Board
import fr.cleymax.trelloapi.event.Event

abstract class BoardEvent(open val board: Board) : Event {

    override fun toString(): String {
        return "BoardEvent(board=$board)"
    }
}