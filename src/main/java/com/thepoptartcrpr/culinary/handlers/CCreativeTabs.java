package com.thepoptartcrpr.culinary.handlers;

import com.thepoptartcrpr.culinary.init.CItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CCreativeTabs {

    public static final CreativeTabs tabIngredients = new CreativeTabs("cingredients") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(CItems.salt);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

    }.setBackgroundImageName("item_search.png");

}
