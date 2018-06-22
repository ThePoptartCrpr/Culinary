package com.thepoptartcrpr.culinary.handlers;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableHandler {

    // TODO: Eventually add bones to animals' loot tables instead of spawning them in the world on the drop event

    @SubscribeEvent
    public void lootTableLoad(LootTableLoadEvent event) {
        if (event.getName().getResourcePath().equals("gameplay/fishing/fish")) {
            LootTable table = event.getTable();
            LootPool pool = table.getPool("main");

            pool.addEntry(new LootEntryItem(CItems.fishTuna, 25, 0, new LootFunction[0], new LootCondition[0], Culinary.Reference.MODID + "loot_fish_tuna"));
        }
    }

}
