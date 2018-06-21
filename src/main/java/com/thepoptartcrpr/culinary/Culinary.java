package com.thepoptartcrpr.culinary;

import com.thepoptartcrpr.culinary.creativetabs.TabCMachine;
import com.thepoptartcrpr.culinary.events.BlockEvents;
import com.thepoptartcrpr.culinary.handlers.ConfigHandler;
import com.thepoptartcrpr.culinary.creativetabs.TabCIngredient;
import com.thepoptartcrpr.culinary.events.EntityEvents;
import com.thepoptartcrpr.culinary.handlers.LootTableHandler;
import com.thepoptartcrpr.culinary.handlers.SeedHandler;
import com.thepoptartcrpr.culinary.init.CBlocks;
import com.thepoptartcrpr.culinary.init.CItems;
import com.thepoptartcrpr.culinary.init.CTools;
import com.thepoptartcrpr.culinary.proxy.CommonProxy;
import com.thepoptartcrpr.culinary.worldgen.OreGeneration;
import lombok.Getter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Culinary.Reference.MODID, name = Culinary.Reference.NAME, version = Culinary.Reference.VERSION)
public class Culinary {
    @Mod.Instance @Getter
    private static Culinary instance;

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @Getter
    private final CreativeTabs tabIngredient = new TabCIngredient();

    @Getter
    private final CreativeTabs tabMachine = new TabCMachine();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        proxy.registerTileEntities();

        MinecraftForge.EVENT_BUS.register(new CBlocks());
        MinecraftForge.EVENT_BUS.register(new CItems());
        MinecraftForge.EVENT_BUS.register(new CTools());

        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();

        MinecraftForge.EVENT_BUS.register(new EntityEvents());
        MinecraftForge.EVENT_BUS.register(new BlockEvents());

        MinecraftForge.EVENT_BUS.register(new LootTableHandler());

        SeedHandler.registerSeeds();

        GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static class Reference {
        public static final String MODID = "culinary";
        public static final String NAME = "Culinary";
        public static final String VERSION = "0.0.1";
        public static final String SERVER_PROXY_CLASS = "com.thepoptartcrpr.culinary.proxy.ServerProxy";
        public static final String CLIENT_PROXY_CLASS = "com.thepoptartcrpr.culinary.proxy.ClientProxy";
    }
}
