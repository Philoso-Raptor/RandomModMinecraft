package net.raptorratmod.randommod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class JJEntity extends PathAwareEntity{
    public JJEntity(EntityType<? extends PathAwareEntity> entityType, World world){
        super(entityType, world);
    }
}
