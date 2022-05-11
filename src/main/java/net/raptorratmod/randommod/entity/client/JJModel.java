package net.raptorratmod.randommod.entity.client;
import net.raptorratmod.randommod.RandomMod;
import net.minecraft.util.Identifier;
import net.raptorratmod.randommod.entity.custom.JJEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class JJModel extends AnimatedGeoModel<JJEntity> {
    @Override
    public Identifier getModelLocation(JJEntity object) {
        return new Identifier(RandomMod.MOD_ID,"geo/jj.geo.json");
    }

    @Override
    public Identifier getTextureLocation(JJEntity object) {
        return new Identifier(RandomMod.MOD_ID,"textures/entity/jj/jjtexture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(JJEntity animatable) {
        return new Identifier(RandomMod.MOD_ID,"animations/jj.animation.json");
    }
    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public void setLivingAnimations(JJEntity entity, Integer uniqueID, AnimationEvent customPredicate){
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null){
            head.setRotationX(extraData.headPitch*((float)Math.PI/180));
            head.setRotationY(extraData.netHeadYaw*((float)Math.PI/180));
        }
    }
}
