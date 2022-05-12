package net.raptorratmod.randommod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class JJEntity extends AnimalEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);


    public JJEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,20.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,2.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.5f);
    }

    protected void initGoals(){
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 0.2f));
        this.goalSelector.add(2,new WanderAroundPointOfInterestGoal(this,0.4f,false));
        this.goalSelector.add(3,new WanderAroundFarGoal(this,0.4f,2));
        this.goalSelector.add(4,new LookAroundGoal(this));
        this.goalSelector.add(5,new LookAtEntityGoal(this, PlayerEntity.class,8.0f));
        this.goalSelector.add(6, new AttackGoal(this));
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if (event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder()
                    .addAnimation("Walking", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("Idle",true));
    return PlayState.CONTINUE;
    }


   @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected SoundEvent getAmbientSound(){return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_CAT_HISS;}

    @Override
    protected SoundEvent getDeathSound(){return SoundEvents.ENTITY_GOAT_SCREAMING_DEATH;}
}
