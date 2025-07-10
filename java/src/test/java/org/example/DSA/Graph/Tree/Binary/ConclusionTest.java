package org.example.DSA.Graph.Tree.Binary;

import org.example.DS.Graph.Tree.TreeNode;
import org.example.DSA.Graph.Tree.Binary.Conclusion;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.DS.Graph.Tree.TreeNode.fromArray;
import static org.junit.jupiter.api.Assertions.*;

class ConclusionTest {
    final Conclusion OBJ = new Conclusion();

    public static Stream<Arguments> buildTree() {
        return Stream.of(
                Arguments.of(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}, fromArray(new Integer[]{3,9,20,null,null,15,7})),
                Arguments.of(new int[]{-1}, new int[]{-1}, fromArray(new Integer[]{-1}))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource
    void buildTree(int[] inorder, int[] postorder, TreeNode expected) {
        assertEquals(expected, OBJ.buildTree(inorder, postorder));
    }
}