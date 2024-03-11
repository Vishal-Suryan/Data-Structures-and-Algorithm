
public class printnum {
    static int count=0;
    static int print_till_10(){
        if( count==10 )return 0;
        System.out.println(count);
        count++;
        print_till_10();
        return 0;
    }
    public static void main(String[] args) {
        print_till_10();
    }
}
