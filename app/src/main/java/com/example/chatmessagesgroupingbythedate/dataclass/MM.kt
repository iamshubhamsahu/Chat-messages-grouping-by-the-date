package com.example.chatmessagesgroupingbythedate.dataclass

data class Message(
    val id: String? = null,
    val text: String? = null,
    var time: String? = null,
    val type: String? = null,
    val name: String? = null
)