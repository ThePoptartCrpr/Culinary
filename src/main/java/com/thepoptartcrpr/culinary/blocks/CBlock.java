package com.thepoptartcrpr.culinary.blocks;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.init.CBlocks;
import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

// TODO: the name CBlock (short for CulinaryBlock) doesn't really fit, find better alternative but i cba rn

public class CBlock extends Block {

    public CBlock(String name, Material material, float hardness, float resistance) {
        super(material);

        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

}
