package net.pasterdream.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pasterdream.PasterdreamMod;
import net.pasterdream.init.PasterdreamModBlocks;

import java.util.concurrent.CompletableFuture;

public class PDBlockTagProvider extends BlockTagsProvider {
    public PDBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PasterdreamMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //挖掘等级0
        tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(PasterdreamModBlocks.AMBER_CANDY_ORE.get());
        //挖掘等级1
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(PasterdreamModBlocks.BLACKMETAL_BLOCK.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_STAIRS.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_SLAB.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_WALL.get());
        //挖掘等级2
        tag(BlockTags.NEEDS_IRON_TOOL);
        //挖掘等级3
        tag(BlockTags.NEEDS_DIAMOND_TOOL);
        //挖掘等级4
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
        //需要镐子
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(PasterdreamModBlocks.BLACKMETAL_BLOCK.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_STAIRS.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_SLAB.get())
                .add(PasterdreamModBlocks.SHADOW_STONE_BRICKS_WALL.get())
                .add(PasterdreamModBlocks.AMBER_CANDY_ORE.get());
        //需要斧头
        tag(BlockTags.MINEABLE_WITH_AXE);
        //需要铲子
        tag(BlockTags.MINEABLE_WITH_SHOVEL);
        //需要锄头
        tag(BlockTags.MINEABLE_WITH_HOE);
    }
}
