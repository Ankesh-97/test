import org.apache.commons.compress.utils.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewClass {
    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans = Lists.newArrayList();

        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Jack", 12));

        humans.sort(Human::compareByNameThenAge);
            
        System.out.println(humans.get(0).hashCode()+" "+new Human("Jack", 12).hashCode());
        Assertions.assertEquals(humans.get(0), new Human("Jack", 12),"");
    }
}