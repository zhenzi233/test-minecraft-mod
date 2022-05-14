package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ItemSlot extends Slot {
    public ItemSlot(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }
}
