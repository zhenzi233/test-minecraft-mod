package zhenzi233.zhenzimod.common.block.tileentity.slot;

import net.minecraftforge.items.ItemStackHandler;

public class RackSlot extends ItemStackHandler {
    public RackSlot()
    {
        super();
    }

    @Override
    public int getSlotLimit(int slot)
    {
        return 1;
    }
}
