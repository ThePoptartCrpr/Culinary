package com.thepoptartcrpr.culinary.blocks;

import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class SaltBlock extends CBlock {
    public SaltBlock() {
        super("salt_ore", Material.ROCK, 2, 2);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return CItems.salt;
    }

    @Override
    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }
}
