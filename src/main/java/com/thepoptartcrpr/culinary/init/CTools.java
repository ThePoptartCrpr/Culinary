package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.items.CItemAxe;
import com.thepoptartcrpr.culinary.items.CItemSword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class CTools {

    public static final Item.ToolMaterial steelKnifeMaterial = EnumHelper.addToolMaterial(Culinary.Reference.MODID + ":steelKnife", 2, 250, 2, 1, 12);
    public static final Item.ToolMaterial sawMaterial = EnumHelper.addToolMaterial(Culinary.Reference.MODID + ":saw", 2, 200, 4, 3, 12);

    public static ItemSword steelKnife = new CItemSword(steelKnifeMaterial, "steel_knife");
    public static ItemAxe saw = new CItemAxe(sawMaterial, "saw");

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                steelKnife.setCreativeTab(Culinary.getInstance().getTabTools()),
                saw.setCreativeTab(Culinary.getInstance().getTabTools())
        );
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        registerRender(
                steelKnife,
                saw
        );
    }

    private void registerRender(Item... items) {
        for (Item item : items) {
            ResourceLocation itemLocation = Objects.requireNonNull(item.getRegistryName());
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(itemLocation, "inventory"));
        }
    }

}
