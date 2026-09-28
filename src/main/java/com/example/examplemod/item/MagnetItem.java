package com.example.examplemod.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MagnetItem extends Item {
    public MagnetItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide() && entity instanceof Player player) {
            // 吸取 8 格半径范围内的掉落物
            AABB area = player.getBoundingBox().inflate(8.0D);
            List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, area);
            for (ItemEntity item : items) {
                if (item.isAlive() && !item.hasPickUpDelay()) {
                    Vec3 motion = player.position().add(0, 0.5, 0).subtract(item.position()).normalize().scale(0.35);
                    item.setDeltaMovement(motion);
                }
            }
        }
    }
}
