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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    infix operator fun contains(date: MyDate): Boolean {
        return start < date && date <= endInclusive
    }

    operator fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var current = start
            override fun next(): MyDate {
                val temp = current
                current = current.nextDay()
                return temp
            }

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }
        }
    }
}
