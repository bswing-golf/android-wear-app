package com.example.bswing_wear_os

import androidx.room.TypeConverters

private const val COLLECTION_NAME = "swings"

class RepositorySwing(val local: DaoSwing) {

    suspend fun getLocalSwings(): List<RoomSwing> {
        return local.getAllSwings()
    }

    suspend fun getLocalSwing(club: String): RoomSwing {
        return local.getSwingByClub(club)
    }

    suspend fun deleteLocalSwing(swing: RoomSwing) {
        local.deleteSwing(swing)
    }

    suspend fun updateLocalSwing(club: String, swingData: String) {
        local.insertOrUpdateSwing(RoomSwing(club, swingData))
    }

}