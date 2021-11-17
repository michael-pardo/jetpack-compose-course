package com.mistpaag.profilecardlayout

data class UserProfile(
    val name: String,
    val status: Boolean,
    val drawableId: Int
)

val userProfileList = listOf(
    UserProfile("John Doe", true, R.drawable.profile_picture),
    UserProfile("Ana Joans", false, R.drawable.profile_picture2),
)