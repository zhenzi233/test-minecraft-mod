package zhenzi233.zhenzimod.common.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntitySCIFurnace;
import zhenzi233.zhenzimod.common.item.ItemLoader;

public class ContainerSCIFurnace extends Container {
    private IItemHandler upItem;
    private IItemHandler downItem;
    protected TileEntitySCIFurnace tileEntitySCIFurnace;
    protected int burnTime = 0;
    public ContainerSCIFurnace(EntityPlayer player, TileEntity tileEntity)
    {
        super();

        this.tileEntitySCIFurnace = (TileEntitySCIFurnace) tileEntity;

        this.upItem = this.tileEntitySCIFurnace.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        this.downItem = this.tileEntitySCIFurnace.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

        this.addSlotToContainer(new SlotItemHandler(this.upItem, 0, 44, 37));
        this.addSlotToContainer(new SlotItemHandler(this.downItem, 0, 115, 37)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 11, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i + 2, 8 + i * 18, 142));
        }

    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        this.burnTime = tileEntitySCIFurnace.getBurnTime();

        for (IContainerListener i : this.listeners)
        {
//            i.sendProgressBarUpdate(this, 0, this.burnTime);
            i.sendWindowProperty(this, 0, this.burnTime);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data)
    {
        super.updateProgressBar(id, data);

        switch (id)
        {
            case 0:
                this.burnTime = data;
                break;
            default:
                break;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
//        Slot slot = inventorySlots.get(index);
//
//        if (slot == null || !slot.getHasStack())
//        {
//            return null;
//        }
//
//        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();
//
//        boolean isMerged = false;
//
//        if (index == 0 || index == 2)
//        {
//            isMerged = mergeItemStack(newStack, 4, 40, true);
//        }
//        else if (index >= 4 && index < 31)
//        {
//            isMerged = !goldSlot.getHasStack() && newStack.stackSize <= 16 && mergeItemStack(newStack, 0, 1, false)
//                    || !emeraldSlot.getHasStack() && mergeItemStack(newStack, 2, 3, false)
//                    || mergeItemStack(newStack, 31, 40, false);
//        }
//        else if (index >= 31 && index < 40)
//        {
//            isMerged = !goldSlot.getHasStack() && newStack.stackSize <= 16 && mergeItemStack(newStack, 0, 1, false)
//                    || !emeraldSlot.getHasStack() && mergeItemStack(newStack, 2, 3, false)
//                    || mergeItemStack(newStack, 4, 31, false);
//        }
//
//        if (!isMerged)
//        {
//            return null;
//        }
//
//        if (newStack.getMaxStackSize() == 0)
//        {
//            slot.putStack(null);
//        }
//        else
//        {
//            slot.onSlotChanged();
//        }
//
////        slot.onPickupFromSlot(playerIn, newStack);
//        slot.onTake(playerIn, newStack);
//
//        return oldStack;
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return playerIn.getDistanceSq(this.tileEntitySCIFurnace.getPos()) <= 64;
    }

    public int getBurnTime()
    {
        return this.burnTime;
    }

    public int getTotalBurnTime()
    {
        return this.tileEntitySCIFurnace.getTotalBurnTime();
    }
    public ItemStack getStackFromSlot()
    {
        return this.inventorySlots.get(0).getStack();
    }
}
