package org.example.DSA.Array;

import org.example.Cheatsheets.Solver.ForEachSolver;
import org.example.Cheatsheets.Solver.TwoIndices.OppositeEndsSolver;
import org.example.Cheatsheets.Solver.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Solver.Window.SlidingWindowSolver;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveLeft;
import static org.example.Cheatsheets.Solver.TwoIndices.PointerDecision.moveRight;
import static org.example.DS.Array.Mutable.fromIntArray;
import static org.example.DSA.Util.oddParity;
import static org.example.DSA.Util.placesMinus1;

@BenchmarkMode(Mode.AverageTime)             // Measure average execution time
@OutputTimeUnit(TimeUnit.MICROSECONDS)       // Report in microseconds
@State(Scope.Thread)                         // New instance per thread
public class Intro {

    // Note: making the method static and warming it up increases run speed
    static {
        for (int i = 0; i < 500; i++) {
            findMaxConsecutiveOnes(new int[]{});
        }
    }

    // Note: looping without window in this case is faster
    public static int findMaxConsecutiveOnes(int[] nums) {
        var test = new ForEachSolver<Integer>() {
            public int ans = 0;
            public int count = 0;

            @Override
            public void consume(Integer val) {
                if (val == 1) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
        };

        test.solve(fromIntArray(nums));
        test.ans = Math.max(test.ans, test.count);
        // NOTE: it is best to return a raw value for reg speed
        return test.ans;
    }

    public int findNumbers(int[] nums) {
        var test = new ForEachSolver<Integer>() {
            int total = 0;

            @Override
            public void consume(Integer val) {
                // Note: parity is much faster than if
                total += oddParity(placesMinus1(val));
            }
        };

        test.solve(fromIntArray(nums));
        return test.total;
    }

    private int[] input;

    @Setup(Level.Invocation)  // run before every invocation
    public void setup() {
        input = new int[10_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i - 5000;  // mix of negative and positive
        }
    }

    @Benchmark
    public int[] benchmarkSortedSquares() {
        return sortedSquares(input);
    }

    public int[] sortedSquares(int[] nums) {
        var ans = new int[nums.length];

        var test = new OppositeEndsSolver<Integer>() {
            int i = nums.length;

            @Override
            protected PointerDecision<?> doLogic(Integer leftVal, Integer rightVal, int LeftIndex, int rightIndex) {
                i--;
                if (Math.abs(leftVal) > Math.abs(rightVal)) {
                    ans[i] = leftVal * leftVal;
                    return moveLeft(null);
                } else {
                    ans[i] = rightVal * rightVal;
                    return moveRight(null);
                }
            }
        };

        test.solve(fromIntArray(nums));
        ans[0] = nums[test.left] * nums[test.left];
        Arrays.stream(ans).forEachOrdered(System.out::println);
        return ans;
    }
}
