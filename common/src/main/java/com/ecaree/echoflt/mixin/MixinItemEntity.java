//package com.ecaree.echoflt.mixin;
//
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.MutableComponent;
//import net.minecraft.network.chat.TextComponent;
//import net.minecraft.world.entity.item.ItemEntity;
//import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(ItemEntity.class)
//public class MixinItemEntity {
//
//    @Inject(at = @At("HEAD"), method = "tick")
//    private void tick(CallbackInfo info) {
//        ItemEntity item = (ItemEntity) (Object) this;
//        ItemStack stack = item.getItem();
//        ChatFormatting color = stack.getRarity().color;
//        int count = stack.getCount();
//        int lifespan = 6000;
//        float age = (float) (lifespan - item.getAge()) / 20;
//        String ageStr = String.format("%.1f", age); // 防鬼畜
//
//        MutableComponent itemCount = new TextComponent(count + "x").withStyle(ChatFormatting.GOLD);
//        MutableComponent itemName = new TextComponent(stack.getDisplayName().getString()).withStyle(color);
//        MutableComponent despawnTime = age == -32768
//                ? new TextComponent("∞").withStyle(ChatFormatting.GOLD)
//                : new TextComponent("(" + ageStr + "s left" + ")").withStyle(ChatFormatting.GRAY);
//        item.setCustomName(itemCount.append(" ").append(itemName).append(" ").append(despawnTime));
//        item.setCustomNameVisible(true);
//    }
//}
// 物品如果被合并就成史了