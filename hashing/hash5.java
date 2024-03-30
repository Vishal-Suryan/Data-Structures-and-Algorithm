import java.util.*;
public class hash5 {
    public static void main(String [] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Size of Input Array: ");
        int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Input Array: "+Arrays.toString(arr));

        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int count = mp.getOrDefault(arr[i], 0);
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],count+1);
            }else{
                mp.put(arr[i],1);
            }
        }
        
        int minFreq=n , minElement=0; 
        int maxFreq=0 , maxElement=0;
        for(Map.Entry<Integer,Integer> itr: mp.entrySet()){
            int count= itr.getValue();
            int element= itr.getKey();
            if(count>maxFreq){
                maxFreq=count;
                maxElement=element;
            }
            if(count<minFreq){
                minFreq=count;
                minElement=element;
            }
            
        }

        System.out.println("Max Key: "+maxElement);
        System.out.println("Min Key: "+minElement);
        System.out.println("Max freq: "+maxFreq);
        System.out.println("Min freq: "+minFreq);
        
    }
}
