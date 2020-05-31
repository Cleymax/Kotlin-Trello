package fr.cleymax.trelloapi.results

import com.google.gson.annotations.SerializedName
import fr.cleymax.trelloapi.domain.Emoji
import fr.cleymax.trelloapi.domain.Member

data class AddReactionToCommentResult(
    val id: String,
    @SerializedName("idMember")
    val memberId: String,
    @SerializedName("idModel")
    val modelId: String,
    @SerializedName("idEmoji")
    val emojiId: String,
    val member: Member,
    val emoji: Emoji
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AddReactionToCommentResult

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "AddReactionToCommentResult(id='$id', memberId='$memberId', modelId='$modelId', emojiId='$emojiId', member=$member, emoji=$emoji)"
    }
}