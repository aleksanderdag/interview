package org.example.DP.Architectural.ECS;

import org.example.DP.Architectural.ECS.Components.ComponentMask;
import org.example.DP.Architectural.ECS.Components.Position;
import org.example.DP.Architectural.ECS.Components.Rendering;
import org.example.DP.Architectural.ECS.Components.Velocity;

public class EntityManager {
    public final int size;
    public int[] flag;
    public Position[] pos;
    public Velocity[] vel;
    public Rendering[] rendering;

    public EntityManager(int size) {
        this.size = size;
        flag = new int[size];
        pos = new Position[size];
        vel = new Velocity[size];
        rendering = new Rendering[size];
    }

    public int createEntity(int flag) {
        for (int i = 0; i < size; i++) { // TODO: use better loop; manage index
            if (this.flag[i] == 0) {
                this.flag[i] = flag;
                if ((flag & ComponentMask.POS) > 0) pos[i] = new Position();
                if ((flag & ComponentMask.VEL) > 0) vel[i] = new Velocity();
                if ((flag & ComponentMask.RENDER) > 0) rendering[i] = new Rendering();
                return i;
            }
        }
        return -1;
    }
}
