package com.thepoptartcrpr.culinary.items;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class CItemSword extends ItemSword {

    public CItemSword(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
    }

}
