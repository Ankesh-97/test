public class Generics {
    public static void main(String[] args) {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int[] help = new int[nums.length];
        for(int i=0;i<help.length;i++){
            help[i] = -1;
        }
        int n = nums.length;
        int val = aux(nums,0,n,help);
        //System.out.println(Arrays.toString(help));

    }

    static int aux(int[] nums,int st,int n,int[] help){
        if(st==n-1){
            return 0;
        }
        if(st>=n || nums[st]==0){
            return Integer.MAX_VALUE;
        }
        if(help[st]!=-1){
            return help[st];
        }

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=nums[st];i++){
            int val = aux(nums,i+st,n,help);
            System.out.println(val+"  "+i+" "+st);
            min = Math.min(min,val);
        }
        if(min!=Integer.MAX_VALUE){
            help[st] = min+1;
        }else{
            help[st] = min;
        }
        return help[st];
    }
}