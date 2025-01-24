public class theCelebrity {
    class Solution {
        // Function to find if there is a celebrity in the party or not.
        public int celebrity(int mat[][]) {
            int n = mat.length;
            int candidate = 0;
            for (int i = 1; i < n; i++) {
                if (mat[candidate][i] == 1) {
                    candidate = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                    return -1;
                }
            }
    
            return candidate;
        }
    }
    class Solution1 {
        // Function to find if there is a celebrity in the party or not.
        public int celebrity(int mat[][]) {
            int top = 0;
            int down = mat.length - 1;
    
            // Narrow down to a potential candidate
            while (top < down) {
                if (mat[top][down] == 1) {
                    top++;
                } else {
                    down--;
                }
            }
    
            // Verify the candidate
            for (int i = 0; i < mat.length; i++) {
                if (i == top) continue;
    
                // If the candidate knows someone, or not everyone knows the candidate
                if (mat[top][i] == 1 || mat[i][top] == 0) {
                    return -1;
                }
            }
    
            return top;
        }
    }
}
