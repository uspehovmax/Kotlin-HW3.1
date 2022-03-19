package ru.netology

const val minute = 60
const val hour = 60 * minute
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
        85 * hour
    )
    var i = 0
    while (i < timesArray.size) {
        message = timeCalculate(timesArray[i])
        agoToText(message)
        i++
    }
}

fun timeCalculate(currentSeconds: Int): String {
    when (true/* */) {
        (currentSeconds / minute < 1) -> message = "только что"
        (currentSeconds / hour < 1 && currentSeconds / minute >= 1) -> howManyMinutes(currentSeconds)
        (currentSeconds / hour in 1..23) -> howManyHours(currentSeconds)
        (currentSeconds / hour in 24..47) -> message = "сегодня"
        (currentSeconds / hour in 48..71) -> message = "вчера"
        else -> {
            message = "давно"
        }
    }
    return message
}

fun howManyMinutes(currentSeconds: Int): String {
    val value = (currentSeconds / minute).toInt()
    when (true/* */) {
        (value % 10) == 1 && value != 11 -> message = "$value минуту"
        (value % 10 == 2 && value != 12 || value % 10 == 3 && value != 13 || value % 10 == 4 && value != 14)
        -> message = "$value минуты"
        else -> {
            message = "$value минут"
        }
    }
    message += " назад"
    return message
}

fun howManyHours(currentSeconds: Int): String {
    val value = (currentSeconds / hour).toInt()
    when (true /**/) {
        (value == 1 || value == 21) -> message = "$value час"
        (value == 2 || value == 3 || value == 4 || value == 22 || value == 23) -> message = "$value часа"
        else -> {
            message = "$value часов"
        }
    }
    message += " назад"
    return message
}

fun agoToText(currentMessage: String) {
    println("был(а) в сети $currentMessage")
}