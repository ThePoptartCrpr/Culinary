package com.thepoptartcrpr.culinary.blocks.plants.bush;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BushBlock extends BlockBush {

    // This is a test of a bush setup. This will eventually be replaced
    // with a set of proper growable fruit bushes (blueberry bush, etc)
    // that will have this bush texture as a base with berries added

    public BushBlock() {
        super(Material.VINE);
        this.setUnlocalizedName("bush");
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "bush"));
    }

}
