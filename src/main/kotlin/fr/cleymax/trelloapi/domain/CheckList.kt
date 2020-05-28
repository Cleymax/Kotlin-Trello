package fr.cleymax.trelloapi.domain

import com.google.gson.annotations.SerializedName

data class CheckList(
    val id: String,
    val name: String,
    @SerializedName("idCard")
    val cardId: String,
    @SerializedName("idBoard")
    val boardId: String,
    val pos: Int,
    val checkItems: Array<CheckItem>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CheckList

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "CheckList(id='$id', name='$name', cardId='$cardId', boardId='$boardId', pos=$pos, checkItems=${checkItems.contentToString()})"
    }
}