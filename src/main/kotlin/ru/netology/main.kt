package ru.netology

const val minute = 60
const val hour = 60 * minute
const val day = 24 * hour
var message = ""

fun main() {
    val timesArray = arrayOf(
        35,
        15 * minute,
        22 * minute,
        51 * minute,
        21 * hour,
        5 * hour,
        3 * hour,
        35 * hour,
        54 * hour,
        5 * day
    )
    var i = 0
    while (i < timesArray.size) {
        message = timeCalculate(timesArray[i])
        agoToText(message)
        i++
    }
}

fun timeCalculate(currentSeconds: Int): String {
    message = when (currentSeconds > 0) {
        (currentSeconds / minute < 1) -> "только что"
        (currentSeconds / hour < 1 && currentSeconds / minute >= 1) -> howManyMinutes(currentSeconds)
        (currentSeconds / hour in 1..23) -> howManyHours(currentSeconds)
        (currentSeconds / hour in 24..47) -> "сегодня"
        (currentSeconds / hour in 48..71) -> "вчера"
        else -> {
            "давно"
        }
    }
    return message
}

fun howManyMinutes(currentSeconds: Int): String {
    val value = (currentSeconds / minute).toInt()
    message = when (value >= 1) {
        (value % 10) == 1 && value != 11 -> "$value минуту"
        (value % 10 == 2 && value != 12 || value % 10 == 3 && value != 13 || value % 10 == 4 && value != 14)
        -> "$value минуты"
        else -> {
            "$value минут"
        }
    }
    message += " назад"
    return message
}

fun howManyHours(currentSeconds: Int): String {
    val value = (currentSeconds / hour).toInt()
    message = when (value >= 1) {
        (value == 1 || value == 21) -> "$value час"
        (value == 2 || value == 3 || value == 4 || value == 22 || value == 23) -> "$value часа"
        else -> {
            "$value часов"
        }
    }
    message += " назад"
    return message
}

fun agoToText(currentMessage: String) {
    println("был(а) в сети $currentMessage")
}