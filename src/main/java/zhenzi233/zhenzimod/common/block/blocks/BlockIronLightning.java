package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.block.BlockBase;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.event.EventTicker;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

import java.util.Random;

public class BlockIronLightning extends BlockBase {
    public BlockIronLightning(){
        super(Material.IRON);
        this.setHardness(5.0F);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }


    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote){
            ItemStack stack = playerIn.getHeldItem(hand);
            Item item = playerIn.getHeldItem(hand).getItem();
            if (!stack.isEmpty() && item == Items.REDSTONE){
                if (!playerIn.capabilities.isCreativeMode){
                    stack.shrink(1);
                }
                worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), false));
                worldIn.destroyBlock(pos, false);
//                new EventTicker().onTick(()-> worldIn.setBlockState(pos, state), 2000);
                this.setBlockIronLightningBroken(worldIn, pos);

            }
        }
        return true;
    }

    public void spawnItem(World world, double x, double y, double z, Item item)
    {
        Random rand = new Random();
        int i = 7 + rand.nextInt(2);
        for (int j = 0; j < i; ++j )
        {
            world.spawnEntity(new EntityItem(world, x, y, z, new ItemStack(item)));
        }
    }
}
