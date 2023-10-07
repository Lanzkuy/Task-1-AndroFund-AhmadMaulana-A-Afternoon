package com.lans.task_android_fundamental

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val password: String
) : Parcelable
