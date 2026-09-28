package com.example.examplemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RubySwordItem extends SwordItem {
    public RubySwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 击中目标后点燃 5 秒，并施加虚弱效果
        target.setSecondsOnFire(5);
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
        return super.hurtEnemy(stack, target, attacker);
    }
}
