package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

    public static final RegistryObject<CreativeModeTab> RUBY_TAB = CREATIVE_MODE_TABS.register("ruby_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY_SWORD.get()))
                    .title(Component.translatable("creativetab.ruby_tab"))
                    .displayItems((params, output) -> {
                        // 基础与矿石
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());

                        // 食物与消耗品
                        output.accept(ModItems.ENCHANTED_RUBY_APPLE.get());

                        // 工具与武器
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());

                        // 护甲套装
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());

                        // 特殊魔法装备
                        output.accept(ModItems.FIRE_STAFF.get());
                        output.accept(ModItems.LIGHTNING_STAFF.get());
                        output.accept(ModItems.ITEM_MAGNET.get());
                        output.accept(ModItems.WARP_GEM.get());
                    })
                    .build());
}
