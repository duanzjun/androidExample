package com.android.layout.bean

data class CommonModel(
    val title: String,
    val contnetList: List<CommonItemModel>
)

data class CommonItemModel(
    val title: String,
    val url: String
)