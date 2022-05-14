package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.block.BlockBase;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

public class BlockIronLightningRS extends BlockBase {
    public static final PropertyInteger POWER_STATE = PropertyInteger.create("power_state", 0, 2);
    public BlockIronLightningRS(){
        super(Material.IRON);
        this.setHardness(5.0F);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWER_STATE, 0));
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.isBlockPowered(pos))
            {
                worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), false));
                this.setBlockIronLightningBroken(worldIn, pos);
            }
        }
    }

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

    public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos)
    {
        int power = observerState.getValue(POWER_STATE);
        if (!world.isRemote)
        {
            if (power == 1)
            {
                world.addWeatherEffect(new EntityLightningBolt(world, observerPos.getX(), observerPos.getY() + 1, observerPos.getZ(), false));
                this.setBlockIronLightningBroken(world, observerPos);
            }
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, POWER_STATE);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(POWER_STATE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWER_STATE, meta);
    }

}
