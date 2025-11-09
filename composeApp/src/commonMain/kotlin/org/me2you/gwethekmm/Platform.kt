package org.me2you.gwethekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

fun isPlatformDesktop(): Boolean{
    val platform = getPlatform()
    return !(platform.name.lowercase().contains("android") || platform.name.lowercase().contains("ios"))
}