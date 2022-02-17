package net.raptorratmod.randommod.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.raptorratmod.randommod.RandomMod;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.item.ModItems;
public class ModBlocks {

    public static final Block OSMANTIUM_ORE = registerBlock("osmantium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ItemGroup.MISC);

    //public static final Block OSMANTIUM_BLOCK = registerBlock("osmantium_block",
    //        new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ItemGroup.MISC);


    public static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(RandomMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group ){
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlock(){
        RandomMod.LOGGER.info("Registering ModBlocks for " + RandomMod.MOD_ID);
    }





}
