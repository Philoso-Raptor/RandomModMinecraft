package net.raptorratmod.randommod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.raptorratmod.randommod.RandomMod;

public class ModEffects {
    public static StatusEffect BLEED;
    public static StatusEffect INFECTED;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(RandomMod.MOD_ID, name),
                new BleedEffect(StatusEffectCategory.HARMFUL, 11141120));
    }

    public static StatusEffect registerStatusEffects(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(RandomMod.MOD_ID, name),
                new InfectedEffect(StatusEffectCategory.HARMFUL, 5635925));
    }


    public static void registerEffects(){
        BLEED = registerStatusEffect("bleed");
        INFECTED = registerStatusEffects("infected");
    }






}
