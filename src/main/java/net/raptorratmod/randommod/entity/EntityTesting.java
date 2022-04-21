package net.raptorratmod.randommod.entity;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityTesting implements ModInitializer {

    public static final EntityType<JJEntity> JJ = Registry.register(
            Registry.ENTITY_TYPE, new Identifier("entitytesting", "jj"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JJEntity::new).dimensions(
                    EntityDimensions.fixed(1.0f,2.0f)).build());


    @Override
    public void onInitialize(){


        FabricDefaultAttributeRegistry.register(JJ, JJEntity.createMobAttributes());

}
}
