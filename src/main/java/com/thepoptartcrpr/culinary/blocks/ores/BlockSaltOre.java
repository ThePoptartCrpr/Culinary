package com.thepoptartcrpr.culinary.blocks.ores;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.init.CBlocks;
import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class BlockSaltOre extends Block {

    public BlockSaltOre(String name, Material material, float hardness, float resistance) {
        super(material);

        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return CItems.salt;
    }

    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }

}
