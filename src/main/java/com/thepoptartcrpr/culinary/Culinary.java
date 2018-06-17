package com.thepoptartcrpr.culinary;

import com.thepoptartcrpr.culinary.events.EntityEvents;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Culinary.MODID, name = Culinary.NAME, version = Culinary.VERSION)
public class Culinary {

    public static final String MODID = "culinary";
    public static final String NAME = "Culinary";
    public static final String VERSION = "0.0.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
