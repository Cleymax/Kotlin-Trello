package fr.cleymax.trelloapi.domain

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import fr.cleymax.trelloapi.utils.MutableMapAdapter
import java.util.*

data class Board(
    val id: String,
    val name: String,
    @SerializedName("desc")
    val description: String,
    @SerializedName("descData")
    val descriptionData: JsonElement?,
    val closed: Boolean,
    @SerializedName("idOrganization")
    val organisationId: String? = null,
    @SerializedName("idEnterprise")
    val enterpriseId: String?,
    val limits: JsonElement? = null,
    val pinned: Boolean?,
    val shortLink: String,
    val powerUps: JsonArray?,
    val dateLastActivity: Date?,
    val idTags: JsonArray?,
    val url: String,
    val shortUrl: String,
    @SerializedName("prefs")
    val preferences: Preferences,
    @JsonAdapter(MutableMapAdapter::class)
    val labelNames: Map<String, String>?,
    val starred: Boolean,
    val memberships: Array<MemberShip>,
    val enterpriseOwned: Boolean,
    val subscribed: Boolean
) {
    data class Preferences(
        val permissionLevel: String,
        val hideVotes: Boolean,
        val voting: String,
        val comments: String,
        val invitations: String,
        val selfJoin: Boolean,
        val cardCovers: Boolean,
        val isTemplate: Boolean,
        val cardAging: String,
        val calendarFeedEnabled: Boolean,
        val background: String,
        val backgroundImage: String?,
        val backgroundImageScaled: Array<Background>?,
        val backgroundTile: Boolean,
        val backgroundBrightness: String?,
        val backgroundBottomColor: String?,
        val backgroundTopColor: String?,
        val canBePublic: Boolean,
        val canBeOrg: Boolean,
        val canBePrivate: Boolean,
        val canInvite: Boolean
    ) {
        data class Background(
            val width: Int,
            val height: Int,
            val url: String
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Background

                if (width != other.width) return false
                if (height != other.height) return false
                if (url != other.url) return false

                return true
            }

            override fun hashCode(): Int {
                var result = width
                result = 31 * result + height
                result = 31 * result + url.hashCode()
                return result
            }

            override fun toString(): String {
                return "Background(width=$width, height=$height, url='$url')"
            }
        }

        override fun toString(): String {
            return "Preferences(permissionLevel='$permissionLevel', hideVotes=$hideVotes, voting='$voting', comments='$comments', invitations='$invitations', selfJoin=$selfJoin, cardCovers=$cardCovers, isTemplate=$isTemplate, cardAging='$cardAging', calendarFeedEnabled=$calendarFeedEnabled, background='$background', backgroundImage=$backgroundImage, backgroundImageScaled=${backgroundImageScaled?.contentToString()}, backgroundTile=$backgroundTile, backgroundBrightness=$backgroundBrightness, backgroundBottomColor=$backgroundBottomColor, backgroundTopColor=$backgroundTopColor, canBePublic=$canBePublic, canBeOrg=$canBeOrg, canBePrivate=$canBePrivate, canInvite=$canInvite)"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Board
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Board(id='$id', name='$name', description='$description', closed=$closed, organisationId=$organisationId, enterpriseId=$enterpriseId, pinned=$pinned, shortLink='$shortLink', powerUps=$powerUps, dateLastActivity=$dateLastActivity, idTags=$idTags, url='$url', shortUrl='$shortUrl', preferences=$preferences, labelNames=$labelNames, starred=$starred, memberships=${memberships.contentToString()}, enterpriseOwned=$enterpriseOwned, subscribed=$subscribed)"
    }
}