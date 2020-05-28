package fr.cleymax.trelloapi.domain

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.util.*

data class Card(
    val id: String?,
    val badges: Badges?,
    val checkItemStates: Array<CheckItem>?,
    val closed: Boolean,
    @SerializedName("dateLastActivity")
    val lastActivity: Date,
    @SerializedName("desc")
    val description: String?,
    @SerializedName("descData")
    val descriptionData: JsonElement?,
    val due: Date?,
    val dueComplete: Boolean?,
    val dueReminder: Int?,
    @SerializedName("idAttachmentCover")
    val attachmentCover: String?,
    @SerializedName("idBoard")
    val boardId: String,
    @SerializedName("idChecklists")
    val checklistsId: Array<String>?,
    @SerializedName("idLabels")
    val labelsId: Array<String>?,
    @SerializedName("idList")
    val listId: String,
    @SerializedName("idMembers")
    val membersId: Array<String>?,
    @SerializedName("idMembersVoted")
    val membersVotedId: Array<String>?,
    @SerializedName("idShort")
    val shortId: Int?,
    val labels: Array<Label>?,
    val manualCoverAttachment: Boolean?,
    val name: String,
    val pos: Int?,
    val shortLink: String?,
    val shortUrl: String?,
    val subscribed: Boolean?,
    val url: String?,
    val address: String?,
    val locationName: String?,
    val coordinates: Coordinate?,
    val isTemplate: Boolean?,
    val cover: Cover?
) {

    constructor(
        name: String,
        idBoard: String,
        idList: String,
        closed: Boolean = false,
        lastActivity: Date = Date()
    ) :
            this(
                null,
                null,
                null,
                closed,
                lastActivity,
                null,
                null,
                null,
                null,
                null,
                null,
                idBoard,
                null,
                null,
                idList,
                arrayOf(),
                null,
                null,
                arrayOf(),
                null,
                name,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )

    data class Coordinate(
        val latitude: Float,
        val longitude: Float
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Coordinate

            if (latitude != other.latitude) return false
            if (longitude != other.longitude) return false

            return true
        }

        override fun hashCode(): Int {
            var result = latitude.hashCode()
            result = 31 * result + longitude.hashCode()
            return result
        }

        override fun toString(): String {
            return "Coordinate(latitude=$latitude, longitude=$longitude)"
        }
    }

    data class Cover(
        val idAttachment: String?,
        val color: String?,
        @SerializedName("idUploadedBackground")
        val uploadBackgroundId: String?,
        val size: String,
        val brightness: String
    ) {
        override fun toString(): String {
            return "Cover(idAttachment='$idAttachment', color=$color, uploadBackgroundId=$uploadBackgroundId, size='$size', brightness='$brightness')"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Card(id=$id, badges=$badges, checkItemStates=${checkItemStates?.contentToString()}, closed=$closed, lastActivity=$lastActivity, description=$description, descriptionData=$descriptionData, due=$due, dueComplete=$dueComplete, dueReminder=$dueReminder, attachmentCover=$attachmentCover, boardId='$boardId', checklistsId=${checklistsId?.contentToString()}, labelsId=${labelsId?.contentToString()}, listId='$listId', membersId=${membersId?.contentToString()}, membersVotedId=${membersVotedId?.contentToString()}, shortId=$shortId, labels=${labels?.contentToString()}, manualCoverAttachment=$manualCoverAttachment, name='$name', pos=$pos, shortLink=$shortLink, shortUrl=$shortUrl, subscribed=$subscribed, url=$url, address=$address, locationName=$locationName, coordinates=$coordinates, isTemplate=$isTemplate, cover=$cover)"
    }
}
