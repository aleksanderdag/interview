package org.example.Cheatsheets;

import java.util.function.BiPredicate;

/*
 * Functions is a programmer friendly way to plug and play solutions to problems.
 * The intention is to quickly find a working solution,
 * and then the user will use the Templates equivalent for performance boosts.
 */
public class FunctionsOld {

    /*
     * Traverse an array from opposite sides, moving left on condition, else right.
     */
    public static <T, R> R oppositeEnds(T[] arr, R init, TriFunction<R, T, T, R> fn, BiPredicate<T, T> condition) {
        BiRelation<Integer, Integer, Integer> rel = (left, right) -> {
            if(condition.test(arr[left], arr[right])) {
                return new Integer[]{left+1, right};
            } else {
                return new Integer[]{left, right-1};
            }
        };
        return generalEnds(arr, init, fn, rel);
    }

    /*
     * Traverse an array inward from ends symmetrically.
     */
    public static <T, R> R symmetricEnds(T[] arr, R init, TriFunction<R, T, T, R> fn) {
        BiRelation<Integer, Integer, Integer> rel = (left, right) -> new Integer[]{left+1, right+1};
        return generalEnds(arr, init, fn, rel);
    }

    /*
     * Traverse an array based on selector.
     */
    public static <T, R> R generalEnds(T[] arr, R init, TriFunction<R, T, T, R> fn,
                                       BiRelation<Integer, Integer, Integer> selector) {
        int left = 0, right = arr.length - 1;
        R ans = init;

        while (left < right) {
            T leftItem = arr[left];
            T rightItem = arr[right];
            ans = fn.apply(ans, leftItem, rightItem);
            // TODO: add short-curcit

            // choose next pointers
            Integer[] selections = selector.apply(left, right);
            left = selections[0];
            right = selections[1];
        }

        return ans;
    }
}
