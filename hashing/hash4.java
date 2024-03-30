import java.util.*;
public class hash4 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){

            arr[i]=sc.nextInt();
        }
        System.out.println("Input Array: "+Arrays.toString(arr));
        
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=arr[i];
            int value=0;
            if(mp.containsKey(key)){
                value=mp.get(key);
            }
            value++;
            mp.put(key,value);

        }

        for (Map.Entry<Integer, Integer> itr : mp.entrySet()) {
            System.out.println(itr.getKey() + ":" + itr.getValue());
        }

        System.out.print("Enter size Queries: ");
        int q=sc.nextInt();
        System.out.print("Enter Queries: ");
        while(q-->0){
            int num =sc.nextInt();
            System.out.print("Output Frequencies: ");
            if(mp.containsKey(num)){
                System.out.println(mp.get(num));
            }else{
                System.out.println(0);
            }
        }
    }
}
