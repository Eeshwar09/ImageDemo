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
    fun fromString(value: String): MutableList<Any>? {
        val listType = object : TypeToken<MutableList<Any>>() {
        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun fromArrayList(list: MutableList<Any>?): String = Gson().toJson(list)

    @TypeConverter
    @JvmStatic
    fun jsonToLinks(value: String?): Links? = value?.let { JsonHelper.jsonToKt(it) }

    @TypeConverter
    @JvmStatic
    fun linksToJson(value: Links?): String? = value?.let { JsonHelper.KtToJson(it) }

    @TypeConverter
    @JvmStatic
    fun jsonToSponsorship(value: String?): Sponsorship? = value?.let { JsonHelper.jsonToKt(it) }

    @TypeConverter
    @JvmStatic
    fun sponsorshipToJson(value: Sponsorship?): String? = value?.let { JsonHelper.KtToJson(it) }

    @TypeConverter
    @JvmStatic
    fun jsonToUrls(value: String?): Urls? = value?.let { JsonHelper.jsonToKt(it) }

    @TypeConverter
    @JvmStatic
    fun urlsToJson(value: Urls?): String? = value?.let { JsonHelper.KtToJson(it) }

    @TypeConverter
    @JvmStatic
    fun jsonToUser(value: String?): User? = value?.let { JsonHelper.jsonToKt(it) }

    @TypeConverter
    @JvmStatic
    fun userToJson(value: User?): String? = value?.let { JsonHelper.KtToJson(it) }

}