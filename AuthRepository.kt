package com.professorsagi.rprassapp.features.auth.domain.repository

import com.professorsagi.rprassapp.core.util.Resource
import kotlinx.coroutines.flow.Flow

// Interface defining authentication operations
interface AuthRepository {
    // Function to register a user with email and password
    suspend fun registerUser(email: String, password: String): Flow<Resource<Unit>>

    // Function to log in a user with email and password
    suspend fun loginUser(email: String, password: String): Flow<Resource<Unit>>

    // Function to log out the current user
    suspend fun logoutUser(): Flow<Resource<Unit>>

    // Function to check if a user is currently logged in
    fun isUserLoggedIn(): Boolean

    // Function to send a password reset email
    suspend fun sendPasswordResetEmail(email: String): Flow<Resource<Unit>>
}

