package com.example.bswing_wear_os

import kotlinx.coroutines.runBlocking

class SwingController {

    val globalClubInstance: Club = Club()
    lateinit var globalSwingInstance: Swing

    fun createNewSwing() {
        this.globalSwingInstance = Swing()
        println("Starting Swing...")
        runBlocking {
            globalSwingInstance.setupSwing()
        }
        this.globalSwingInstance.startSwing()
        this.globalSwingInstance.start()
    }

    fun endSwing() {
        this.globalSwingInstance.endSwing()
    }

    suspend fun saveSwing() {
        println("Saving Swing...")
        val swingData = this.globalSwingInstance?.getSwingData()
        RepositorySwing(Helper.dbInstance.roomDaoSwing()).updateLocalSwing(Helper.clubList.clubList[this.globalClubInstance.selectedClub].toString(), RoomConverters().fromArrayList(swingData))
        this.globalClubInstance.selectClub(this.globalClubInstance.selectedClub)
    }

    suspend fun getSwingFromDb(club: String): RoomSwing {
        return RepositorySwing(Helper.dbInstance.roomDaoSwing()).getLocalSwing(club)
    }
}