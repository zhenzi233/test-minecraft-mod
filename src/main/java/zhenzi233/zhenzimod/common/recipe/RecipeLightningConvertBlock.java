package zhenzi233.zhenzimod.common.recipe;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.event.EventLightningConvert;


public class RecipeLightningConvertBlock {

    public static void addConvertRecipe(IBlockState inputState, IBlockState outputState)
    {
        EventLightningConvert.instance().addConvertRecipe(inputState, outputState);
    }

    public static void addRecipe()
    {
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.IRON_BLOCK.getDefaultState(), BlockLoader.SUPER_CHARGED_IRON_BLOCK.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE), Blocks.DEADBUSH.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.RED_FLOWER.getDefaultState(), BlockLoader.THUNDER_FLOWER.getDefaultState());
        RecipeLightningConvertBlock.addConvertRecipe(Blocks.YELLOW_FLOWER.getDefaultState(), BlockLoader.THUNDER_FLOWER.getDefaultState());
    }

}
