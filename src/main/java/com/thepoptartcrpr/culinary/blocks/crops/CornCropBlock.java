package com.thepoptartcrpr.culinary.blocks.crops;

import com.thepoptartcrpr.culinary.Culinary;
import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CornCropBlock extends BlockCrops {

    public CornCropBlock() {
        this.setUnlocalizedName("corn_crop");
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, "corn_crop"));
    }

    @Override
    public Item getSeed() {
        return CItems.cornSeeds;
    }

    @Override
    public Item getCrop() {
        return CItems.corn;
    }

}
