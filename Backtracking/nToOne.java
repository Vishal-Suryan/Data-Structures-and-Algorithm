public class nToOne {
    static void revprintN(int i,int n){
        if(i>n){
            return;
        }
        revprintN(i+1, n);
        System.out.println(i);
    }
    public static void main(String []args){
        revprintN(1, 5);
    }

}
