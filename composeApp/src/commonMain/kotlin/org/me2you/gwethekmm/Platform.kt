package org.me2you.gwethekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform