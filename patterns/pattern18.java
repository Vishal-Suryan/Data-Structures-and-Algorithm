class Main {
   static void pattern18(int N){
    for(int i=0;i<N;i++){
        for(int j=0;j<i;j++){
            int charr=(int)(char)'A'+N-1-i;
            System.out.print(charr);
            charr++;
        }
        System.out.println();
    }
 }
 
     public static void main(String[] args) {
         int N = 5;
         pattern18(N);
     }
 }