public class pyramid {
        public static void main(String[] args) {
            for(int i=0;i<5;i++){
                for(int k=0;k<4-i;k++){
                    System.out.print(" ");
                }
                for(int j=0;j<2*i+1;j++){
                    System.out.print("*");
                }
                for(int k=0;k<4-i;k++){
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
}
