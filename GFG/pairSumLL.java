import java.util.ArrayList;
import java.util.Arrays;

public class pairSumLL {
    class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}


class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Node left=head;
        Node right=head;
        while(right.next!=null){
            right=right.next;
        }
        while(left.data<right.data){
            if(left.data+right.data == target){
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(left.data, right.data));
                ans.add(list);
                left=left.next;
                right=right.prev;
            }else if(left.data + right.data >target){
                right=right.prev;
            }else{
                left=left.next;
            }
        }
        return ans;
    }
}
}
