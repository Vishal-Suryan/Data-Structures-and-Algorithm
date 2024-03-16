import java.util.*;

public class sumn {

  public static void main(String[] args) {
      solve(3,0);

  }
  public static void solve(int n,int sum) {
    if(n<1){
      System.out.println(sum);
      return ;
    }
    
    solve(n-1,sum+n);

  }
}