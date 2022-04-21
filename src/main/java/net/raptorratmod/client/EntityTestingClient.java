package net.raptorratmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.raptorratmod.randommod.entity.EntityTesting;
import net.raptorratmod.randommod.entity.JJEntityRenderer;

@Environment(EnvType.CLIENT)
public class EntityTestingClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_JJ_LAYER = new EntityModelLayer(new Identifier(
            "entitytesting", "jj"), "main");



    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EntityTesting.JJ, (context) -> {
            return new JJEntityRenderer(context);
        });



        EntityModelLayerRegistry.registerModelLayer(MODEL_JJ_LAYER, JJEntityModel::getTexturedModelData);

    }

}
