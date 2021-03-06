package net.raptorratmod.randommod.effect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class BleedEffect extends StatusEffect {
   public BleedEffect(StatusEffectCategory statusEffectCategory, int color){
        super(statusEffectCategory, color);
    }


    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier){
        if(!pLivingEntity.world.isClient()){
           if(pLivingEntity.getHealth() >= 0.5f){

               pLivingEntity.damage(DamageSource.GENERIC, 1.15f);

           }else if(pLivingEntity.getHealth() <= 7.5f){
               ((PlayerEntity)pLivingEntity).addExhaustion(0.5f * (float)(pAmplifier + 1));
           }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier){
        if(this == ModEffects.BLEED){
            int i = 25 >> pAmplifier;
            if(i > 0){
                return pDuration % i == 0;
            }
        }

        return true;
    }


}
