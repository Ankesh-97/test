package oopsConceptsQuestions;

public class OverridingEqualsAndHashCodeMethod {
    /*
    Common Pitfalls:
     1. Not Following the Contract Between equals() and hashCode()
        > If you override equals() but not hashCode(), or if the two methods are inconsistent,
         collections like HashMap or HashSet may behave incorrectly,
         as they rely on hashCode() to locate the object.
     2. Using Mutable Fields in equals() and hashCode()
        > If equals() and hashCode() rely on mutable fields (fields whose values can change after the object is created),
           then the object's equality and hash code can change over time.
           This causes issues when the object is used in hash-based collections (HashMap, HashSet),
           where an object's position in the collection depends on its hash code.
        > Solution: Use only immutable fields in equals() and hashCode() to ensure the values used for
          comparison and hashing remain consistent.

     3. Failing to Check for null in equals()
     4. Incorrect Type Checking in equals()
     5. Inconsistent hashCode() (for generating hash codes we shouldnot use math.random methods)
     6. Not Overriding hashCode() When Overriding equals()

     */
}
