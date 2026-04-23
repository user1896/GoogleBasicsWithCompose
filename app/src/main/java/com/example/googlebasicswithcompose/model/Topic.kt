package com.example.googlebasicswithcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val associatedCoursesNbr: Int,
    @DrawableRes val imageResourceId: Int
)
