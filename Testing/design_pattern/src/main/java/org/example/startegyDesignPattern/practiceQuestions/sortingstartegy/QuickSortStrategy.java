package org.example.startegyDesignPattern.practiceQuestions.sortingstartegy;

public class QuickSortStrategy implements SortingStrategyInterface {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (end > begin) {
            int partition = getPartitionIndex(arr, begin, end);
            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    private int getPartitionIndex(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[end];
        arr[end] = arr[i + 1];
        arr[i + 1] = temp;
        return i + 1;
    }

    @Override
    public String getStrategyName() {
        return "QuickSort Algo";
    }
}
