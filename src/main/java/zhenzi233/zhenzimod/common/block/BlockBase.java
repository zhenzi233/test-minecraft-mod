package zhenzi233.zhenzimod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.block.blocks.BlockIronLightningBroken;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

import java.util.Random;

public class BlockBase extends Block {

    public BlockBase(Material material){
        super(material);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    public void setBlockIronLightningBroken(World world, BlockPos getBlockPos)
    {
        Random rand = new Random();
        int value = rand.nextInt(4);
        switch (value)
        {
            case 1:
                world.setBlockState(getBlockPos, BlockLoader.IRON_LIGHTNING_BLOCK_BROKEN.getDefaultState().withProperty(BlockIronLightningBroken.FACING, EnumFacing.WEST), 2);
                break;
            case 2:
                world.setBlockState(getBlockPos, BlockLoader.IRON_LIGHTNING_BLOCK_BROKEN.getDefaultState().withProperty(BlockIronLightningBroken.FACING, EnumFacing.NORTH), 2);
                break;
            case 3:
                world.setBlockState(getBlockPos, BlockLoader.IRON_LIGHTNING_BLOCK_BROKEN.getDefaultState().withProperty(BlockIronLightningBroken.FACING, EnumFacing.SOUTH), 2);
                break;
            default:
                world.setBlockState(getBlockPos, BlockLoader.IRON_LIGHTNING_BLOCK_BROKEN.getDefaultState().withProperty(BlockIronLightningBroken.FACING, EnumFacing.EAST), 2);
                break;
        }
    }
}
