public class PassByValVsPassByRef {
    static int z = 5;
    public static void main(String[] args) {

//        int x = 5;
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                x = x+1;
//                System.out.println("x = " + x);
//            }
//        };

    }

    public static void method(int y){
        int x = 0;
         class NestedClass{
            public void method(){
                System.out.println(z++);
            }
        }

    }
}
