package com.example.composeapplication.starBugsUi

data class menu(
    val id: Int,
    val title: String
)

val menuList = listOf(
    menu(
        1,
        "All"
    ),
    menu(
        2,
        "Coffee"
    ),
    menu(
        3,
        "Tea"
    ),
    menu(
        4,
        "Drinks"
    ),
    menu(
        5,
        "Beer"
    ),
    menu(
        6,
        "Wine"
    )
)
