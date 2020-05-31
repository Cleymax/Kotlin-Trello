package fr.cleymax.trelloapi.results

import fr.cleymax.trelloapi.domain.Member
import fr.cleymax.trelloapi.domain.MemberShip


data class AddMemberToBoardResult(
    val id: String,
    val members: Array<Member>,
    val memberships: Array<MemberShip>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AddMemberToBoardResult

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "AddMemberToBoardResult(id=$id, members=${members.contentToString()}, memberships=${memberships.contentToString()})"
    }
}
