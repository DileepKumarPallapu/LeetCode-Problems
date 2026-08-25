import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            // Collision can happen only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (alive && asteroid < 0 &&
                   !stack.isEmpty() && stack.peek() > 0) {

                int top = stack.peek();

                if (top < -asteroid) {
                    // Top asteroid is smaller → destroyed
                    stack.pop();
                }
                else if (top == -asteroid) {
                    // Same size → both destroyed
                    stack.pop();
                    alive = false;
                }
                else {
                    // Current asteroid is smaller → destroyed
                    alive = false;
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}