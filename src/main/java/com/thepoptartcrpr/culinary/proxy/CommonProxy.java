package com.thepoptartcrpr.culinary.proxy;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.tileentity.OvenTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit() {

    }

    public void init() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(OvenTileEntity.class, new ResourceLocation(Culinary.Reference.MODID + ":oven"));
    }

}
