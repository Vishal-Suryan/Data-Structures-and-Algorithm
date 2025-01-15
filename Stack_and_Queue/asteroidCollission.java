import java.util.Stack;

public class asteroidCollission {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) {
                    st.push(asteroids[i]);
                }else{
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                        st.pop();
                    }
                    if (st.isEmpty() || st.peek() < 0) {
                        st.push(asteroids[i]);
                    }else if(st.peek() == Math.abs(asteroids[i])) {
                        st.pop();
                    }
                }
            }
            int[] result = new int[st.size()];
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = st.pop();
            }
            return result;
        }
    }
}
