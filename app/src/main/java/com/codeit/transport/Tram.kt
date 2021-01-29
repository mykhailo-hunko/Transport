package com.codeit.transport

import kotlinx.serialization.Serializable


@Serializable
data class Tram(val number: Int = 16111, val list: MutableList<String> = mutableListOf<String>("5:22", "6:12")) {
    

}