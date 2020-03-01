package com.example.bswing_wear_os

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverters {

    @TypeConverter
    fun fromString(swingData: String): ArrayList<Array<FloatArray>> {
        val swingDataType = object: TypeToken<ArrayList<Array<FloatArray>>>() {}.type
        return Gson().fromJson(swingData, swingDataType)
    }

    @TypeConverter
    fun fromArrayList(swingData: ArrayList<Array<FloatArray>>?): String {
        val gson = Gson()
        val json = gson.toJson(swingData)
        return json
    }

}