package com.example.examplemod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireStaffItem extends Item {
    public FireStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            Vec3 look = player.getLookAngle();
            SmallFireball fireball = new SmallFireball(level, player, look.x, look.y, look.z);
            fireball.setPos(player.getX() + look.x * 1.5, player.getEyeY() + look.y * 1.5, player.getZ() + look.z * 1.5);
            level.addFreshEntity(fireball);

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            player.getCooldowns().addCooldown(this, 20); // 1秒冷却
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
