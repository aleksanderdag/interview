package org.example.Cheatsheets.Functions;

public abstract class SlidingWindow {
    public abstract void addRight(int rightIndex);
    public abstract void removeLeft(int leftIndex);
    public abstract boolean windowConditionBroken(int leftIndex, int rightIndex);
    public abstract void validWindow(int leftIndex, int rightIndex);

    /*
     * Slide window across array, left to right, dropping left-most on break condition.
     */
    public int run(int arrLen) {
        int left = 0, ans = 0, curr = 0;

        for (int right = 0; right < arrLen; right++) {
            // TODO: update curr function
            addRight(right);

            while (windowConditionBroken(left, right)) {
                // TODO: remove arr[left] from window function
                removeLeft(left);
                left++;
            }

            // TODO: update ans function; ans <= curr?
            validWindow(left, right);
        }

        return left;
    }
}
