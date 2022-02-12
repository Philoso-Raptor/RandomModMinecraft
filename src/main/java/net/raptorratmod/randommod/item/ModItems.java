package net.raptorratmod.randommod.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.RandomMod;

public class ModItems {

    public static final Item OSMANTIUM_INGOT = registerItem("osmantium_ingot"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));

    public static final Item OSMANTIUM_NUGGET = registerItem("osmantium_nugget"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));


    public static final Item OSMANTIUM_DUST = registerItem("osmantium_dust"
            ,new Item(new FabricItemSettings().fireproof().group(ItemGroup.MISC)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        RandomMod.LOGGER.info("Registering Mod Items for " + RandomMod.MOD_ID);

    }
}
