package src.design_patterns.startegyDesignPattern.practiceQuestions.sortingstartegy;

public class InsertionSortStrategy implements SortingStrategyInterface {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String getStrategyName() {
        return "Insertion Sort";
    }
}
