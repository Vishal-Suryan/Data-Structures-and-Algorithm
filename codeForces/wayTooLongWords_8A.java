import java.util.*;
public class wayTooLongWords_8A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String str = sc.next();
            list.add(str);
        }
        for(int i = 0; i<list.size(); i++){
            String str = list.get(i);
            if(str.length() > 10){
                System.out.println(str.charAt(0) + "" + (str.length() - 2) + "" + str.charAt(str.length() - 1));
            }else{
                System.out.println(str);
            }
        }
        sc.close();
        return;
    }
}
