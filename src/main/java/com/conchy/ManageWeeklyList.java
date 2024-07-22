package com.conchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ManageWeeklyList {

    private List<String> weekDaysList;

    public ManageWeeklyList() {
        weekDaysList = new ArrayList<>();
        createDays();
    }

    private void createDays() {
        weekDaysList.add("Monday");
        weekDaysList.add("Tuesday");
        weekDaysList.add("Wednesday");
        weekDaysList.add("Thursday");
        weekDaysList.add("Friday");
        weekDaysList.add("Saturday");
        weekDaysList.add("Sunday");
    }

    public List<String> getDaysOfWeek() {
        return new ArrayList<>(weekDaysList);
    }

    public int getLengthOfDaysList() {
        return weekDaysList.size();
    }

    public void removeDay(String day) {
        weekDaysList.remove(day);
    }

    public String wantedDay(int index) {
        if (index >= 0 && index < weekDaysList.size()) {
            return weekDaysList.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    public boolean dayExists(String day) {
        return weekDaysList.contains(day);
    }

    public void sortDaysAlphabetically() {
        Collections.sort(weekDaysList);
    }

    public void clearDaysOfWeek() {
        weekDaysList.clear();
    }

    public void printDaysOfWeek(List<String> daysOfWeek) {
        daysOfWeek.forEach(System.out::println);
    }


    public static void main(String[] args) {

        ManageWeeklyList weeklyList = new ManageWeeklyList();

        System.out.println("Days of the week:");
        weeklyList.printDaysOfWeek(weeklyList.getDaysOfWeek());
        System.out.println("Length of the list: " + weeklyList.getLengthOfDaysList());

        System.out.println("Does 'Monday' exist?: " + weeklyList.dayExists("Monday"));

        System.out.println("Day at index 2: " + weeklyList.wantedDay(2));

        weeklyList.sortDaysAlphabetically();
        System.out.println("Days of the week after sorting alphabetically:");
        weeklyList.printDaysOfWeek(weeklyList.getDaysOfWeek());

        weeklyList.removeDay("Tuesday");
        System.out.println("Days of the week after removing 'Tuesday':");
        weeklyList.printDaysOfWeek(weeklyList.getDaysOfWeek());

        weeklyList.clearDaysOfWeek();
        System.out.println("Days of the week after clearing the list:");
        weeklyList.printDaysOfWeek(weeklyList.getDaysOfWeek());
    }
}
