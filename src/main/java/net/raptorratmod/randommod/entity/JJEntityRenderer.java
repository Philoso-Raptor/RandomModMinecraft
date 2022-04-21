package net.raptorratmod.randommod.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.raptorratmod.client.EntityTestingClient;
import net.raptorratmod.client.JJEntityModel;

public class JJEntityRenderer extends MobEntityRenderer<JJEntity, JJEntityModel> {

    public JJEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new JJEntityModel(context.getPart(EntityTestingClient.MODEL_JJ_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(JJEntity entity) {
        return new Identifier("entitytesting", "textures/entity/jj.png");
    }


}
