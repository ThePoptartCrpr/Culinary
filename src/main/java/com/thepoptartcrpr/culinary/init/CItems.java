package com.thepoptartcrpr.culinary.init;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.items.CFood;
import com.thepoptartcrpr.culinary.items.SaltItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class CItems {

    // Ingredients
    public static Item salt = new SaltItem();

    // Seeds
    public static Item cornSeeds = new ItemSeeds(CBlocks.cornCrop, Blocks.FARMLAND).setUnlocalizedName("corn_seeds").setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "corn_seeds"));

    // Crops
    public static Item corn = new CFood("corn", 2, 2, false);

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        CreativeTabs tabIngredient = Culinary.getInstance().getTabIngredient();

        event.getRegistry().registerAll(
            salt.setCreativeTab(tabIngredient),
            cornSeeds.setCreativeTab(tabIngredient),
            corn.setCreativeTab(tabIngredient)
        );
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        registerRender(
                salt,
                cornSeeds,
                corn
        );
    }

    private void registerRender(Item... items) {
        for (Item item : items) {
            ResourceLocation itemLocation = Objects.requireNonNull(item.getRegistryName());
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(itemLocation, "inventory"));
        }
    }

}
