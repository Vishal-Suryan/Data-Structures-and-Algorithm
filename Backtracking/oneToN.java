public class oneToN{
    static void printN(int i,int n){
        if(i<1){
            return;
        }
        printN(i-1,n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        int n=5;
        printN(5,5);
    }
}