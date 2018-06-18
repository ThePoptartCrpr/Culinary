package com.thepoptartcrpr.culinary.config;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Culinary.Reference.MODID)) ConfigManager.sync(Culinary.Reference.MODID, Config.Type.INSTANCE);
    }

    @Config(modid = Culinary.Reference.MODID, type = Type.INSTANCE, name = Culinary.Reference.NAME)
    public static class CONFIG {
        @Comment("When enabled, all animals will drop bones on death")
        public static boolean   shouldDropBones = true;
    }

}
