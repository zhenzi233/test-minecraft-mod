package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
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

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockRack extends BlockContainer {
    protected static final AxisAlignedBB RACK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
    public ItemStack itemStackCache1;
    public ItemStack itemStackCache2;
    public boolean SlotTouched = false;

    public BlockRack()
    {
        super(Material.IRON);
        this.setHardness(1.0F);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta)
    {
        return new TileEntityRack();
    }
    //change tileEntity RenderType
    @Override
    @Nonnull
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

//    @Override
//    public boolean isTopSolid(IBlockState state)
//    {
//        return false;
//    }
    @Override
    public void breakBlock(World worldIn,@Nonnull BlockPos pos,@Nonnull IBlockState state)
    {
        TileEntityRack te = (TileEntityRack) worldIn.getTileEntity(pos);
        IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
        ItemStack rackUpStack = up.getStackInSlot(0);
        ItemStack rackDownStack = down.getStackInSlot(0);
        if (!rackUpStack.isEmpty())
        {
            Block.spawnAsEntity(worldIn, pos, rackUpStack);
        }
        if (!rackDownStack.isEmpty())
        {
            Block.spawnAsEntity(worldIn, pos, rackDownStack);
        }
        super.breakBlock(worldIn, pos, state);
        worldIn.updateComparatorOutputLevel(pos, this);
    }
    @Override
    public boolean onBlockActivated(World worldIn,@Nonnull BlockPos pos,@Nonnull IBlockState state, EntityPlayer playerIn,@Nonnull EnumHand hand,@Nonnull EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack playerHandStack = playerIn.getHeldItem(EnumHand.MAIN_HAND);
        ItemStack recordStack = playerHandStack.copy();
        TileEntityRack te = (TileEntityRack) worldIn.getTileEntity(pos);
        IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
        ItemStack rackUpStack = up.getStackInSlot(0);
        ItemStack rackDownStack = down.getStackInSlot(0);
        if (!worldIn.isRemote && !playerIn.getHeldItem(hand).equals(new ItemStack(ItemLoader.DEBUGGING_TOOLS)))
        {
            if (!playerIn.isSneaking())
            {

                if (!up.getStackInSlot(0).isEmpty())
                {
                    up.extractItem(0, 1, false);
                    EntityItem entityItem = playerIn.dropItem(rackUpStack, false);
                    if (entityItem != null)
                    {
                        entityItem.setNoPickupDelay();
                        entityItem.setOwner(playerIn.getName());
                    }
                    te.sendInventoryItemPacket();
                    return true;
                }

                if (!down.getStackInSlot(0).isEmpty())
                {
                    down.extractItem(0, 1, false);
                    EntityItem entityItem = playerIn.dropItem(rackDownStack, false);
                    if (entityItem != null)
                    {
                        entityItem.setNoPickupDelay();
                        entityItem.setOwner(playerIn.getName());
                    }
                    te.sendInventoryItemPacket();
                    return true;
                }

                if (up.getStackInSlot(0).isEmpty() && down.getStackInSlot(0).isEmpty())
                {
                    if (!playerHandStack.isEmpty() && !playerIn.capabilities.isCreativeMode)
                    {
                        up.insertItem(0, recordStack, false);
                        playerHandStack.shrink(1);
                        te.sendInventoryItemPacket();
                    } else {
                        up.insertItem(0, recordStack, false);
                        te.sendInventoryItemPacket();
                    }

                }

            }   else {

                String msg = String.format("Up: %s, Down: %s", up.getStackInSlot(0), down.getStackInSlot(0));
                playerIn.sendMessage(new TextComponentString(msg));

            }
        }
        return true;
    }
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityChest)
        {
            tileentity.updateContainingBlockInfo();
        }
    }
    @Nonnull
    public AxisAlignedBB getBoundingBox(@Nonnull IBlockState state,@Nonnull IBlockAccess source,@Nonnull BlockPos pos)
    {
        return RACK_AABB;
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }
    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        TileEntityRack tileEntityRack = (TileEntityRack) worldIn.getTileEntity(pos);
        if (!tileEntityRack.getInputItem().isEmpty())
        {
            return 1;
        }
        if (!tileEntityRack.getOutputItem().isEmpty())
        {
            return 2;
        }
        return 0;
    }

    @Override
    public boolean isOpaqueCube(@Nonnull IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(@Nonnull IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isTopSolid(IBlockState state)
    {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
