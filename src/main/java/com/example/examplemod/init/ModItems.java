package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    // 1. 原材料
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    // 2. 特殊食物 (附魔红宝石苹果)
    public static final RegistryObject<Item> ENCHANTED_RUBY_APPLE = ITEMS.register("enchanted_ruby_apple",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).food(
                    new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationMod(1.2F)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F)
                            .build()
            )));

    // 3. 武器与工具
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new RubySwordItem(ModToolTiers.RUBY, 4, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 2, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 6, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 2.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, -3, 0.0F, new Item.Properties()));

    // 4. 防具 (包含套装被动效果)
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new RubyArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    // 5. 魔法与功能道具
    public static final RegistryObject<Item> FIRE_STAFF = ITEMS.register("fire_staff",
            () -> new FireStaffItem(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> LIGHTNING_STAFF = ITEMS.register("lightning_staff",
            () -> new LightningStaffItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> ITEM_MAGNET = ITEMS.register("item_magnet",
            () -> new MagnetItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WARP_GEM = ITEMS.register("warp_gem",
            () -> new WarpGemItem(new Item.Properties().durability(64)));
}
