package fr.cleymax.trelloapi.domain

import com.google.gson.annotations.SerializedName

data class MemberShip(
    val id: String,
    @SerializedName("idMember")
    val memberId: String,
    val memberType: MemberType,
    val unconfirmed: Boolean?,
    val deactivated: Boolean?
) {
    override fun toString(): String {
        return "MemberShip(id='$id', memberId='$memberId', memberType=$memberType)"
    }
}
