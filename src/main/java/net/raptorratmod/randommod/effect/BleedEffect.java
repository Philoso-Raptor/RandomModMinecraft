package net.raptorratmod.randommod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedEffect extends StatusEffect {
    public BleedEffect(StatusEffectCategory statusEffectCategory, int color){
        super(statusEffectCategory, color);
    }


    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier){
        if(!pLivingEntity.world.isClient()){
           if(pLivingEntity.getHealth() >= 1.0f){
               pLivingEntity.damage(DamageSource.GENERIC,1.0f);
           }
        }



        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }






    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        return true;
    }


}
