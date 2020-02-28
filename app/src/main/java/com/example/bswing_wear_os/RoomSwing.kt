package com.example.bswing_wear_os

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "swings",
    indices = [Index("club")]
)
data class RoomSwing(

    @PrimaryKey
    @ColumnInfo(name = "club")
    val club: String,

    @ColumnInfo(name = "swing_data")
    val swingData: String

)