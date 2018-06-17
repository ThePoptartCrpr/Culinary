package com.thepoptartcrpr.culinary.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class EntityEvents {

    private Random random = new Random();

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        EntityLivingBase entityLiving = event.entityLiving;
        if (entityLiving instanceof EntityAnimal) {
            if (((EntityAnimal) entityLiving).getGrowingAge() == 0) entityLiving.dropItem(Items.bone, random.nextInt(3));
        }
    }

}
