package com.reposenergy.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.reposenergy.data.models.Source

class Convertors {

//
    @TypeConverter
    fun convertSourceToString(heartRateZoneRanges: Source?): String {
        return Gson().toJson(heartRateZoneRanges)
    }

    @TypeConverter
    fun convertStringToSource(value: String?): Source{
        val listType = object : TypeToken<Source?>() {}.type
        return Gson().fromJson<Source>(value, listType)
    }

}