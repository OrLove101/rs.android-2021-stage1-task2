package subtask3

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            String::class -> {
                var result = ""

                blockA.forEach { if ( it is String ) result += it }
                return result
            }
            Int::class -> {
                var result = 0

                blockA.forEach { if ( it is Int ) result += it }
                return result
            }
            LocalDate::class -> {
                var localDateResult: LocalDate = LocalDate.MIN
                val sdf = SimpleDateFormat("dd.MM.yyyy")
                var calendarResult: Calendar = Calendar.getInstance()

                blockA.forEach {
                    if ( it is LocalDate && it > localDateResult ) {
                        localDateResult = it
                    }
                }
                calendarResult.set(localDateResult.year, localDateResult.monthValue - 1, localDateResult.dayOfMonth)
                return if ( localDateResult == LocalDate.MIN ) "" else sdf.format(calendarResult.time)
            }
        }
        return ""
    }
}
