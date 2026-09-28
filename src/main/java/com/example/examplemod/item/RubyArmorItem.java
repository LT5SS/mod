package com.example.examplemod.item;

import com.example.examplemod.init.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RubyArmorItem extends ArmorItem {
    public RubyArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide()) {
            if (hasFullRubyArmorSet(player)) {
                // 全套红宝石套装效果：抗性提升、防火、力量 I
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, false, false, true));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, false, false, true));
            }
        }
    }

    private boolean hasFullRubyArmorSet(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty()
                && helmet.getItem() instanceof ArmorItem h && h.getMaterial() == ModArmorMaterials.RUBY
                && breastplate.getItem() instanceof ArmorItem b && b.getMaterial() == ModArmorMaterials.RUBY
                && leggings.getItem() instanceof ArmorItem l && l.getMaterial() == ModArmorMaterials.RUBY
                && boots.getItem() instanceof ArmorItem bt && bt.getMaterial() == ModArmorMaterials.RUBY;
    }
}
