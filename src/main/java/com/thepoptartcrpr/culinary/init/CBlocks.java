package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.blocks.CBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

// TODO: the name CBlocks (short for CulinaryBlocks) doesn't really fit, find better alternative but i cba rn

public class CBlocks {
    public static Block saltOre;

    public CBlocks() {
        saltOre = new CBlock("salt_ore", "salt_ore", Material.ROCK, 2, 2);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                saltOre
        );
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                blockToItem(saltOre)
        );
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        registerRender(Item.getItemFromBlock(saltOre));
    }

    private Item blockToItem(Block block) {
        ResourceLocation saltOreLocation = Objects.requireNonNull(block.getRegistryName());
        return new ItemBlock(block).setRegistryName(saltOreLocation);
    }

    private void registerRender(Item item) {
        ResourceLocation itemLocation = Objects.requireNonNull(item.getRegistryName());
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(itemLocation, "inventory"));
    }
}
