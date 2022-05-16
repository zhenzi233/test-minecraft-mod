package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import zhenzi233.zhenzimod.common.block.tileentity.slot.RackSlot;
import zhenzi233.zhenzimod.common.recipe.recipeutil.RecipeRackUtil;

import javax.annotation.Nonnull;


public class TileEntityRack extends TileEntity implements ITickable {


    ItemStackHandler ITEM_PUT = new RackSlot();
    ItemStackHandler ITEM_OUT = new RackSlot();
    RecipeRackUtil recipeRackUtil = RecipeRackUtil.instance();
    public boolean runRackWithLightning = false;

    public TileEntityRack()
    {
    }

    public void setValue(boolean value)
    {
        this.runRackWithLightning = value;
    }


    public boolean getValue()
    {
        return this.runRackWithLightning;
    }


    @Override
    public void update()
    {
        if (!world.isRemote)
        {

            ItemStack stack = ITEM_PUT.extractItem(0, 1, true);
            Item item = stack.getItem();
            ItemStack output = recipeRackUtil.getRackRecipe(item);
            if (this.getValue() && !stack.isEmpty())
            {
                if (!output.isEmpty())
                {
                    ITEM_PUT.extractItem(0, 1, false);
                    ITEM_OUT.insertItem(0, output, false);
                    this.markDirty();
                    this.setValue(false);
                }
            }
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing)
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
    public void readFromNBT(@Nonnull NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.ITEM_PUT.deserializeNBT(compound.getCompoundTag("PutItem"));
        this.ITEM_OUT.deserializeNBT(compound.getCompoundTag("OutItem"));
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound compound)
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
