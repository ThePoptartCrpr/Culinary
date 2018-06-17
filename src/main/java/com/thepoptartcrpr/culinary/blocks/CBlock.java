package com.thepoptartcrpr.culinary.blocks;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

// TODO: the name CBlock (short for CulinaryBlock) doesn't really fit, find better alternative but i cba rn

public class CBlock extends Block {

    public CBlock(String unlocalizedName, String registryName, Material material, float hardness, float resistance) {
        super(material);

        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Culinary.MODID, registryName));
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

}
