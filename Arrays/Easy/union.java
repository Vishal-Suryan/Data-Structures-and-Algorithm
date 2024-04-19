import java.util.*;
public class union {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size of Array 1: ");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter size of Array 2: ");
        int size2=sc.nextInt();
        int [] arr2 = new int[size2];
        System.out.print("Enter Elements: ");
        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc.nextInt();
        }
        union(arr,arr2);
    }
    public static void union(int[] arr,int[] arr2){
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int count =mp.getOrDefault(arr[i], 0);
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], count+1);
            }else{
                mp.put(arr[i], 1);
            }
        }    
        for(int i=0;i<arr2.length;i++){
            int count =mp.getOrDefault(arr2[i], 0);
            if(mp.containsKey(arr2[i])){
                mp.put(arr2[i], count+1);
            }else{
                mp.put(arr2[i], 1);
            }
        }
        for (Integer key : mp.keySet()) {
            System.out.print(key+" ");
          }    
        
        return;

    }
    /* public static void union(int[] arr, int[] arr2) {
        Set<Integer> elements = new HashSet<>();
      
        for (int i = 0; i < arr.length; i++) {
          elements.add(arr[i]);
        }
      
        for (int i = 0; i < arr2.length; i++) {
          elements.add(arr2[i]);
        }
      
        for (Integer element : elements) {
          System.out.print(element + " ");
        }
      }
       */
}
