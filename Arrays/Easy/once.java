import java.util.*;
public class once {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        appearOnce(arr);
        
    }

    public static void appearOnce(int[] arr){
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int count=mp.getOrDefault(arr[i], 0);
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],count+1);
            }else{
                mp.put(arr[i],1);
            }
        }
        int key=0;int flag=0;
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue().equals(1)){
                key=entry.getKey();
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("Number that appeared Once in Array: "+key);
        }else{
            System.out.println("No Number Appreared Once!");
        }
        return;
    }
}
