public class minMoves_2037 {
    class Solution {
        static int findMax(int[] arr){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                max=Math.max(max,arr[i]);
            }
            return max;
        }
        public int minMovesToSeat(int[] seats, int[] students) {
            int max=findMax(seats);
            int max1=findMax(students);
            int[] seat=new int[max+1];
            int[] student=new int[max1+1];
            int total=seats.length;
            for(int i=0;i<total;i++){
                seat[seats[i]]++;
                student[students[i]]++;
            }
            int moves=0;
            int i=0,j=0;
            while(total>0){
                while(seat[i]==0){
                    i++;
                }
                while(student[j]==0){
                    j++;
                }
                moves+=Math.abs(i-j);
                seat[i]--;
                student[j]--;
                total--;
            }
            return moves;
        }
    }
}
