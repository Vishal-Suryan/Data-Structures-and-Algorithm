import java.util.*;
public class teamTraining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            result.append(findMaxTeams(arr, x)).append("\n");
        }
        System.out.print(result);
        sc.close();
    }

    private static int findMaxTeams(Integer[] arr, int minStrength) {
        Arrays.sort(arr, Collections.reverseOrder());
        int count = 0, teamSize = 0;
        for (int skill : arr) {
            teamSize++; 
            if (skill * teamSize >= minStrength) { 
                count++; 
                teamSize = 0; 
            }
        }
        return count;
    }
}
