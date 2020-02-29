package com.example.bswing_wear_os

import kotlinx.coroutines.runBlocking

class Club {

    lateinit var selectedClub: ClubNames
    var clubData: RoomSwing ?= null

    fun selectClub(club: ClubNames) {
        this.selectedClub = club
        this.hasSwingData()
    }

    fun getSelectedClubName(): String? {
        return Helper.clubList.clubList[this.selectedClub]
    }

    private fun hasSwingData() {
        runBlocking {
            clubData = Helper.swingController.getSwingFromDb(Helper.clubList.clubList[selectedClub].toString())
            if(clubData != null) {
                val localClubData = clubData
                Helper.swingController.currentSwingDataInMemory = Helper.roomConvertersInstance.fromString(localClubData!!.swingData)
            }
        }
    }

}
