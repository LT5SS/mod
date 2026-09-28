package com.example.examplemod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class WarpGemItem extends Item {
    public WarpGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            Vec3 look = player.getLookAngle().scale(10.0D);
            double targetX = player.getX() + look.x;
            double targetY = player.getY() + look.y;
            double targetZ = player.getZ() + look.z;

            player.teleportTo(targetX, targetY, targetZ);
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
            stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            player.getCooldowns().addCooldown(this, 40); // 2秒冷却
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
