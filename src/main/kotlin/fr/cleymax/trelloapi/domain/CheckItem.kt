package fr.cleymax.trelloapi.domain

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.util.*

data class CheckItem(
    val id: String,
    val name: String,
    @SerializedName("idChecklist")
    val checkListId: String,
    val idCheckItem: String,
    val state: String,
    @SerializedName("idMember")
    val memberId: String?,
    val nameData: String?,
    val pos: Int,
    val due: Date?,
    val limits: JsonObject?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CheckItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "CheckItem(id='$id', name='$name', checkListId='$checkListId', idCheckItem='$idCheckItem', state='$state', memberId=$memberId, nameData=$nameData, pos=$pos, due=$due, limits=$limits)"
    }
}
