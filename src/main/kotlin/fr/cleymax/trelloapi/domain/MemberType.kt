package fr.cleymax.trelloapi.domain

enum class MemberType(val value: String) {
    NORMAL("normal"),
    ADMIN("admin"),
    OBSERVER("observer");

    override fun toString(): String = "MemberType(value='$value')"
}

