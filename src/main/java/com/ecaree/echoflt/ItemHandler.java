package com.ecaree.echoflt;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemHandler {

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.world.isClientSide()) {
            LocalPlayer player = Minecraft.getInstance().player;
            if (player == null) return;

            Vec3 playerPos = player.position();
            double radius = 20; // 大概是物品能够被渲染的最远距离
            AABB searchArea = new AABB(playerPos.x - radius, playerPos.y - radius, playerPos.z - radius,
                    playerPos.x + radius, playerPos.y + radius, playerPos.z + radius);
            List<ItemEntity> items = event.world.getEntitiesOfClass(ItemEntity.class, searchArea, e -> true);

            for (ItemEntity item : items) {
                Vec3 itemPos = item.position();

                if (searchArea.contains(itemPos)) {
                    ItemStack stack = item.getItem();
                    ChatFormatting color = stack.getRarity().color;
                    int count = stack.getCount();
                    int lifespan = item.lifespan;
                    float age = (float) (lifespan - item.getAge()) / 20;
                    String ageStr = String.format("%.1f", age); // 防鬼畜

                    MutableComponent itemCount = new TextComponent(count + "x").withStyle(ChatFormatting.GOLD);
                    MutableComponent itemName = new TextComponent(stack.getDisplayName().getString()).withStyle(color);
                    MutableComponent despawnTime = age == -32768
                            ? new TextComponent("∞").withStyle(ChatFormatting.GOLD)
                            : new TextComponent("(" + ageStr + "s left" + ")").withStyle(ChatFormatting.GRAY);
                    item.setCustomName(itemCount.append(" ").append(itemName).append(" ").append(despawnTime));
                    item.setCustomNameVisible(true);
                } else {
                    item.setCustomNameVisible(false);
                }
            }
        }
    }
}