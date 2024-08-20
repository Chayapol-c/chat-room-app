package com.example.chatroomapp.ui.screen

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object ChatListScreen : Screen("chat_list_screen")
    object ChatScreen : Screen("chat_screen")

}