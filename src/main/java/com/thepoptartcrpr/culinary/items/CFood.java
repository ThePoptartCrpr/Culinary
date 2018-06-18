package com.thepoptartcrpr.culinary.items;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class CFood extends ItemFood {

    public CFood(String name, int amount, int saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
    }

}
