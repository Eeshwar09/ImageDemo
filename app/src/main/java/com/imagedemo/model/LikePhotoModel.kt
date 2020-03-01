package com.imagedemo.model

data class LikePhotoModel(
    val photo: Photo,
    val user: UserLike
)

data class Photo(
    val color: String,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: LinksLike,
    val urls: Urls,
    val width: Int
)

data class LinksLike(
    val download: String,
    val html: String,
    val self: String
)

data class UserLike(
    val id: String,
    val links: LinksXLike,
    val name: String,
    val username: String
)

data class LinksXLike(
    val html: String,
    val likes: String,
    val photos: String,
    val self: String
)