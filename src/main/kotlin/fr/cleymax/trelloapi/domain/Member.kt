package fr.cleymax.trelloapi.domain

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Member(
    val id: String,
    val email: String?,
    val newEmail: String?,
    val fullName: String?,
    val initials: String?,
    val username: String?,
    val memberType: String?,
    val status: String?,
    val bio: String?,
    val bioData: JsonElement?,
    val avatarHash: String?,
    val avatarUrl: String?,
    val avatarSource: String?,
    val uploadedAvatarHash: String?,
    val uploadedAvatarUrl: String?,
    val gravatarHash: String?,
    val url: String?,
    val unconfirmed: Boolean?,
    val activityBlocked: Boolean?,
    val idMemberReferrer: String?,
    val nonPublic: JsonElement?,
    val nonPublicAvailable: Boolean?,
    val confirmed: Boolean?,
    val trophies: List<String>?,
    @SerializedName("prefs")
    val preferences: Map<String, Any>?,
    val oneTimeMessagesDismissed: List<String>,
    @SerializedName("idBoards")
    val boardsId: Array<String>,
    @SerializedName("idBoardsInvited")
    val boardsInvitedId: Array<String>,
    @SerializedName("idBoardsPinned")
    val boardsPinnedId: Array<String>,
    @SerializedName("idOrganizations")
    val organizationsId: Array<String>,
    @SerializedName("idOrganizationsInvited")
    val organizationsInvitedId: Array<String>,
    @SerializedName("idEnterprisesAdmin")
    val enterprisesAdminId: Array<String>,
    val loginTypes: Array<String>,
    @SerializedName("idEnterprise")
    val entrepriseId: String?,
    @SerializedName("idEnterprisesDeactivated")
    val enterprisesDeactivatedId: Array<String>,
    @SerializedName("idPremOrgsAdmin")
    val premOrgsAdminId: Array<String>,
    val products: Array<Any>?,
    val messagesDismissed: JsonElement?,
    val marketingOptIn: JsonElement?,
    val premiumFeatures: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}
