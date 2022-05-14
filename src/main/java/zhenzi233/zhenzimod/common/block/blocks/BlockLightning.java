package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.block.BlockBase;


public class BlockLightning extends BlockIronLightningRS {

    public BlockLightning(){
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.isBlockPowered(pos))
            {
                worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), false));
                worldIn.setBlockState(pos, state.withProperty(POWER_STATE, 2), 2);
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
//        Boolean flag = world.isBlockPowered(observerPos) || world.isBlockPowered(observerPos.down());
        if (!worldIn.isRemote)
        {
            if (state.getValue(POWER_STATE) == 0)
            {
                if (worldIn.isBlockPowered(pos))
                {
                    worldIn.setBlockState(pos, state.withProperty(POWER_STATE, 1), 2);
                }
            }
            if (!worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, state.withProperty(POWER_STATE, 0), 2);
            }


        }
    }

    @Override
    public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos)
    {
        int power = observerState.getValue(POWER_STATE);
        if (!world.isRemote)
        {
            if (power == 1)
            {
                world.addWeatherEffect(new EntityLightningBolt(world, observerPos.getX(), observerPos.getY() + 1, observerPos.getZ(), false));
                world.setBlockState(observerPos, observerState.withProperty(POWER_STATE, 2), 2);
            }
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote){
            worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), false));
        }
        return true;
    }




}




