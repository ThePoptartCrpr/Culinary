package thepoptartcrpr.culinary.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class EntityEvents {

    private Random random = new Random();

    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
        if (event.entityLiving instanceof EntityAnimal) {
            event.entityLiving.dropItem(Items.bone, random.nextInt(3));
        }
    }

}
