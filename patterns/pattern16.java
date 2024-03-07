public class pattern16 {
    public static void main(String[] args) {
        char charr = 'A';
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print(charr);
            }
            charr++;
            System.out.println();
        }
    }
}
