package com.example.chatroomapp.ui

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun formatTimestamp(timestamp: Long): String {
    val messageDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
    val now = LocalDateTime.now()
    return when {
        isSameDay(messageDateTime, now) -> {
            "today${formatDate(messageDateTime)}"
        }
        isSameDay(messageDateTime.plusDays(1), now) -> {
            "yesterday${formatDate(messageDateTime)}"
        }
        else -> {
            formatDate(messageDateTime)
        }
    }
}

private fun isSameDay(dateTime1: LocalDateTime, dateTime2: LocalDateTime): Boolean {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return dateTime1.format(formatter) === dateTime2.format(formatter)
}

private fun formatDate(dateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("MMM d, yyyy")
    return formatter.format(dateTime)
}