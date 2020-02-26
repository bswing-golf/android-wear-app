package com.example.bswing_wear_os

class Club {

    var selectedClub: ClubTypes

    init {
        this.selectedClub = ClubTypes.GAP_WEDGE
    }

    fun selectClub(club: ClubTypes) {
        this.selectedClub = club
    }

}
