import java.util.Arrays;

public class minTimeRepaircars_2594 {
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            long left = 1;
            long right = (long) Arrays.stream(ranks).max().getAsInt() * (long) cars * cars;
            while(left < right){
                long mid = left + (right - left) / 2;
                if(canRepair(ranks, cars, mid)){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
        private boolean canRepair(int[] ranks, int cars, long time){
            long carsRepaired = 0;
            for(int rank : ranks){
                carsRepaired += Math.sqrt(time / rank);
                if(carsRepaired >= cars){
                    return true;
                }
            }
            return false;
        }
    }
}
