package org.example.DSA.Graph.Tree.Binary;

import org.example.DS.Graph.Tree.TreeNode;
import org.example.DSA.Graph.Tree.Binary.Recurse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.DS.Graph.Tree.TreeNode.fromArray;
import static org.junit.jupiter.api.Assertions.*;

class RecurseTest {
    final Recurse OBJ = new Recurse();

    public static Stream<Arguments> maxDepth() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{3,9,20,null,null,15,7}), 3),
                Arguments.of(fromArray(new Integer[]{1,null,2}), 2),
                Arguments.of(fromArray(new Integer[]{}), 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void maxDepth(TreeNode root, int expected) {
        assertEquals(OBJ.maxDepth(root), expected);
    }

    public static Stream<Arguments> isSymmetric() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{1,2,2,3,4,4,3}), true),
                Arguments.of(fromArray(new Integer[]{1,2,2,null,3,null,3}), false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isSymmetric(TreeNode root, boolean expected) {
        assertEquals(expected, OBJ.isSymmetric(root));
    }

    public static Stream<Arguments> hasPathSum() {
        return Stream.of(
                Arguments.of(fromArray(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22, true),
                Arguments.of(fromArray(new Integer[]{1,2,3}), 5, false),
                Arguments.of(fromArray(new Integer[]{}), 0, false),
                Arguments.of(fromArray(new Integer[]{1,2}), 1, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void hasPathSum(TreeNode root, int targetSum, boolean expected) {
        assertEquals(expected, OBJ.hasPathSum(root, targetSum));
    }
}