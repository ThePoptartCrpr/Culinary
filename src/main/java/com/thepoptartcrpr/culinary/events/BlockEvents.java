package com.thepoptartcrpr.culinary.events;

import com.thepoptartcrpr.culinary.handlers.ConfigHandler;
import com.thepoptartcrpr.culinary.handlers.SoundHandler;
import com.thepoptartcrpr.culinary.init.CTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockEvents {

    // TODO: add compatibility for LOG2 as well

    @SubscribeEvent
    public void onBlockDrop(BlockEvent.HarvestDropsEvent event) {
        Block block = event.getState().getBlock();
        ItemStack heldItem = event.getHarvester().getHeldItemMainhand();
        if (block == Blocks.LOG && ConfigHandler.CONFIG.shouldSawLogs && heldItem.isItemEqualIgnoreDurability(new ItemStack(CTools.saw))) {
            // TODO: improve functionality of below remove statement
            event.getDrops().remove(event.getDrops().get(0));
            // TODO: drop plank of correct type according to log type
            event.getDrops().add(new ItemStack(Blocks.PLANKS, 4));

            event.getWorld().playSound(null, event.getPos(), SoundHandler.sawBlock, SoundCategory.BLOCKS, 1, 1);
        }
    }

}
