package com.example.bswing_wear_os

import kotlinx.coroutines.runBlocking

class SwingController {

    val globalClubInstance: Club = Club()
    lateinit var globalSwingInstance: Swing
    var currentSwingDataInMemory: ArrayList<Array<Array<Double>>>? = null

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
        Helper.swingRepo.updateLocalSwing(Helper.clubList.clubList[this.globalClubInstance.selectedClub].toString(), RoomConverters().fromArrayList(swingData))
    }

    suspend fun getSwingFromDb(club: String): RoomSwing {
        return Helper.swingRepo.getLocalSwing(club)
    }
}