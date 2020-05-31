package fr.cleymax.trelloapi.domain

import com.google.gson.JsonElement
import java.util.*


data class Badges(
    val votes: Int,
    val viewingMemberVoted: Boolean,
    val subscribed: Boolean,
    val fogbugz: String,
    val due: Date?,
    val dueComplete: Boolean?,
    val description: Boolean,
    val comments: Int,
    val checkItemsChecked: Int,
    val checkItems: Int,
    val attachments: Int,
    val attachmentsByType: JsonElement?
) {
    override fun toString(): String {
        return "Badges(votes=$votes, viewingMemberVoted=$viewingMemberVoted, subscribed=$subscribed, fogbugz='$fogbugz', due=$due, description=$description, comments=$comments, checkItemsChecked=$checkItemsChecked, checkItems=$checkItems, attachments=$attachments)"
    }
}
