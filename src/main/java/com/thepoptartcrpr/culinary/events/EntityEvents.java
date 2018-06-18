package com.thepoptartcrpr.culinary.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EntityEvents {
    private Random random = new Random();

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        EntityLivingBase entity = event.getEntityLiving();

        if (entity instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal) entity;

            if (animal.getGrowingAge() == 0)
                animal.dropItem(Items.BONE, random.nextInt(3));
        }
    }

}
