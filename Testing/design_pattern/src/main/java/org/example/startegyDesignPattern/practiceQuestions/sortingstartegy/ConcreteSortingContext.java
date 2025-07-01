package src.design_patterns.startegyDesignPattern.practiceQuestions.sortingstartegy;

public class ConcreteSortingContext extends SortingContext {

    protected ConcreteSortingContext(SortingStrategyInterface sortingStrategyInterface) {
        super(sortingStrategyInterface);
    }

    @Override
    protected void sortArray(int[] arr) {
        super.sortArray(arr);
    }
}
