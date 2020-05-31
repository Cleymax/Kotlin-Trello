package fr.cleymax.trelloapi.domain

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.util.*

data class Action(
    val id: String,
    @SerializedName("idMemberCreator")
    val memberId: String,
    val date: Date,
    val type: String,
    @SerializedName("memberCreator")
    val creator: Member,
    val data: JsonObject?,
    val display: JsonElement?,
    val limits: JsonObject?
) {

    override fun toString(): String {
        return "Action(id='$id', memberId='$memberId', date=$date, type='$type', creator=$creator, data=$data, display=$display)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Action

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}