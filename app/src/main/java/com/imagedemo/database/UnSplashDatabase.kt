package com.imagedemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.imagedemo.database.dao.UnSplashDao
import com.imagedemo.helpers.Converters
import com.imagedemo.model.UnSplashModel

@Database(entities = [UnSplashModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class UnSplashDatabase : RoomDatabase() {
    abstract fun unSplashDao(): UnSplashDao
}