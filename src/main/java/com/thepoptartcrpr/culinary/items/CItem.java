package com.thepoptartcrpr.culinary.items;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CItem extends Item {

    public CItem(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
    }

}
