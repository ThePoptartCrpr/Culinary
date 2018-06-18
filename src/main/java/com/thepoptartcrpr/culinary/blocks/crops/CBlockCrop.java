package com.thepoptartcrpr.culinary.blocks.crops;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.block.BlockCrops;
import net.minecraft.util.ResourceLocation;

public class CBlockCrop extends BlockCrops {

    public CBlockCrop(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.MODID, name));
    }

}
