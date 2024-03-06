public class pattern11 {
    public static void main(String[] args) {
        int start_var =1;
        for(int i=1;i<=5;i++){
            if(i%2 != 0){
                start_var=1;
            }else{
                start_var=0;
            }
            for(int j=1;j<=i;j++){
                System.out.print(start_var);
                start_var= 1 - start_var;
            }
        System.out.println();
        }
    }
}
