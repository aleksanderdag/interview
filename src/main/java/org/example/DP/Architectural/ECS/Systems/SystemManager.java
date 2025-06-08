package org.example.DP.Architectural.ECS.Systems;

import org.example.DP.Architectural.ECS.Components.ComponentMask;

public class SystemManager {
    public static final ISystem VelocitySystem = (manager) -> {
        int req_mask = ComponentMask.POS | ComponentMask.VEL;
        for (int i = 0; i < manager.size; i++) {
            if ((manager.flag[i] & req_mask) == req_mask) {
                manager.pos[i].x += manager.vel[i].velx;
                manager.pos[i].y += manager.vel[i].vely;
            }
        }
    };

    public static final ISystem RenderSystem = (manager) -> {
        int req_mask = ComponentMask.POS | ComponentMask.RENDER; // TODO:
        for (int i = 0; i < manager.size; i++) {
            if ((manager.flag[i] & req_mask) == req_mask) {
                System.out.printf("%s: (%f x, %f y)%n", manager.rendering[i].name, manager.pos[i].y, manager.pos[i].y);
            }
        }
    };
}
