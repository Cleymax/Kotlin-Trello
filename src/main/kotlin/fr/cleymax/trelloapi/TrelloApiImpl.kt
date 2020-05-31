package fr.cleymax.trelloapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.cleymax.trelloapi.domain.*
import fr.cleymax.trelloapi.results.AddMemberToBoardResult
import fr.cleymax.trelloapi.results.AddReactionToCommentResult
import fr.cleymax.trelloapi.utils.pairOf
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.*
import org.apache.http.entity.ByteArrayEntity
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import java.io.File
import java.lang.reflect.Type
import java.net.URLEncoder
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class TrelloApiImpl(private val apiKey: String, private val token: String) : TrelloApi {

    override fun getMember(): Member = get(Member::class.java, "members/me")!!

    override fun getMember(username: String): Member? = get(Member::class.java, "members/$username")

    override fun getMemberBoards(userId: String): Array<Board>? =
        get(Array<Board>::class.java, "members/$userId/boards")

    override fun getMemberCards(userId: String): Array<Card>? =
        get(Array<Card>::class.java, "members/$userId/cards")

    override fun getMemberActions(userId: String): Array<Action>? =
        get(Array<Action>::class.java, "members/$userId/actions")

    override fun getBoard(boardId: String): Board? =
        get(Board::class.java, "board/$boardId")

    override fun getBoardCard(boardId: String, cardId: String): Card? =
        get(Card::class.java, "board/$boardId/cards/$cardId")

    override fun getBoardActions(boardId: String): Array<Action>? =
        get(Array<Action>::class.java, "board/$boardId/actions")

    override fun getBoardCards(boardId: String): Array<Card>? =
        get(Array<Card>::class.java, "board/$boardId/cards")

    override fun getBoardMembers(boardId: String): Array<Member>? =
        get(Array<Member>::class.java, "board/$boardId/members")

    override fun getBoardLabels(boardId: String): Array<Label>? =
        get(Array<Label>::class.java, "board/$boardId/labels")

    override fun getBoardLists(boardId: String): Array<TList>? =
        get(Array<TList>::class.java, "board/$boardId/lists")

    override fun getBoardCheckLists(boardId: String): Array<CheckList>? =
        get(Array<CheckList>::class.java, "board/$boardId/checklists")

    override fun getBoardMemberCards(boardId: String, memberId: String): Array<Card>? =
        get(Array<Card>::class.java, "board/$boardId/members/$memberId/cards")

    override fun getBoardOrganization(boardId: String): Organization? =
        get(Organization::class.java, "board/$boardId/organization")

    override fun addMemberToBoard(boardId: String, user: String): AddMemberToBoardResult? {
        return put(
            AddMemberToBoardResult::class.java,
            "board/$boardId/members/$user",
            pairOf("type", MemberType.NORMAL.value)
        )
    }

    override fun addMemberToBoard(
        boardId: String,
        email: String,
        type: MemberType,
        fullName: String
    ): AddMemberToBoardResult? {
        return put(
            AddMemberToBoardResult::class.java,
            "board/$boardId/members",
            pairOf("email", email),
            pairOf("type", type.value),
            pairOf("fullName", fullName)
        )
    }

    override fun modifyBoardRoleMember(
        boardId: String,
        user: String,
        memberType: MemberType
    ): AddMemberToBoardResult? {
        return put(
            AddMemberToBoardResult::class.java,
            "board/$boardId/members/$user",
            pairOf("type", memberType.value)
        )
    }

    override fun removeMemberToBoard(boardId: String, memberId: String): Board? {
        return delete(
            Board::class.java,
            "boards/$boardId/members/$memberId"
        )
    }

    override fun getAction(actionId: String): Action? = get(Action::class.java, "actions/$actionId")

    override fun getActionBoard(actionId: String): Board? = get(Board::class.java, "actions/$actionId/board")

    override fun getActionCard(actionId: String): Card? = get(Card::class.java, "actions/$actionId/card")

    override fun getActionEntities(actionId: String): Array<Entity?>? =
        get(Array<Card?>::class.java, "actions/$actionId/entities")

    override fun getActionList(actionId: String): TList? = get(TList::class.java, "actions/$actionId/list")

    override fun getActionMember(actionId: String): Member? = get(Member::class.java, "actions/$actionId/member")

    override fun getActionMemberCreator(actionId: String): Member? =
        get(Member::class.java, "actions/$actionId/memberCreator")

    override fun getActionOrganization(actionId: String): Organization? =
        get(Organization::class.java, "actions/$actionId/organization")

    override fun getCard(cardId: String): Card? = get(Card::class.java, "cards/$cardId")

    override fun getCardActions(cardId: String): Array<Card?>? = get(Array<Card?>::class.java, "cards/$cardId/actions")

    override fun getCardAttachments(cardId: String): Array<Attachment?>? =
        get(Array<Attachment?>::class.java, "cards/$cardId/attachments")

    override fun getCardAttachment(cardId: String, attachmentId: String): Attachment? =
        get(Attachment::class.java, "cards/$cardId/attachments/$attachmentId")

    override fun getCardMembers(cardId: String): Array<Member?>? =
        get(Array<Member?>::class.java, "cards/$cardId/members")

    override fun getCardBoard(cardId: String): Board? =
        get(Card::class.java, "cards/$cardId/board")

    override fun deleteCard(cardId: String): Boolean {
        return delete<Any>(Any::class.java, "cards/$cardId") != null
    }

    override fun createCard(listId: String, card: Card, pos: String): Card? =
        post(Card::class.java, "cards", card, pairOf("pos", pos))


    override fun editDescription(cardId: String, description: String): Card? =
        put(Card::class.java, "cards/$cardId", pairOf("desc", description))


    override fun addLabelToCard(cardId: String, labelId: String): Array<String>? =
        post(Array<String>::class.java, "cards/$cardId/idLabels", pairOf("value", labelId))

    override fun addCommentToCard(cardId: String, comment: String) : Action? =
        post(Action::class.java, "cards/$cardId/actions/comments", pairOf("text", comment))

    override fun addReactionToComment(cardId: String, unified: String): AddReactionToCommentResult? =
        post(AddReactionToCommentResult::class.java, "actions/$cardId/reactions", pairOf("unified", unified))


    override fun updateComment(
        cardId: String,
        commentActionId: String,
        comment: String
    ): Action? {
        TODO("Not yet implemented")
    }

    override fun addAttachmentToCard(cardId: String, file: File) {
        TODO("Not yet implemented")
    }

    override fun addAttachmentToCard(cardId: String, url: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAttachment(cardId: String, attachmentId: String) {
        TODO("Not yet implemented")
    }

    override fun addMemberToCard(cardId: String, memberId: String): Array<Member>? {
        TODO("Not yet implemented")
    }

    override fun removeMemberToCard(cardId: String, memberId: String): Array<Member>? {
        TODO("Not yet implemented")
    }

    override fun updateCard(card: Card): Card? {
        TODO("Not yet implemented")
    }

    override fun getList(listId: String): TList? {
        TODO("Not yet implemented")
    }

    override fun getListCards(listId: String): Array<Card>? {
        TODO("Not yet implemented")
    }

    override fun deleteList(listId: String) {
        TODO("Not yet implemented")
    }

    override fun getCheckList(checkListId: String): CheckList? {
        TODO("Not yet implemented")
    }

    override fun getCardCheckLists(cardId: String): Array<CheckList>? {
        TODO("Not yet implemented")
    }

    override fun getCheckItems(checkListId: String): Array<CheckItem>? {
        TODO("Not yet implemented")
    }

    override fun createCheckList(cardId: String, checkList: CheckList): CheckList? {
        TODO("Not yet implemented")
    }

    override fun createCheckItem(cardId: String, checkItem: CheckItem): CheckItem? {
        TODO("Not yet implemented")
    }

    override fun getOrganization(organizationId: String): Organization? {
        TODO("Not yet implemented")
    }

    override fun getOrganizationBoards(organizationId: String): Array<Board>? {
        TODO("Not yet implemented")
    }

    override fun getOrganizationMembers(organizationId: String): Array<Member>? {
        TODO("Not yet implemented")
    }

    override fun createOrganization(organization: Organization): Organization? {
        TODO("Not yet implemented")
    }

    override fun getLabel(labelId: String): Label? {
        TODO("Not yet implemented")
    }

    override fun createLabel(label: Label): Label? {
        TODO("Not yet implemented")
    }

    override fun updateLabel(label: Label): Label? {
        TODO("Not yet implemented")
    }

    override fun deleteLabel(labelId: String) {
        TODO("Not yet implemented")
    }

    private fun <T : Any> post(
        type: Type,
        request: String,
        vararg arguments: Pair<String, String>
    ): T? {
        return httpClient.execute(HttpPost(getUrl(request, *arguments))) res@{
            println(it.statusLine.statusCode)
            if (it.statusLine.statusCode >= 400 || it.statusLine.statusCode < 200) {
                return@res null
            }
            val content: String = EntityUtils.toString(it.entity, "UTF-8")
            return@res gson.fromJson(content, type)
        }
    }

    private fun <T : Any> post(
        type: Type,
        request: String,
        obj: T,
        vararg arguments: Pair<String, String>
    ): T? {
        val url = getUrl(request, *arguments)

        val post = HttpPost(url)
        post.entity = ByteArrayEntity(gson.toJson(obj, type).toByteArray(), ContentType.APPLICATION_JSON)

        return httpClient.execute(post) res@{
            println(it.statusLine.statusCode)
            if (it.statusLine.statusCode >= 400 || it.statusLine.statusCode < 200) {
                return@res null
            }
            val content: String = EntityUtils.toString(it.entity, "UTF-8")
            return@res gson.fromJson(content, type)
        }
    }

    private fun <T : Any> delete(
        type: Type,
        request: String,
        vararg arguments: Pair<String, String>
    ): T? = request(HttpDelete(getUrl(request, *arguments)), type)

    private fun <T : Any> put(
        type: Type,
        request: String,
        vararg arguments: Pair<String, String>
    ): T? = request(HttpPut(getUrl(request, *arguments)), type)


    private fun <T : Any> get(
        type: Type,
        request: String,
        vararg arguments: Pair<String, String>
    ): T? = request(HttpGet(getUrl(request, *arguments)), type)


    private fun <T : Any> request(
        method: HttpRequestBase,
        type: Type
    ): T? {
        return httpClient.execute(method) response@{ obj ->
            if (obj.statusLine.statusCode >= 400 || obj.statusLine.statusCode < 200) {
                return@response null
            }
            val content: String = EntityUtils.toString(obj.entity, "UTF-8")
            return@response gson.fromJson(content, type)
        }
    }

    private fun getUrl(request: String, vararg arguments: Pair<String, String>): String {
        val url = StringBuilder(BASE_URL)
        url.append(request)
        url.append("?key=").append(apiKey)
        url.append("&token=").append(token)

        for (argument in arguments) url.append("&").append(argument.first).append("=")
            .append(URLEncoder.encode(argument.second, "UTF-8"))

        return url.toString()
    }

    companion object {
        const val BASE_URL: String = "https://api.trello.com/1/"
        val httpClient: HttpClient =
            HttpClientBuilder.create().disableCookieManagement().setUserAgent("TrelloAPI-Java").build()
        val gson: Gson = GsonBuilder().create()
        val executor: ExecutorService = Executors.newCachedThreadPool()
    }
}