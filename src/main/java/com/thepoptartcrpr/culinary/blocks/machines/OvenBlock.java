package com.thepoptartcrpr.culinary.blocks.machines;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.creativetabs.TabCMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Change to BlockContainer / TileEntity later
public class OvenBlock extends Block {

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

        // this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, Boolean.valueOf(false)));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }



}
