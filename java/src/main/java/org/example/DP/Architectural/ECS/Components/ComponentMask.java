package org.example.DP.Architectural.ECS.Components;

public class ComponentMask {
    // if more than 8 comps use short or int
    public final static byte POS = 1 << 0,
                                VEL = 1 << 1,
                                RENDER = 1 << 2; // TODO: use BitSet
}
