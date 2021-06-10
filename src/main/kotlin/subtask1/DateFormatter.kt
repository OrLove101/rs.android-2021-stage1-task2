package subtask1

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        val simpleDateFormatValidator = SimpleDateFormat("dd.MM.yyyy", Locale("ru"))
        val simpleDateFormatResult = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))
        val dateResult: Date

        simpleDateFormatValidator.isLenient = false
        try {
            dateResult = simpleDateFormatValidator.parse("${day.toString()}.${month.toString()}.${year.toString()}")
        } catch ( e: ParseException ) {
            return "Такого дня не существует"
        }
        return simpleDateFormatResult.format(dateResult)
    }
}

fun main(args: Array<String>) {
    //DATE
    val date = Date()//represent current date in milliseconds from 1 january 1970
//    print(date)

    //CALENDAR
    val calendar = Calendar.getInstance()//class to change date dynamically
//    println(calendar.time)

    calendar.time = date
//    println(calendar.time)

    //DATE FORMAT (заготовленные форматы)
    val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT)
//    println(dateFormat.format(calendar.time)) //dateFormat.format(date)

    //SIMPLE DATE FORMAT (свой формат или парсинг)
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
//    println(simpleDateFormat.format(calendar.time))

    //REVERSE TRANSFORMATION
    val newDate = simpleDateFormat.parse("05/12/1985")
    println(newDate)
}
