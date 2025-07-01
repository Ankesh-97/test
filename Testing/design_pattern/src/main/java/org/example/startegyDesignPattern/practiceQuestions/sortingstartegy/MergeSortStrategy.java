package src.design_patterns.startegyDesignPattern.practiceQuestions.sortingstartegy;

public class MergeSortStrategy implements SortingStrategyInterface {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);
        sort(left);
        sort(right);
        //merge(array,left,right);

    }

    @Override
    public String getStrategyName() {
        return "MergeSortStrategy";
    }
}
