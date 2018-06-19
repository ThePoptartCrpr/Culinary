package com.thepoptartcrpr.culinary.blocks.machines;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;

public class TableBlock extends Block {

    public TableBlock() {
        super(Material.WOOD);

        this.setUnlocalizedName("table_empty");
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "table_empty"));
        this.setHardness(1);
        this.setResistance(1);
    }

    /*
    Below 2 methods - Mojang's only deprecated them because they're considered "internal",
    they are still important to the block model and must not be removed
     */

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

}
