package fr.cleymax.trelloapi.domain

data class Preferences(
    val showSidebar: Boolean,
    val showSidebarMembers: Boolean,
    val showSidebarBoardActions: Boolean,
    val showSidebarActivity: Boolean,
    val showListGuide: Boolean,
    val emailListId: Array<String>?,
    val emailPosition: String
) {
    override fun toString(): String =
        "Preferences(showSidebar=$showSidebar, showSidebarMembers=$showSidebarMembers, showSidebarBoardActions=$showSidebarBoardActions, showSidebarActivity=$showSidebarActivity, showListGuide=$showListGuide, emailListId=${emailListId?.contentToString()}, emailPosition='$emailPosition')"

}