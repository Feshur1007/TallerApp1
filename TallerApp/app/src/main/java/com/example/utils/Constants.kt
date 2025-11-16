package com.feshur1007.tallerapp.utils

object Constants {
    // Base URL de la Fake Store API (usar en RetrofitInstance)
    const val BASE_URL = "https://fakestoreapi.com/"

    // Nombres para persistencia
    const val DATABASE_NAME = "tallerapp_db"
    const val DATASTORE_NAME = "session_preferences"

    // Keys adicionales (si las necesitas globalmente)
    const val PREF_KEY_LOGGED_IN = "logged_in"
    const val PREF_KEY_AUTH_TOKEN = "auth_token"
}