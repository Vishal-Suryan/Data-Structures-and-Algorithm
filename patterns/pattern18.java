public class pattern18 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            char charr = 'E';
            for(int j=0;j<=i;j++){
                System.out.print(charr);
                charr--;
            }
            System.out.println();
        }
    }
}
