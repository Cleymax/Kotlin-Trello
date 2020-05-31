package fr.cleymax.trelloapi.domain

data class Emoji(
    val unified: String,
    val native: String?,
    val name: String?,
    val skinVariation: String?,
    val shortNam: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Emoji

        if (unified != other.unified) return false

        return true
    }

    override fun hashCode(): Int = unified.hashCode()

    override fun toString(): String =
        "Emoji(unified=$unified, native=$native, name=$name, skinVariation=$skinVariation, shortNam=$shortNam)"

}
