class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int sum = 0;
        for(int i = 1; i <= weeks; i++){
            for(int j = i; j < i + 7; j++){
                sum += j;
            }
        }
        if(days != 0){
            int temp = weeks + 1;
            while(days > 0){
                sum += temp;
                temp++;
                days--;
            }
        }
        return sum;
    }
}