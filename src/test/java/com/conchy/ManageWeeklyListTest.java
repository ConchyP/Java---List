package com.conchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ManageWeeklyListTest {

    @Test
    void testClearDaysOfWeek() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        weeklyList.clearDaysOfWeek();
        assertTrue(weeklyList.getDaysOfWeek().isEmpty());
    }

    @Test
    void testDayExists() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        assertTrue(weeklyList.dayExists("Monday"));
        assertFalse(weeklyList.dayExists("InvalidDay"));
    }

    @Test
    void testGetDaysOfWeek() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        List<String> daysOfWeek = weeklyList.getDaysOfWeek();
        assertNotNull(daysOfWeek);
        assertEquals(7, daysOfWeek.size());
    }

    @Test
    void testGetLengthOfDaysList() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        assertEquals(7, weeklyList.getLengthOfDaysList());
    }

    @Test
    void testSortDaysAlphabetically() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        weeklyList.sortDaysAlphabetically();
        List<String> sortedDays = weeklyList.getDaysOfWeek();
        for (int i = 1; i < sortedDays.size(); i++) {
            assertTrue(sortedDays.get(i - 1).compareTo(sortedDays.get(i)) <= 0);
        }
    }

    @Test
    void testRemoveDay() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        weeklyList.removeDay("Tuesday");
        assertFalse(weeklyList.dayExists("Tuesday"));
    }

    @Test
    void testWantedDay() {
        ManageWeeklyList weeklyList = new ManageWeeklyList();
        assertEquals("Wednesday", weeklyList.wantedDay(2));
        assertThrows(IndexOutOfBoundsException.class, () -> weeklyList.wantedDay(10));
    }
}
