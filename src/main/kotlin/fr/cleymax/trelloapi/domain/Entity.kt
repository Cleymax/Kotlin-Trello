package fr.cleymax.trelloapi.domain

data class Entity(
    val type: String,
    val id: String,
    val text: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Entity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String = "Entity(type='$type', id='$id', text='$text')"

}