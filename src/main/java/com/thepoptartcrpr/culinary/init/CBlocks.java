package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.blocks.CBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// TODO: the name CBlocks (short for CulinaryBlocks) doesn't really fit, find better alternative but i cba rn

@Mod.EventBusSubscriber(modid = Culinary.MODID)
public class CBlocks {

    public static Block saltOre;

    public static void init() {
        // Ores
        saltOre = new CBlock("salt_ore", "salt_ore", Material.ROCK, 2, 2);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(saltOre);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(saltOre).setRegistryName(saltOre.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(saltOre));
    }

    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
