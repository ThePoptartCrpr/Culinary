package com.thepoptartcrpr.culinary.blocks.machines;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.tileentity.CuttingBoardTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TableCuttingBoardBlock extends Block implements ITileEntityProvider {

    public static final PropertyBool KNIFE = PropertyBool.create("knife");

    public TableCuttingBoardBlock() {
        super(Material.WOOD);

        this.setUnlocalizedName("table_cutting_board");
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "table_cutting_board"));

        this.setDefaultState(this.blockState.getBaseState().withProperty(KNIFE, Boolean.valueOf(false)));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        boolean knife = state.getValue(KNIFE);
        return knife ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        boolean knife;
        knife = meta == 1;
        return this.getDefaultState().withProperty(KNIFE, knife);
    }

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

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return super.createTileEntity(worldIn, this.getStateFromMeta(meta));
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new CuttingBoardTileEntity();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{KNIFE});
    }

}
