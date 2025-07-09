package org.example.DSA;

public class DS {
    int pick = 1;
    int guess(int num) {
        if (num > pick) return -1;
        else if (num < pick) return 1;
        return 0;
    }
    public int guessNumber(int n) {
        return 0;
    }
}
