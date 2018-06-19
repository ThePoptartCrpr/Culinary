package com.thepoptartcrpr.culinary.creativetabs;

        import com.thepoptartcrpr.culinary.init.CItems;
        import net.minecraft.creativetab.CreativeTabs;
        import net.minecraft.item.ItemStack;

public class TabCIngredient extends CreativeTabs {

    public TabCIngredient() {
        super("cingredient");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CItems.salt);
    }

}
