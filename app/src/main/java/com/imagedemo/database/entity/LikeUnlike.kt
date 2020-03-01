package com.imagedemo.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "like_unlike")
class LikeUnlike(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val photoId: String,
    val syncState: Byte = 0
)



