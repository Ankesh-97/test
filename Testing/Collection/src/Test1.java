import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test1
{
    public static void main(String[] args)
    {
        call();
       try{
           List<Integer> list = List.of(1,2,3,4,4,5);
           Iterator<Integer> itr = list.iterator();
           list.sort(Integer::compareTo);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }

    public static void call() throws RuntimeException
    {
        try{
            List<Integer> list = List.of(1,2,3,4,4,5);
            Iterator<Integer> itr = list.iterator();
            list.sort(Integer::compareTo);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
