import java.util.*;

public class intersection {
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
        intersection(arr,arr2);
    }
    public static void intersection(int[] arr,int[] arr2){
        int j=0;
        int i=0;
        ArrayList<Integer> res=new ArrayList<>();
        while(i<arr.length && j<arr2.length){
            if(arr[i]==arr2[j]){
                res.add(arr[i]);
                i++;
                j++;
            }else if(arr[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }
        System.out.println(res);
        return ;
    }
    public int[] intersection2(int[] arr, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set1.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(set1.contains(arr2[i])){
                set2.add(arr2[i]);    
            }
        }
        int[] result = new int[set2.size()];
        int i =0;
        for (int x:set2){
            result[i] = x;
            i++;
        }
        return result;
        
    }
}
