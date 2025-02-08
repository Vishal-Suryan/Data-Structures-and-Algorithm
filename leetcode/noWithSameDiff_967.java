import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class noWithSameDiff_967 {
    class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        /* for(int num=1;num<=9;num++){
            dfs(num,n-1,k,res);
        } */
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=9;i++){
            q.offer(i);
        }
        int len=1;
        while(!q.isEmpty() && len<n){
            len++;
            int s=q.size();
            for(int i=0;i<s;i++){
                int node=q.poll();
                int lastDigit=node%10;
                if(lastDigit +k<=9){
                    q.offer(node*10+lastDigit+k);
                }
                if(k!=0 && lastDigit-k>=0){
                    q.offer(node*10+lastDigit-k);
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        int[] retRes=new int[res.size()];
        for(int i=0;i<res.size();i++){
            retRes[i]=res.get(i);
        }
        return retRes;
    }
    /* private void dfs(int num,int n,int k,ArrayList<Integer> res){
        if(n==0){
            res.add(num);
            return;
        }
        int lastDigit=num%10;
        if(lastDigit + k <=9) dfs(num*10 + lastDigit+k,n-1,k,res);
        if(k!=0 && lastDigit - k >=0) dfs(num*10 + lastDigit-k,n-1,k,res);
    } */
}
}
