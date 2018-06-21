package com.thepoptartcrpr.culinary.creativetabs;

import com.thepoptartcrpr.culinary.init.CTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCTools extends CreativeTabs {

    public TabCTools() {
        super("ctools");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CTools.saw);
    }

}
