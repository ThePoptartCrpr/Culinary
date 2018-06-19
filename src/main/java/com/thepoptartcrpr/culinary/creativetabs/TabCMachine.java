package com.thepoptartcrpr.culinary.creativetabs;

import com.thepoptartcrpr.culinary.init.CBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCMachine extends CreativeTabs {

    public TabCMachine() {
        super("cmachine");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CBlocks.oven);
    }

}
