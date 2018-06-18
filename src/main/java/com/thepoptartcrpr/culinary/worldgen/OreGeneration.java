package com.thepoptartcrpr.culinary.worldgen;

import com.google.common.base.Predicate;
import com.thepoptartcrpr.culinary.init.CBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
            // Nether
            case -1:
                break;
            // Overworld
            case 0:
                generate(CBlocks.saltOre.getDefaultState(), 10, 15, 20, 61, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
                break;
            // End
            case 1:
                break;
            default:
                break;
        }
    }

    private void generate(IBlockState block, int amount, int chance, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunkX, int chunkZ) {
        WorldGenMinable generator = new WorldGenMinable(block, amount, blockToReplace);
        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }

}
