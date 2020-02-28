package com.example.bswing_wear_os

import androidx.room.*

@Dao
@TypeConverters(RoomConverters::class)
interface DaoSwing {

    @Query("SELECT * FROM swings")
    suspend fun getAllSwings(): List<RoomSwing>

    @Query("SELECT * FROM swings WHERE club = :club")
    suspend fun getSwingByClub(club: String): RoomSwing

    @Delete
    suspend fun deleteSwing(swing: RoomSwing)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateSwing(swing: RoomSwing)

}