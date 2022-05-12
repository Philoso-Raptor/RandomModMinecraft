package net.raptorratmod.randommod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.ServerWorldAccess;
import net.raptorratmod.randommod.RandomMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.entity.custom.JJEntity;



public class ModEntities {
    public static final EntityType<JJEntity> JJ = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(RandomMod.MOD_ID, "jj"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JJEntity::new)
                    .dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());
    }

