package src.design_patterns.startegyDesignPattern.practiceQuestions.sortingstartegy;

public class BubbleSortStrategy implements SortingStrategyInterface {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getStrategyName() {
        return "Bubble Sort Strategy";
    }
}
