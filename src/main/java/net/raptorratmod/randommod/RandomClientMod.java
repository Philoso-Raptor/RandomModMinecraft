package net.raptorratmod.randommod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.raptorratmod.randommod.block.ModBlocks;
import net.raptorratmod.randommod.entity.ModEntities;
import net.raptorratmod.randommod.entity.client.JJRenderer;


public class RandomClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.JJ, JJRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_SPLINTER, RenderLayer.getCutout());

    }
}
