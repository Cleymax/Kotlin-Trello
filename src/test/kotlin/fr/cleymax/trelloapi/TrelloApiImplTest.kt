package fr.cleymax.trelloapi

import fr.cleymax.trelloapi.domain.Member
import org.junit.*
import org.junit.Assert.*

class TrelloApiImplTest {

    companion object {
        @JvmStatic
        private lateinit var trello: TrelloApi

        @BeforeClass
        @JvmStatic
        fun setUp() {
            trello = TrelloApiImpl(
                System.getenv("API_KEY"),
                System.getenv("API_TOKEN")
            )
        }
    }

    @Test
    fun getMember() {
        val me: Member? = trello.getMember()
        assertNotNull(me)
    }

    @Test
    fun testGetMember() {
    }

    @Test
    fun getMemberBoards() {
    }

    @Test
    fun getMemberCards() {
    }

    @Test
    fun getMemberActions() {
    }

    @Test
    fun getBoard() {
    }

    @Test
    fun getBoardCard() {
    }

    @Test
    fun getBoardActions() {
    }

    @Test
    fun getBoardCards() {
    }

    @Test
    fun getBoardMembers() {
    }

    @Test
    fun getBoardLabels() {
    }

    @Test
    fun getBoardLists() {
    }

    @Test
    fun getBoardCheckLists() {
    }

    @Test
    fun getBoardMemberCards() {
    }

    @Test
    fun getBoardOrganization() {
    }

    @Test
    fun addMemberToBoard() {
    }

    @Test
    fun testAddMemberToBoard() {
    }

    @Test
    fun modifyBoardRoleMember() {
    }

    @Test
    fun removeMemberToBoard() {
    }

    @Test
    fun getAction() {
    }

    @Test
    fun getActionBoard() {
    }

    @Test
    fun getActionCard() {
    }

    @Test
    fun getActionEntities() {
    }

    @Test
    fun getActionList() {
    }

    @Test
    fun getActionMember() {
    }

    @Test
    fun getActionMemberCreator() {
    }

    @Test
    fun getActionOrganization() {
    }

    @Test
    fun getCard() {
    }

    @Test
    fun getCardActions() {
    }

    @Test
    fun getCardAttachments() {
    }

    @Test
    fun getCardAttachment() {
    }

    @Test
    fun getCardMembers() {
    }

    @Test
    fun getCardBoard() {
    }

    @Test
    fun deleteCard() {
    }

    @Test
    fun createCard() {
    }

    @Test
    fun editDescription() {
    }

    @Test
    fun addLabelToCard() {
    }

    @Test
    fun addCommentToCard() {
    }

    @Test
    fun addReactionToComment() {
    }

    @Test
    fun removeCoverToCard() {
    }

    @Test
    fun addCoverToCard() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun addAttachmentToCard() {
    }

    @Test
    fun testAddAttachmentToCard() {
    }

    @Test
    fun testAddAttachmentToCard1() {
    }

    @Test
    fun deleteAttachment() {
    }

    @Test
    fun editAttachment() {
    }

    @Test
    fun editCoverToCard() {
    }

    @Test
    fun addMemberToCard() {
    }

    @Test
    fun removeMemberToCard() {
    }

    @Test
    fun updateCard() {
    }

    @Test
    fun getList() {
    }

    @Test
    fun getListCards() {
    }

    @Test
    fun deleteList() {
    }

    @Test
    fun getCheckList() {
    }

    @Test
    fun getCardCheckLists() {
    }

    @Test
    fun getCheckItems() {
    }

    @Test
    fun createCheckList() {
    }

    @Test
    fun createCheckItem() {
    }

    @Test
    fun getOrganization() {
    }

    @Test
    fun getOrganizationBoards() {
    }

    @Test
    fun getOrganizationMembers() {
    }

    @Test
    fun createOrganization() {
    }

    @Test
    fun getLabel() {
    }

    @Test
    fun createLabel() {
    }

    @Test
    fun updateLabel() {
    }

    @Test
    fun deleteLabel() {
    }


}