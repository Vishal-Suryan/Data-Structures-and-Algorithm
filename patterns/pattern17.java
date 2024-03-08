public class pattern17 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5-i;j++){
                System.out.print("*");
            }
            char charr ='A';
            for(int j=1;j<=2*i+1;j++){
                int breakpoint = (2*i+1)/2;
                System.out.print(charr);
                if(j<=breakpoint){
                    charr++;
                }else{
                    charr--;
                }
            }
            for(int j=0;j<5-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
