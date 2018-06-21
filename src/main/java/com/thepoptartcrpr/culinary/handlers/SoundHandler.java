package com.thepoptartcrpr.culinary.handlers;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundHandler {

    public static SoundEvent sawBlock;

    public static void init() {
        sawBlock = register(sawBlock, "saw");
    }

    public static SoundEvent register(SoundEvent sound, String name) {
        sound = new SoundEvent(new ResourceLocation(Culinary.Reference.MODID, name));
        return sound;
    }

}
