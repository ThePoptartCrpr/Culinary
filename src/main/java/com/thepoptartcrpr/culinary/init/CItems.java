package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.items.SaltItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class CItems {
    public static Item salt = new SaltItem();

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        CreativeTabs tab = Culinary.getInstance().getTabIngredient();

        event.getRegistry().registerAll(
            salt.setCreativeTab(tab)
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
