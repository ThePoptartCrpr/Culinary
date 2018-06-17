package com.thepoptartcrpr.culinary;

import com.thepoptartcrpr.culinary.events.EntityEvents;
import com.thepoptartcrpr.culinary.init.CBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Culinary.MODID, name = Culinary.NAME, version = Culinary.VERSION)
public class Culinary {
    public static final String MODID = "culinary";
    public static final String NAME = "Culinary";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
