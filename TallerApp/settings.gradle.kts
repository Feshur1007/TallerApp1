pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    // Opcional: resolución de versiones si quieres forzar versiones concretas
    plugins {
        // Declara aquí versiones globales si quieres
        id("com.android.application") version "8.1.0"
        id("com.android.library") version "8.1.0"
        id("org.jetbrains.kotlin.jvm") version "1.9.10"
        id("org.jetbrains.kotlin.android") version "1.9.10"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TallerApp"
include(":app")