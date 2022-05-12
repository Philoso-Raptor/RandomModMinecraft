package net.raptorratmod.randommod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.raptorratmod.randommod.RandomMod;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<DarkSplinterBlockEntity> DARK_SPLINTER;

    public static void registerAllBlockEntities(){
        DARK_SPLINTER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier
                (RandomMod.MOD_ID, "dark_splinter"),
                FabricBlockEntityTypeBuilder.create(DarkSplinterBlockEntity::new,
                        ModBlocks.DARK_SPLINTER).build(null));
    }



}
