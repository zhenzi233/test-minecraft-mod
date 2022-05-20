package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBase extends TileEntity {
    public ItemStackHandler itemStackHandler = new ItemStackHandler();
    public IItemHandlerModifiable getItemHandler()
    {
        return itemStackHandler;
    }
}
