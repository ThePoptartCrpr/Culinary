package com.thepoptartcrpr.culinary.proxy;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.tileentity.OvenTileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit() {

    }

    public void init() {

    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(OvenTileEntity.class, Culinary.Reference.MODID + ":oven");
    }

}
