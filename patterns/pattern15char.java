public class pattern15char {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            char charr = 'A';
            for(int j=5;j>i;j--){
                System.out.print(charr);
                charr++;
            }
            System.out.println();
        }
    }
}
