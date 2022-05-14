package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityRack;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

public class BlockRack extends BlockContainer {
    protected static final AxisAlignedBB RACK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);

    public BlockRack()
    {
        super(Material.IRON);
        this.setHardness(1.0F);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityRack();
    }
    //change tileEntity RenderType
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote && !playerIn.getHeldItem(hand).equals(new ItemStack(ItemLoader.DEBUGGING_TOOLS)))
        {
            if (!playerIn.isSneaking())
            {
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 0.25D, pos.getZ(), new ItemStack(ItemLoader.GREEN_DOG)));
            }   else {
                TileEntityRack te = (TileEntityRack) worldIn.getTileEntity(pos);
                IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
                IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
                String msg = String.format("Up: %s, Down: %s", up.getStackInSlot(0), down.getStackInSlot(0));
                playerIn.sendMessage(new TextComponentString(msg));
            }
        }
        return true;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return RACK_AABB;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
