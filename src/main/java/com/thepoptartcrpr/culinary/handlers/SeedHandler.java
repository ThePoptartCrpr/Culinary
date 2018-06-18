package com.thepoptartcrpr.culinary.handlers;

import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedHandler {

    public static void registerSeeds() {
        MinecraftForge.addGrassSeed(new ItemStack(CItems.cornSeeds), 10);
    }

}
