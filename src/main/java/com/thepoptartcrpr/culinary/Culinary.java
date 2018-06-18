package com.thepoptartcrpr.culinary;

import com.thepoptartcrpr.culinary.creativetabs.TabCIngredients;
import com.thepoptartcrpr.culinary.events.EntityEvents;
import com.thepoptartcrpr.culinary.init.CBlocks;
import com.thepoptartcrpr.culinary.init.CItems;
import lombok.Getter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Culinary.Reference.MODID, name = Culinary.Reference.NAME, version = Culinary.Reference.VERSION)
public class Culinary {
    @Mod.Instance @Getter
    private static Culinary instance;

    @Getter
    private final CreativeTabs tabIngredients = new TabCIngredients();

    public static final CreativeTabs tabIngredients = new CreativeTabs("cingredients") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(CItems.salt);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

    }.setBackgroundImageName("item_search.png");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CBlocks());
        MinecraftForge.EVENT_BUS.register(new CItems());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static class Reference {
        public static final String MODID = "culinary";
        public static final String NAME = "Culinary";
        public static final String VERSION = "0.0.1";
    }
}
