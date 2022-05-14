package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.common.item.ItemLoader;

import java.util.Random;

public class BlockIronLightningBroken extends Block{

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockIronLightningBroken()
    {
        super(Material.IRON);
        this.setHardness(2.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }


    @SideOnly(Side.CLIENT)
    @SuppressWarnings("incomplete-switch")
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
            double x = (double) pos.getX() + 0.5D;
            double y = (double) pos.getY() + 0.75D;
            double z = (double) pos.getZ() + 0.5D;
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, 0.0D, 0.0D, 0.0D);
    }

    @Override
    protected BlockStateContainer createBlockState()
{
    return new BlockStateContainer(this, FACING);
}

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 3);
        return this.getDefaultState().withProperty(FACING, facing);
    }
    //get meta from state
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int facing = state.getValue(FACING).getHorizontalIndex();
        return facing;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemLoader.SUPER_CHARGED_IRON_INGOT;
    }
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    public int quantityDropped(Random random)
    {
        return 6 + random.nextInt(3);
    }
}
