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

    @SubscribeEvent
    public void onBlockDrop(BlockEvent.HarvestDropsEvent event) {
        Block block = event.getState().getBlock();
        ItemStack heldItem = event.getHarvester().getHeldItemMainhand();
        if (block == Blocks.LOG && ConfigHandler.CONFIG.shouldSawLogs && heldItem.isItemEqualIgnoreDurability(new ItemStack(CTools.saw))) {
            // TODO: improve functionality of below remove statement
            event.getDrops().remove(event.getDrops().get(0));
            event.getDrops().add(new ItemStack(Blocks.PLANKS, ConfigHandler.CONFIG.planksToSaw, block.damageDropped(event.getState())));

            event.getWorld().playSound(null, event.getPos(), SoundHandler.sawBlock, SoundCategory.BLOCKS, 1, 1);
        }
        else if (block == Blocks.LOG2 && ConfigHandler.CONFIG.shouldSawLogs && heldItem.isItemEqualIgnoreDurability(new ItemStack(CTools.saw))) {
            // TODO: improve functionality of below remove statement
            event.getDrops().remove(event.getDrops().get(0));
            event.getDrops().add(new ItemStack(Blocks.PLANKS, ConfigHandler.CONFIG.planksToSaw, block.damageDropped(event.getState()) + 4));

            event.getWorld().playSound(null, event.getPos(), SoundHandler.sawBlock, SoundCategory.BLOCKS, 1, 1);
        }
    }

}
