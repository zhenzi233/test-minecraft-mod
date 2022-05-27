package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import zhenzi233.zhenzimod.common.block.tileentity.slot.RackSlot;
import zhenzi233.zhenzimod.common.event.EventHandler;
import zhenzi233.zhenzimod.common.event.EventServerHandler;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.network.MessageRack;
import zhenzi233.zhenzimod.common.network.NetworkLoader;
import zhenzi233.zhenzimod.common.recipe.recipeutil.RecipeRackUtil;

import javax.annotation.Nonnull;
import java.util.List;


public class TileEntityRack extends TileEntityBase implements ITickable {


    public ItemStackHandler ITEM_PUT = new RackSlot(1);
    public ItemStackHandler ITEM_OUT = new RackSlot(1);
    public ItemStackHandler temporary = new RackSlot.TemporarySlot(1);
    RecipeRackUtil recipeRackUtil = RecipeRackUtil.instance();
    public boolean runRackWithLightning = false;
    ItemStack inventoryItem = ItemStack.EMPTY;
    public boolean SlotTouched = false;

    public ItemStack itemStackCache1;
    public ItemStack itemStackCache2;
    public TileEntityRack()
    {
        this.itemStackCache1 = ItemStack.EMPTY;
        this.itemStackCache2 = ItemStack.EMPTY;
    }

    @Override
    public void update()
    {
        if (!world.isRemote)
        {
            ItemStack stack = ITEM_PUT.extractItem(0, 1, true);
            Item item = stack.getItem();
            ItemStack output = recipeRackUtil.getRackRecipe(item);

            convertRecipe(stack, output);

            autoRefreshRender(stack);

            refreshTileEntityRender();

            if (stack.isEmpty())
            {
                if(pullDropItem(this.world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()))
                {
                    sendInventoryItemPacket();
                    this.markDirty();
                }
            }
        }
    }
    public boolean pullDropItem(World world, double x, double y, double z)
    {
        for (EntityItem entityItem : getEntityItemList(world, x, y, z))
        {
            ItemStack entityStack = entityItem.getItem();
            if (entityStack.getCount() > 1)
            {
                ITEM_PUT.insertItem(0, entityStack, false);
                entityItem.getItem().shrink(1);
                return true;
            }   else {
                ITEM_PUT.insertItem(0, entityStack, false);
                entityItem.setDead();
                return true;
            }
        }
        return false;
    }

    public static List<EntityItem> getEntityItemList(World worldIn, double x, double y, double z)
    {
        return worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x, y + 0.3D, z, x + 1D, y + 0.7D, z + 1D), EntitySelectors.IS_ALIVE);
    }
    public void convertRecipe(ItemStack stack, ItemStack output)
    {
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
    }
    public void autoRefreshRender(ItemStack getItemStack)
    {
        this.itemStackCache1 = getItemStack;
        if (this.itemStackCache2 != this.itemStackCache1)
        {
            this.SlotTouched = true;

            sendInventoryItemPacket();
            this.markDirty();
        }
        if (SlotTouched)
        {
            this.itemStackCache2 = this.itemStackCache1;
            this.SlotTouched = false;
            this.markDirty();
        }
        this.markDirty();
    }
    public void refreshTileEntityRender()
    {
        if (EventServerHandler.worldTick <= 500)
        {
            sendInventoryItemPacket();
            this.markDirty();
        }

        if (EventHandler.tileEntityIsLoadedByChunk)
        {
            sendInventoryItemPacket();
            this.markDirty();
            EventHandler.tileEntityIsLoadedByChunk = false;
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

    public ItemStack getOutputItem()
    {
        return this.ITEM_OUT.extractItem(0, 1, true);
    }

    public ItemStack getInputItem()
    {
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

            if (!ITEM_OUT.extractItem(0, 1, true).isEmpty())
            {
                @SuppressWarnings("unchecked")
                T result;
                if (facing == EnumFacing.DOWN)
                {
                    result = (T) ITEM_OUT;
                }   else result = (T) temporary;
                return result;
            }   else {
                @SuppressWarnings("unchecked")
                T result;
                if (facing == EnumFacing.DOWN) {
                    result = (T) ITEM_OUT;
                } else result = (T) ITEM_PUT;
                return result;
            }

            // return your IItemHandler
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
