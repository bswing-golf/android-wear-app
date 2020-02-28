package com.example.bswing_wear_os

class ClubList {

    val clubList: Map<ClubNames, String> = this.createClubList()

    private fun createClubList(): Map<ClubNames, String> {
        return mapOf(
            ClubNames.LOB_WEDGE to "L Wedge",
            ClubNames.SAND_WEDGE to "S Wedge",
            ClubNames.GAP_WEDGE to "G Wedge",
            ClubNames.PITCHING_WEDGE to "P Wedge",
            ClubNames.NINE_IRON to "9 Iron",
            ClubNames.EIGHT_IRON to "8 Iron",
            ClubNames.SEVEN_IRON to "7 Iron",
            ClubNames.SIX_IRON to "6 Iron",
            ClubNames.FIVE_IRON to "5 Iron",
            ClubNames.FOUR_IRON to "4 Iron",
            ClubNames.THREE_IRON to "3 Iron",
            ClubNames.TWO_IRON to "2 Iron",
            ClubNames.ONE_IRON to "1 Iron",
            ClubNames.DRIVING_IRON to "D Iron",
            ClubNames.SEVEN_HYBRID to "7 Hybrid",
            ClubNames.SIX_HYBRID to "6 Hybrid",
            ClubNames.FIVE_HYBRID to "5 Hybrid",
            ClubNames.FOUR_HYBRID to "4 Hybrid",
            ClubNames.THREE_HYBRID to "3 Hybrid",
            ClubNames.TW0_HYBRID to "2 Hybrid",
            ClubNames.ONE_HYBRID to "1 Hybrid",
            ClubNames.SEVEN_WOOD to "7 Wood",
            ClubNames.SIX_WOOD to "6 Wood",
            ClubNames.FIVE_WOOD to "5 Wood",
            ClubNames.FOUR_WOOD to "4 Wood",
            ClubNames.THREE_WOOD to "3 Wood",
            ClubNames.TWO_WOOD to "2 Wood",
            ClubNames.DRIVER to "Driver"
        )
    }

    fun getClubNameFromString(club: String?): ClubNames {
        return this.clubList.filterValues { it == club }.keys.first()
    }
}