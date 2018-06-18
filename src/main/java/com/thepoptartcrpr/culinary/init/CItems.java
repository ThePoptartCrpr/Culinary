package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.blocks.CItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class CItems {
    public static Item salt;

    public CItems() {
        salt = new CItem("salt");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            salt
        );
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        registerRender(salt);
    }

    private void registerRender(Item item) {
        ResourceLocation itemLocation = Objects.requireNonNull(item.getRegistryName());
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(itemLocation, "inventory"));
    }

}
