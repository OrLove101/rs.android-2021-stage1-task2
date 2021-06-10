package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        return if ( a.toUpperCase().filter { b.contains(it) } == b ) "YES" else "NO"
    }
}