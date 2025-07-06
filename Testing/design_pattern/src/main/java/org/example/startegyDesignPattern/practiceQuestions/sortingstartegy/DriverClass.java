package org.example.startegyDesignPattern.practiceQuestions.sortingstartegy;

import java.util.Arrays;

public class DriverClass {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 3, 7, 2};
        SortingContext sortingContext = new ConcreteSortingContext(new QuickSortStrategy());
        sortingContext.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
