package fr.cleymax.trelloapi.domain

import com.google.gson.annotations.SerializedName
import java.util.*

data class Attachment(
    val id: String,
    val name: String,
    val bytes: Int?,
    val date: Date,
    @SerializedName("idMember")
    val memberId: String,
    val isUpload: Boolean,
    val mimeType: String,
    val previews: Array<Preview>,
    val url: String,
    val pos: Int,
    val edgeColor: String?
) {

    data class Preview(
        val width: Int,
        val height: Int,
        val url: String,
        val id: String,
        val scaled: Boolean,
        val bytes: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Preview

            if (id != other.id) return false

            return true
        }

        override fun hashCode(): Int = id.hashCode()

        override fun toString(): String =
            "Preview(width=$width, height=$height, url='$url', id='$id', scaled=$scaled, bytes=$bytes)"

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Attachment

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String =
        "Attachment(id='$id', name='$name', bytes=$bytes, date=$date, memberId='$memberId', isUpload=$isUpload, mimeType='$mimeType', previews=${previews.contentToString()}, url='$url')"

}