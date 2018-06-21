package com.thepoptartcrpr.culinary.items;

import com.thepoptartcrpr.culinary.Culinary;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;

public class CItemAxe extends ItemAxe {

    public CItemAxe(ToolMaterial material, String name) {
        super(material, material.getAttackDamage(), -3.0F);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(Culinary.Reference.MODID, name));
    }

}
