package net.raptorratmod.randommod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.raptorratmod.randommod.entity.ModEntities;
import net.raptorratmod.randommod.entity.custom.JJEntity;
import net.raptorratmod.randommod.entity.custom.WWEntity;

public class ModRegistries {
    public static void registerModStuffs(){

        registerAttributes();
    }
    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.JJ, JJEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.WEREWOLF, WWEntity.setAttributes());
    }



}
