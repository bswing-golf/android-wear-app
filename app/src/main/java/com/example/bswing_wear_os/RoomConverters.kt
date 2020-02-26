package com.example.bswing_wear_os

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverters {

    @TypeConverter
    fun fromString(swingData: String): ArrayList<Array<Array<Double>>> {
        val swingDataType = object: TypeToken<ArrayList<Array<Array<Double>>>>() {}.type
        return Gson().fromJson(swingData, swingDataType)
    }

    @TypeConverter
    fun fromArrayList(swingData: ArrayList<Array<Array<Double>>>?): String {
        val gson = Gson()
        val json = gson.toJson(swingData)
        return json
    }

}