package src.design_patterns.startegyDesignPattern.practiceQuestions.sortingstartegy;

public abstract class SortingContext {

    private SortingStrategyInterface sortingStrategyInterface;

    protected SortingContext(SortingStrategyInterface sortingStrategyInterface) {
        this.sortingStrategyInterface = sortingStrategyInterface;
    }

    protected void sortArray(int[] arr) {
        System.out.println("We are using - " + this.sortingStrategyInterface.getStrategyName());
        this.sortingStrategyInterface.sort(arr);
    }
}
