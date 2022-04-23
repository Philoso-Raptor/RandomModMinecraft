package net.raptorratmod.randommod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import java.util.Random;

public class JJEntity extends PathAwareEntity {

    public JJEntity(EntityType<? extends JJEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);

        this.experiencePoints = 5;
    }

    public static DefaultAttributeContainer.Builder createJJAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.22D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily()) {
            this.updateVelocity(0.1F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        }
    }

    public static boolean canSpawn(EntityType<JJEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (pos.getY() >= 63) {
            return world.toServerWorld().isNight() && world.getMoonSize() == 1.0F;
        } else {
            int worldLight = world.getLightLevel(pos);
            int maximumLight = 4;


            return worldLight <= random.nextInt(maximumLight) && canMobSpawn(type, world, spawnReason, pos, random);
        }
    }



}
