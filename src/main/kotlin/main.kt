fun main() {
    val seconds = 400
    agoToText(seconds)
}

fun agoToText(time: Int) {
    when (time) {
        in 0..Time.MM.value ->
            print("Был(а) только что")

        in 61..Time.HH.value -> {
            val tempTime = time / Time.MM.value
            print("Был(а) в сети $tempTime ${minToMinutesHourToHours(tempTime.toString(), Time.MM)} назад")
        }

        in (Time.HH.value + 1)..(Time.DD.value) -> {
            val tempTime = time / Time.HH.value
            print("Был(а) в сети $tempTime ${minToMinutesHourToHours(tempTime.toString(), Time.HH)} назад")
        }

        in (Time.DD.value + 1)..(Time.DD.value * 2) ->
            print("Был(а) в сети сегодня")

        in (Time.DD.value * 2 + 1)..(Time.DD.value * 3) ->
            print("Был(а) в сети вчера")

        in (Time.DD.value * 3 + 1)..Int.MAX_VALUE ->
            print("Был(а) в сети давно")
    }
}

fun minToMinutesHourToHours(time: String, type: Time): String {
    val lastSymbol = time[time.length - 1]
    when (type) {
        Time.MM ->
            when (lastSymbol) {
                '1' -> return "минуту"
                in '2'..'4' -> return "минуты"
                in '5'..'9', '0' -> return "минут"
            }

        Time.HH ->
            when (lastSymbol) {
                '1' -> return "час"
                in '2'..'4' -> return "часа"
                in '5'..'9', '0' -> return "часов"
            }

        else -> return "Ошибка"
    }
    return "Ошибка"
}