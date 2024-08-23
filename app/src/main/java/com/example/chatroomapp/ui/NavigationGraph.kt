package com.example.chatroomapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatroomapp.ui.screen.AuthViewModel
import com.example.chatroomapp.ui.screen.ChatRoomListScreen
import com.example.chatroomapp.ui.screen.ChatScreen
import com.example.chatroomapp.ui.screen.LoginScreen
import com.example.chatroomapp.ui.screen.Screen
import com.example.chatroomapp.ui.screen.SignUpScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignUpScreen.route
    ) {
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = {
                    navController.navigate(Screen.LoginScreen.route)
                }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUpScreen.route)
                },
                onSignInSuccess = {
                    navController.navigate(Screen.ChatScreen.route)
                }
            )
        }

        composable(Screen.ChatListScreen.route) {
            ChatRoomListScreen {
                navController.navigate("${Screen.ChatScreen.route}/${it.id}")
            }
        }

        composable("${Screen.ChatScreen.route}/{roomId}"){
            val roomId = it.arguments?.getString("roomId") ?: ""
            ChatScreen(roomId = roomId)
        }
    }
}