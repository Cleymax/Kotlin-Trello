package fr.cleymax.trelloapi.domain

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Organization(
    val id: String,
    val name: String,
    val displayName: String,
    @SerializedName("desc")
    val description: String,
    @SerializedName("descData")
    val descriptionData: JsonElement?,
    val website: String?,
    val promotions: Array<Any>,
    val enterpriseJoinRequest: JsonElement?,
    val allAdminsEnabled: Boolean,
    val teamType: String,
    val idMemberCreator: String?,
    val invited: Boolean,
    val invitations: Array<Any>,
    @SerializedName("prefs")
    val preferences: Preferences,
    val powerUps: Array<String>,
    val url: String,
    val logoHash: String,
    val premiumFeatures: Array<String>,
    @SerializedName("idEnterprise")
    val enterpriseId: String,
    val availableLicenseCount: Int,
    val maximumLicenseCount: Int,
    val ixUpdate: String,
    val limits: JsonElement?,
    val billableMemberCount: Int,
    @SerializedName("idBoards")
    val boardsId: Array<String>,
    val billableCollaboratorCount: Int,
    val activeBillableMemberCount: Int,
    @SerializedName("memberships")
    val members: Array<MemberShip>,
    val products: Array<String>?
) {
    data class Preferences(
        val permissionLevel: String,
        val orgInviteRestrict: Array<String>,
        val boardInviteRestrict: String,
        val externalMembersDisabled: Boolean,
        val associatedDomain: String?,
        val googleAppsVersion: Int,
        val boardVisibilityRestrict: BoardRestrict,
        val boardDeleteRestrict: BoardRestrict,
        val attachmentRestrictions: JsonElement?
    ) {
        data class BoardRestrict(
            @SerializedName("private")
            val privateVisibility: String,
            @SerializedName("org")
            val orgVisibility: String,
            @SerializedName("public")
            val publicVisibility: String,
            @SerializedName("enterprise")
            val enterpriseVisibility: String
        ) {
            override fun toString(): String =
                "BoardRestrict(privateVisibility='$privateVisibility', orgVisibility='$orgVisibility', publicVisibility='$publicVisibility', enterpriseVisibility='$enterpriseVisibility')"

        }

        override fun toString(): String =
            "Preferences(permissionLevel='$permissionLevel', orgInviteRestrict=${orgInviteRestrict.contentToString()}, boardInviteRestrict='$boardInviteRestrict', externalMembersDisabled=$externalMembersDisabled, associatedDomain=$associatedDomain, googleAppsVersion=$googleAppsVersion, boardVisibilityRestrict=$boardVisibilityRestrict, boardDeleteRestrict=$boardDeleteRestrict, attachmentRestrictions=$attachmentRestrictions)"

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Organization

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String =
        "Organization(id='$id', name='$name', displayName='$displayName', description='$description', descriptionData=$descriptionData, website=$website, promotions=${promotions.contentToString()}, enterpriseJoinRequest=$enterpriseJoinRequest, allAdminsEnabled=$allAdminsEnabled, teamType='$teamType', idMemberCreator=$idMemberCreator, invited=$invited, invitations=${invitations.contentToString()}, preferences=$preferences, powerUps=${powerUps.contentToString()}, url='$url', logoHash='$logoHash', premiumFeatures=${premiumFeatures.contentToString()}, enterpriseId='$enterpriseId', availableLicenseCount=$availableLicenseCount, maximumLicenseCount=$maximumLicenseCount, ixUpdate='$ixUpdate', limits=$limits, billableMemberCount=$billableMemberCount, boardsId=${boardsId.contentToString()}, billableCollaboratorCount=$billableCollaboratorCount, activeBillableMemberCount=$activeBillableMemberCount, members=${members.contentToString()}, products=${products?.contentToString()})"

}