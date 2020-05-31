package fr.cleymax.trelloapi

import fr.cleymax.trelloapi.domain.*
import fr.cleymax.trelloapi.results.AddMemberToBoardResult
import fr.cleymax.trelloapi.results.AddReactionToCommentResult
import java.io.File

interface TrelloApi {

    fun getBoard(boardId: String): Board?

    fun getBoardCard(boardId: String, cardId: String): Card?

    fun getBoardActions(boardId: String): Array<Action>?

    fun getBoardCards(boardId: String): Array<Card>?

    fun getBoardMembers(boardId: String): Array<Member>?

    fun getBoardLabels(boardId: String): Array<Label>?

    fun getBoardLists(boardId: String): Array<TList>?

    fun getBoardCheckLists(boardId: String): Array<CheckList>?

    fun getBoardMemberCards(boardId: String, memberId: String): Array<Card>?

    fun getBoardOrganization(boardId: String): Organization?

    fun addMemberToBoard(boardId: String, user: String): AddMemberToBoardResult?

    fun addMemberToBoard(
        boardId: String,
        email: String,
        type: MemberType = MemberType.NORMAL,
        fullName: String = ""
    ): AddMemberToBoardResult?

    fun modifyBoardRoleMember(
        boardId: String,
        user: String,
        memberType: MemberType = MemberType.NORMAL
    ): AddMemberToBoardResult?

    fun removeMemberToBoard(boardId: String, memberId: String): Board?

    fun getAction(actionId: String): Action?

    fun getActionBoard(actionId: String): Board?

    fun getActionCard(actionId: String): Card?

    fun getActionEntities(actionId: String): Array<Entity?>?

    fun getActionList(actionId: String): TList?

    fun getActionMember(actionId: String): Member?

    fun getActionMemberCreator(actionId: String): Member?

    fun getActionOrganization(actionId: String): Organization?

    fun getCard(cardId: String): Card?

    fun getCardActions(cardId: String): Array<Card?>?

    fun getCardAttachments(cardId: String): Array<Attachment?>?

    fun getCardMembers(cardId: String): Array<Member?>?

    fun getCardAttachment(cardId: String, attachmentId: String): Attachment?

    fun getCardBoard(cardId: String): Board?

    fun deleteCard(cardId: String): Boolean?

    fun createCard(listId: String, card: Card, pos: String = "top"): Card?

    fun editDescription(cardId: String, description: String): Card?

    fun addLabelToCard(cardId: String, labelId: String): Array<String>?

    fun addCommentToCard(cardId: String, comment: String): Action?

    fun addReactionToComment(cardId: String, unified: String): AddReactionToCommentResult?

    fun updateComment(cardId: String, commentActionId: String, comment: String, callback: () -> Action): Action

    fun addAttachmentToCard(cardId: String, file: File)

    fun addAttachmentToCard(cardId: String, url: String)

    fun deleteAttachment(cardId: String, attachmentId: String)

    fun addMemberToCard(cardId: String, memberId: String): Array<Member>

    fun removeMemberToCard(cardId: String, memberId: String): Array<Member>

    fun updateCard(card: Card): Card

    fun getList(listId: String): TList

    fun getListCards(listId: String): Array<Card>

    fun deleteList(listId: String)

    fun getCheckList(checkListId: String): CheckList

    fun getCardCheckLists(cardId: String): Array<CheckList>

    fun getCheckItems(checkListId: String): Array<CheckItem>

    fun createCheckList(cardId: String, checkList: CheckList): CheckList

    fun createCheckItem(cardId: String, checkItem: CheckItem): CheckItem

    fun getOrganization(organizationId: String): Organization

    fun getOrganizationBoards(organizationId: String): Array<Board>

    fun getOrganizationMembers(organizationId: String): Array<Member>

    fun createOrganization(organization: Organization): Organization

    fun getLabel(labelId: String): Label

    fun createLabel(label: Label): Label

    fun updateLabel(label: Label): Label

    fun deleteLabel(labelId: String)

    fun getMember(): Member

    fun getMember(username: String = "me"): Member?

    fun getMemberBoards(userId: String): Array<Board>?

    fun getMemberCards(userId: String): Array<Card>?

    fun getMemberActions(userId: String): Array<Action>?

}
