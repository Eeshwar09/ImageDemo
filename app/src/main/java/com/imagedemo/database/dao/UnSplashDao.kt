package com.imagedemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.imagedemo.model.UnSplashModel

@Dao
interface UnSplashDao {

    @Query("SELECT * FROM unsplash_data")
    fun getAll(): List<UnSplashModel>

    @Insert
    fun insert(vararg unSplash: UnSplashModel?)

    @Insert(onConflict = REPLACE)
    fun insertAll(unSplashList: List<UnSplashModel>?)

    @Query("DELETE FROM unsplash_data")
    fun delete()

}