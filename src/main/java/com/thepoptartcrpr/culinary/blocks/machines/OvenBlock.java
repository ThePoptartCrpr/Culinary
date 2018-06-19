package com.thepoptartcrpr.culinary.blocks.machines;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.init.CBlocks;
import com.thepoptartcrpr.culinary.tileentity.OvenTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Change to BlockContainer / TileEntity later
public class OvenBlock extends BlockContainer implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    private static final EnumFacing[] VALID_FACING = {
            EnumFacing.NORTH,
            EnumFacing.EAST,
            EnumFacing.SOUTH,
            EnumFacing.WEST
    };

    public OvenBlock() {
        super(Material.IRON);

        this.setUnlocalizedName("oven");
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "oven"));
        this.setHardness(3);
        this.setResistance(20);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing = (EnumFacing) state.getValue(FACING);
        int meta = EnumFacing.values().length + facing.ordinal();
        return meta;
    }

    @Override
    public EnumFacing[] getValidRotations(World world, BlockPos pos) {
        return VALID_FACING;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.values()[meta % EnumFacing.values().length];
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(ACTIVE, Boolean.valueOf(false));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return super.createTileEntity(worldIn, getStateFromMeta(meta));
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new OvenTileEntity();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = playerIn.getHeldItem(hand);
        setState(facing, true, worldIn, pos);
        return true;
    }

    public static void setState(EnumFacing facing, boolean active, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        TileEntity tileEntity = world.getTileEntity(pos);

        world.setBlockState(pos, CBlocks.oven.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, active));

        if (tileEntity != null) {
            tileEntity.validate();
            world.setTileEntity(pos, tileEntity);
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING, ACTIVE});
    }

}
