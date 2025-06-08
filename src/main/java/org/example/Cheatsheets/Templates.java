package org.example.Cheatsheets;

import org.example.DS.List.Indexable.Indexable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/*
 * Cheatsheets.Templates are used for copy-and-paste equivalent of Cheatsheets.Functions.
 * There is speed benefits to using non-functional in Java
 * as Java uses classes for lambdas which adds overhead.
 */
public abstract class Templates {

    // TODO: use generic types

    abstract boolean condition();
    /*
     * Traverse an array from opposite sides, moving left on condition, else right.
     */
    public int oppositeEnds(Indexable<?> arr) {
        int left = 0, right = arr.size() - 1, ans = 0;

        while (left < right) {
            // TODO: add ans function; and short-circuit
            if(condition()) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    /*
     * Traverse both arrays, moving along arr1 on condition, else along arr2.
     * Complete traversal after either array is complete.
     */
    public int ExhaustBoth(int[] arr1, int[] arr2) {
        int i = 0, j = 0, ans = 0;

        while (i < arr1.length && j < arr2.length) {
            if(condition()) {
                i++;
                // TODO: add ans function, i inc
            } else {
                j++;
                // TODO: add ans function, j inc
            }
        }

        while (i < arr1.length) {
            i++;
            // TODO: add ans function, i inc - post compare
        }

        while (j < arr2.length) {
            j++;
            // TODO: add ans function, j inc - post compare
        }

        return ans;
    }

    abstract boolean windowConditionBroken();
    /*
     * Slide window across array, left to right, dropping left-most on break condition.
     */
    public int slidingWindow(int[] arr) {
        int left = 0, ans = 0, curr = 0;

        for (int right = 0; right < arr.length; right++) {
            // TODO: update curr function

            while (windowConditionBroken()) {
                // TODO: remove arr[left] from window function
                left++;
            }

            // TODO: update ans function; ans <= curr?
        }

        return ans;
    }

    /*
     * Traverse array creating a cumulative array based on array given.
     */
    public int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0]; // TODO: size issue if arr is less than 1

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i]; // TODO: change; current is running sum
        }

        return prefix;
    }

    /*
     * Fastest way to copy string.
     */
    public String efficientString(char[] arr) {
        StringBuilder sb = new StringBuilder();

        for (char c: arr) {
            sb.append(c);
        }

        return sb.toString();
    }

    static class ListNode {
        ListNode next;
    }
    /*
     * Traverse Linked List with a fast pointer.
     */
    public int fastPointer(ListNode head) {
        ListNode slow = head, fast = head;
        int ans = 0;

        while (fast != null && fast.next != null) {
            // TODO: add node function
            slow = slow.next;
            fast = fast.next.next; // TODO: change how fast is selected; curr is every other
        }

        return ans;
    }

    /*
     * Reverse Link List.
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public int fnUnknown(int[] arr, int k) { // TODO: somehow gets subarrays tht fit criteria???
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int ans = 0, curr = 0;

        for (int num: arr) {
            // TODO: curr changing function
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1); // counts[curr]++
        }

        return ans;
    }

//    public static int fn(int[] arr) { // mono queue
//
//    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
    /*
     * Binary Tree DFS - recursive
     */
    public int dfs(TreeNode root) { // TODO: make n-ary DFS
        if (root == null) {
            return 0;
        }

        int ans = 0;
        // TODO: add node function
        dfs(root.left);
        dfs(root.right);
        return ans;
    }

    /*
     * Binary Tree DFS - iterative
     */
    public int dfs2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            // TODO: add node function
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return ans;
    }

    // TODO: add other DFS and BFS

    /*
     * Find top k elements based on criteria.
     */
    public int[] findTop(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // TODO: ASAP CRITERIA?
        for (int num: arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }

        return  ans;
    }

    public int fn(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // TODO: add hit function
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // if it misses, this is the insertion index; may need to change.
        return left;
    }


}
