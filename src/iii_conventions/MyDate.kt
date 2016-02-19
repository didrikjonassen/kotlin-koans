package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    infix operator fun compareTo(that: MyDate): Int {
        return if (year != that.year)
            year.compareTo(that.year)
        else if (month != that.month)
            month.compareTo(that.month)
        else
            dayOfMonth.compareTo(that.dayOfMonth)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
