package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import zhenzi233.zhenzimod.common.block.tileentity.slot.RackSlot;


public class TileEntityRack extends TileEntity {


    ItemStackHandler ITEM_PUT = new RackSlot();
    ItemStackHandler ITEM_OUT = new RackSlot();


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
            T result = (T) (facing == EnumFacing.DOWN ? ITEM_OUT : ITEM_PUT);
            return result;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.ITEM_PUT.deserializeNBT(compound.getCompoundTag("PutItem"));
        this.ITEM_OUT.deserializeNBT(compound.getCompoundTag("OutItem"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setTag("PutItem", this.ITEM_PUT.serializeNBT());
        compound.setTag("OutItem", this.ITEM_OUT.serializeNBT());
        return compound;
    }

//    @Override
//    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
//    {
//        return oldState.getBlock() != newState.getBlock();
//    }
}
