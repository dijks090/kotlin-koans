package i_introduction._6_Data_Classes

import org.junit.Assert.assertEquals
import org.junit.Test


class N06DataClassesKtTest {
    @Test fun testListOfPeople() {
        assertEquals("[Person(name=Alice, priorities=29), Person(name=Bob, priorities=31)]", task6().toString())
    }
}