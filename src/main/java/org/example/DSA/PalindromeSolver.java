package org.example.DSA;

import org.example.Cheatsheets.Functions.TwoIndices.PointerDecision;
import org.example.Cheatsheets.Functions.TwoIndices.TwoPointerSolver;

import static org.example.Cheatsheets.Functions.TwoIndices.PointerDecision.ret;
import static org.example.Cheatsheets.Functions.TwoIndices.PointerDecision.symmetricMove;

public class PalindromeSolver extends TwoPointerSolver<Character, Boolean> {
    @Override
    protected Boolean initialAns() {
        return true;
    }

    @Override
    protected PointerDecision<Boolean> doLogic(Character leftVal, Character rightVal, int LeftIndex, int rightIndex, Boolean currentAns) {
        if(leftVal.equals(rightVal)) {
            return symmetricMove(currentAns);
        } else {
            return ret(false);
        }
    }
}
