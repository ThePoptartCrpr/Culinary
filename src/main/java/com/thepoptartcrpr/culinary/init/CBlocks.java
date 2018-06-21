package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.blocks.crops.CornCropBlock;
import com.thepoptartcrpr.culinary.blocks.machines.OvenBlock;
import com.thepoptartcrpr.culinary.blocks.machines.TableBlock;
import com.thepoptartcrpr.culinary.blocks.ores.SaltOreBlock;

import com.thepoptartcrpr.culinary.blocks.plants.bush.BushBlock;
import net.minecraft.block.Block;
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

    // Ores
    public static Block saltOre = new SaltOreBlock();

    // Crops
    public static Block cornCrop = new CornCropBlock();
    public static Block bush = new BushBlock();

    // Machines
    public static Block oven = new OvenBlock().setCreativeTab(Culinary.getInstance().getTabMachine());
    public static Block tableEmpty = new TableBlock().setCreativeTab(Culinary.getInstance().getTabMachine());

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                saltOre,
                cornCrop,
                bush,
                oven,
                tableEmpty
        );
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                blockToItem(saltOre),
                blockToItem(cornCrop),
                blockToItem(bush),
                blockToItem(oven),
                blockToItem(tableEmpty)
        );
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        registerRender(
                saltOre,
                cornCrop,
                bush,
                oven,
                tableEmpty
        );
    }

    private Item blockToItem(Block block) {
        ResourceLocation blockLocation = Objects.requireNonNull(block.getRegistryName());
        return new ItemBlock(block).setRegistryName(blockLocation);
    }

    private void registerRender(Block... blocks) {
        for (Block block : blocks) {
            Item item = Item.getItemFromBlock(block);
            ResourceLocation itemLocation = Objects.requireNonNull(item.getRegistryName());
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(itemLocation, "inventory"));
        }
    }
}
