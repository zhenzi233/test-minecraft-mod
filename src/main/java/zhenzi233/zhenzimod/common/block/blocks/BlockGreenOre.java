package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.block.BlockBase;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityDisplayItem;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockGreenOre extends BlockBase {

    public static final PropertyInteger LIGHT = PropertyInteger.create("light", 0, 12);

    public BlockGreenOre(){
        super(Material.ROCK);
        this.setHardness(3.0F);
        this.setLightLevel(12F);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }
    @Override
    public boolean onBlockActivated(World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state, EntityPlayer playerIn, @Nonnull EnumHand hand, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            double posX = pos.getX();
            double posY = pos.getY();
            double posZ = pos.getZ();
            worldIn.spawnEntity(new EntityDisplayItem(worldIn, posX + 0.5D, posY + 1.0D, posZ + 0.5D, new ItemStack(ItemLoader.GREEN_DOG)));
        }
        return true;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemLoader.PULSE_IMPURITY;
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == BlockLoader.GREEN_ORE_BLOCK)
            {
                i = MathHelper.getInt(rand, 5, 8);
            }
            return i;
        }
        return 0;
    }

//    public
}
