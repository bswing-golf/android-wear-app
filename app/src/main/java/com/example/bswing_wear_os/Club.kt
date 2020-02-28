package com.example.bswing_wear_os

import kotlinx.coroutines.runBlocking

class Club {

    lateinit var selectedClub: ClubNames
    var hasSwingData: Boolean = false
    lateinit var clubData: RoomSwing

    fun selectClub(club: ClubNames) {
        this.selectedClub = club
        this.hasSwingData()
    }

    fun getSelectedClubName(): String? {
        return Helper.clubList.clubList[this.selectedClub]
    }

    private fun hasSwingData() {
        runBlocking {
            val swing = Helper.swingController.getSwingFromDb(Helper.clubList.clubList[selectedClub].toString())
            @Suppress("SENSELESS_COMPARISON")
            hasSwingData = (swing != null)
            @Suppress("SENSELESS_COMPARISON")
            if(swing != null) { clubData = swing }
        }
        println(this.hasSwingData)
    }

}
