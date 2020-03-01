package com.imagedemo.helpers

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.imagedemo.helper.JsonHelper
import com.imagedemo.model.Links
import com.imagedemo.model.Sponsorship
import com.imagedemo.model.Urls
import com.imagedemo.model.User


object Converters {
    @TypeConverter
    @JvmStatic
    fun fromString(value: String): MutableList<Any> {
        val listType = object : TypeToken<MutableList<Any>>() {
        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromArrayList(list: MutableList<Any>): String = Gson().toJson(list)

    @TypeConverter
    @JvmStatic
    fun jsonToLinks(value: String): Links = JsonHelper.jsonToKt(value)

    @TypeConverter
    @JvmStatic
    fun linksToJson(value: Links): String = JsonHelper.KtToJson(value)

    @TypeConverter
    @JvmStatic
    fun jsonToSponsorship(value: String): Sponsorship = JsonHelper.jsonToKt(value)

    @TypeConverter
    @JvmStatic
    fun sponsorshipToJson(value: Sponsorship): String = JsonHelper.KtToJson(value)

    @TypeConverter
    @JvmStatic
    fun jsonToUrls(value: String): Urls = JsonHelper.jsonToKt(value)

    @TypeConverter
    @JvmStatic
    fun urlsToJson(value: Urls): String = JsonHelper.KtToJson(value)

    @TypeConverter
    @JvmStatic
    fun jsonToUser(value: String): User = JsonHelper.jsonToKt(value)

    @TypeConverter
    @JvmStatic
    fun userToJson(value: User): String = JsonHelper.KtToJson(value)

}