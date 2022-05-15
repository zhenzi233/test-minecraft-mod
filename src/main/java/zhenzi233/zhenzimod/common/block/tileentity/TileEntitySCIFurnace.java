package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import zhenzi233.zhenzimod.common.block.blocks.BlockSCIPulseFurnace;

public class TileEntitySCIFurnace extends TileEntity implements ITickable {


    protected int burnTime = 0;

    protected ItemStackHandler upInventory = new ItemStackHandler();
    protected ItemStackHandler downInventory = new ItemStackHandler();


    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            // return your IItemHandler
            @SuppressWarnings("unchecked")
            T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
            return result;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.upInventory.deserializeNBT(compound.getCompoundTag("UpInventory"));
        this.downInventory.deserializeNBT(compound.getCompoundTag("DownInventory"));
        this.burnTime = compound.getInteger("BurnTime");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setTag("UpInventory", this.upInventory.serializeNBT());
        compound.setTag("DownInventory", this.downInventory.serializeNBT());
        compound.setInteger("BurnTime", this.burnTime);
        return compound;
    }

    @Override
    public void update()
    {
        if (!this.world.isRemote)
        {
//对应的物品槽获取物品
            ItemStack itemStack = upInventory.extractItem(0, 1, true);
            IBlockState state = this.world.getBlockState(pos);
//对应的物品槽塞入物品
            if (itemStack != ItemStack.EMPTY && downInventory.insertItem(0, itemStack, true) == ItemStack.EMPTY)
            {
                this.world.setBlockState(pos, state.withProperty(BlockSCIPulseFurnace.BURNING, Boolean.TRUE));

                int burnTotalTime = 100;

                if (++this.burnTime >= burnTotalTime)
                {
                    this.burnTime = 0;
                    itemStack = upInventory.extractItem(0, 1, false);
                    downInventory.insertItem(0, itemStack, false);
                    this.markDirty();
                }
            }
            else
            {
                this.world.setBlockState(pos, state.withProperty(BlockSCIPulseFurnace.BURNING, Boolean.FALSE));
                this.burnTime = 0;
            }

        }
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }

    public int getBurnTime()
    {
        return this.burnTime;
    }
    public int getTotalBurnTime()
    {
        return 100;
    }

}
