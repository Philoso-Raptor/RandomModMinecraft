package net.raptorratmod.randommod.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.RandomMod;
import net.raptorratmod.randommod.entity.ModEntities;

public class ModItems {

    public static final Item OSMANTIUM_INGOT = registerItem("osmantium_ingot"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    public static final Item OSMANTIUM_NUGGET = registerItem("osmantium_nugget"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    public static final Item OSMANTIUM_DUST = registerItem("osmantium_dust"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    public static final Item JJ_PIZZA = registerItem("jj_pizza"
            ,new Item(new FabricItemSettings().food(ModFoodComponents.JJ_PIZZA).group(ItemGroup.FOOD)));

    public static final Item JJ_SPAWN_EGG = registerItem("jj_spawn_egg"
            ,new SpawnEggItem(ModEntities.JJ,0x948e8d, 0x3b3635,
                    new FabricItemSettings().group(ItemGroup.MISC).maxCount(1)));

    public static final Item OSMANTIUM_SWORD = registerItem("osmantium_sword"
            ,new SwordItem(ModToolMaterials.OSMANTIUM, 1, 2f, new FabricItemSettings
                    ().fireproof().maxCount(1)));

    public static final Item DENSE_OSMANTIUM = registerItem("dense_osmantium"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    public static final Item RADIANT_OSMANTIUM = registerItem("radiant_osmantium"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    //public static final Item RADIANT_OSMANTIUM_SWORD = registerItem("radiant_osmantium_sword"
            //,new SwordItem(ModToolMaterials.RADIANT_OSMANTIUM, 2, 2f, new FabricItemSettings
                    //().fireproof().maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        RandomMod.LOGGER.info("Registering Mod Items for " + RandomMod.MOD_ID);

    }
}
