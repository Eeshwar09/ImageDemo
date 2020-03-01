package com.imagedemo.database.dao

import androidx.room.*
import com.imagedemo.model.UnSplashModel

@Dao
interface LikeUnLikeDao {

    @Query("SELECT * FROM unsplash_data")
    fun getAll(): MutableList<UnSplashModel>

    @Insert
    fun insert(vararg unSplash: UnSplashModel?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(unSplashList: List<UnSplashModel>?)

    @Query("DELETE FROM unsplash_data")
    fun delete()

    @Update
    fun update(vararg unSplash: UnSplashModel?)
}