package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import zhenzi233.zhenzimod.common.block.tileentity.slot.RackSlot;
import zhenzi233.zhenzimod.common.event.EventHandler;
import zhenzi233.zhenzimod.common.event.EventServerHandler;
import zhenzi233.zhenzimod.common.network.MessageRack;
import zhenzi233.zhenzimod.common.network.NetworkLoader;
import zhenzi233.zhenzimod.common.recipe.recipeutil.RecipeRackUtil;

import javax.annotation.Nonnull;


public class TileEntityRack extends TileEntityBase implements ITickable {


    ItemStackHandler ITEM_PUT = new RackSlot();
    ItemStackHandler ITEM_OUT = new RackSlot();
    RecipeRackUtil recipeRackUtil = RecipeRackUtil.instance();
    public boolean runRackWithLightning = false;
    ItemStack inventoryItem = ItemStack.EMPTY;
    public boolean SlotTouched = false;

    public TileEntityRack()
    {
    }


    @Override
    public void update()
    {
        if (!world.isRemote)
        {

            ItemStack stack = ITEM_PUT.extractItem(0, 1, true);
            Item item = stack.getItem();
            ItemStack output = recipeRackUtil.getRackRecipe(item);
            if (!stack.isEmpty())
            {
                if (this.getValue())
                {
                    if (!output.isEmpty())
                    {
                        ITEM_PUT.extractItem(0, 1, false);
                        ITEM_OUT.insertItem(0, output, false);

                        this.markDirty();
                        this.setValue(false);
                        sendInventoryItemPacket();
                    }
                }
            }

            if (EventServerHandler.worldTick <= 500)
            {
                sendInventoryItemPacket();
            }

            if (EventHandler.tileEntityIsLoadedByChunk)
            {
                sendInventoryItemPacket();
                EventHandler.tileEntityIsLoadedByChunk = false;
            }
        }
    }

//If Lightning hit the rack
    public void setValue(boolean value)
    {
        this.runRackWithLightning = value;
    }

    public boolean getValue()
    {
        return this.runRackWithLightning;
    }


    public ItemStack getInventoryItem()
    {
        if (this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP).getStackInSlot(0).isEmpty())
        {
            return this.ITEM_OUT.extractItem(0, 1, true);
        }
        return this.ITEM_PUT.extractItem(0, 1, true);
    }
//Server send information to client
    public ItemStack clientGetInventoryItemStack()
    {
        return this.inventoryItem;
    }
    public void sendMessage()
    {
        System.out.println(1);
    }

    public void sendInventoryItemPacket()
    {
        int dimension = world.provider.getDimension();
        double x = getPos().getX();
        double y = getPos().getY();
        double z = getPos().getZ();
        NetworkLoader.instance.sendToAllAround(new MessageRack(this), new TargetPoint(dimension, x, y, z, 128D));
    }

    //
    public void receiveMessageFromServer(ItemStack receivedItemStack)
    {
        this.inventoryItem = receivedItemStack;
    }
//Capability
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
