package net.raptorratmod.client;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.raptorratmod.randommod.entity.JJEntity;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import static net.raptorratmod.client.EntityTestingClient.MODEL_JJ_LAYER;

public class JJEntityModel extends EntityModel<JJEntity> {
    private final ModelPart base;

    public JJEntityModel(ModelPart modelPart) {
        this.base = modelPart.getChild(EntityModelPartNames.CUBE);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.CUBE,
                ModelPartBuilder.create().uv(0, 0).cuboid
                        (-6F, -6F, -6F, 16F, 16F, 16F), ModelTransform.pivot
                        (0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(JJEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices,
                       VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_JJ_LAYER, JJEntityModel::getTexturedModelData);
    }
}
