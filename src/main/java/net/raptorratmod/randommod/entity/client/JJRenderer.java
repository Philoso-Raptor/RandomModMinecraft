package net.raptorratmod.randommod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.raptorratmod.randommod.RandomMod;
import net.raptorratmod.randommod.entity.custom.JJEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class JJRenderer extends GeoEntityRenderer<JJEntity> {
    public JJRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new JJModel());
    }

    @Override
    public Identifier getTextureLocation(JJEntity instance){
        return new Identifier(RandomMod.MOD_ID,"textures/entity/jj/JJ_Texture.png");
    }

}
