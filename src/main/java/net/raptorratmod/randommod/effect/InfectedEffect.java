package net.raptorratmod.randommod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class InfectedEffect extends StatusEffect {

    public InfectedEffect(StatusEffectCategory statusEffectCategory, int color){
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier){
        if(!pLivingEntity.world.isClient()){
            if(pLivingEntity.getHealth() >= 0.0f) {
                ((PlayerEntity) pLivingEntity).addExhaustion(0.5f * (float) (pAmplifier + 1));

            }

        }

    }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        if(this == ModEffects.INFECTED){
            int i = 25 >> pAmplifier;
            if(i > 0){
                pDuration = pDuration * 10;
                return pDuration % i == 0;
            }
        }

        return true;
    }



}
