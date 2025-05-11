import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Human implements  Comparable<Human>,Comparator<Human>{
    private String name;
    private int age;

    @Override
    public int compareTo(Human o) {
        return this.getName().compareTo(o.getName());
    }

    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return Integer.compare(lhs.age, rhs.age);
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}

class HumanNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
