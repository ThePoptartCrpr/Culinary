package com.thepoptartcrpr.culinary.creativetabs;

import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCIngredients extends CreativeTabs {

    public TabCIngredients() {
        super("cingredient");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CItems.salt);
    }

}
