package com.thepoptartcrpr.culinary.handlers;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraftforge.common.config.Config;
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
        @Comment("When enabled, logs harvested with a saw tool will automatically drop planks. You might want to disable this if you have, for instance, modified the plank recipe")
        public static boolean   shouldSawLogs = true;
        @Comment("When shouldSawLogs is enabled, this modifies how many planks are dropped when a log is sawed, maximum of 4")
        public static int       planksToSaw = 4;
    }

}
