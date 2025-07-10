package org.example.DP.Architectural.ECS;

import org.example.DP.Architectural.ECS.Components.ComponentMask;

import static org.example.DP.Architectural.ECS.Systems.SystemManager.RenderSystem;
import static org.example.DP.Architectural.ECS.Systems.SystemManager.VelocitySystem;

// TODO: needs clean up.
public class GameContainer {
    public static void main(String[] args) {
        new GameContainer();
    }

    EntityManager manager;

    GameContainer() {
        manager = new EntityManager(5);

        int id = manager.createEntity(ComponentMask.POS | ComponentMask.VEL | ComponentMask.RENDER);
        if (id > -1) {
            manager.pos[id].x = 10;
            manager.pos[id].y = 10;
            manager.vel[id].velx = 1;
            manager.vel[id].vely = 1;
            manager.rendering[id].name = "player";
        }

        id = manager.createEntity(ComponentMask.POS | ComponentMask.RENDER);
        if (id > -1) {
            manager.pos[id].x = 0;
            manager.pos[id].y = 0;
            manager.rendering[id].name = "tree";
        }

        startGameLoop();
    }

    void startGameLoop() {
        while (true) {
            VelocitySystem.update(manager);
            RenderSystem.update(manager);
//            System.out.println("player pos: ("+manager.pos[0].x+", "+manager.pos[0].y+")");
        }
    }
}
