package iii_conventions

import iv_properties.toMillis

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        if (this.year != other.year) this.year - other.year
        if (this.month != other.month) this.month- other.month
        return this.dayOfMonth - other.dayOfMonth
    }
}


operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate){
    operator fun contains(d: MyDate): Boolean {
        return (start.toMillis() <= d.toMillis()) &&  ( d.toMillis() <= endInclusive.toMillis())
    }

//
//    operator fun iterator(): Iterator<MyDate> {
//        return start.nextDay()
//    }
}
