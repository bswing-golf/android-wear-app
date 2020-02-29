package com.example.bswing_wear_os

class ClubList {

    val clubList: Map<ClubNames, String> = this.createClubList()

    private fun createClubList(): Map<ClubNames, String> {
        return mapOf(
            ClubNames.WEDGE to "Wedge",
            ClubNames.SHORT_IRON to "Short Iron",
            ClubNames.MID_IRON to "Mid Iron",
            ClubNames.LONG_IRON to "Long Iron",
            ClubNames.HYBRID to "Hybrid",
            ClubNames.WOOD to "Wood",
            ClubNames.DRIVER to "Driver"
        )
    }

    fun getClubNameFromString(club: String?): ClubNames {
        return this.clubList.filterValues { it == club }.keys.first()
    }
}