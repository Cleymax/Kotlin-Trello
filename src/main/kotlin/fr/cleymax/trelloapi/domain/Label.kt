package fr.cleymax.trelloapi.domain

import com.google.gson.annotations.SerializedName

data class Label(
    val id: String,
    @SerializedName("idBoard")
    val bordId: String,
    val name: String,
    val color: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Label

        if (id != other.id) return false
        if (bordId != other.bordId) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String = "Label(id='$id', bordId='$bordId', name='$name', color='$color')"

}