package com.thepoptartcrpr.culinary.creativetabs;

import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCFood extends CreativeTabs {

    public TabCFood() {
        super("cfood");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CItems.corn);
    }

}
