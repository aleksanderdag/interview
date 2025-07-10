package org.example.DP.Architectural.ECS.Systems;

import org.example.DP.Architectural.ECS.Components.ComponentMask;
import org.example.DP.Architectural.ECS.EntityManager;

@FunctionalInterface
public interface ISystem {
    void update(EntityManager manager);
}
