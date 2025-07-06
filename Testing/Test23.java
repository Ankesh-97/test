import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

public class Test23 {

    public static void main(String[] args) {

        Thread t1 = new Thread();
        t1.start();


    }

    public static void sort(int[] arr){

        int low = 0,high= arr.length-1;

        while(low<high){
            if(arr[low] == 0){
                low++;
            }else{
                if(arr[high] == 0){
                    int t = arr[low];
                    arr[low] = arr[high];
                    arr[high] = t;
                    low++;
                    high--;
                }else{
                    high--;
                }
            }
        }
    }
}
