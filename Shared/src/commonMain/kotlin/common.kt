package com.anggitprayogo.kotlinmultiplatformproject

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}