package zhenzi233.zhenzimod.common.block.tileentity.slot;

import net.minecraftforge.items.ItemStackHandler;

public class RackSlot extends ItemStackHandler {
    public RackSlot(int size)
    {
        super(size);
    }

    @Override
    public int getSlotLimit(int slot)
    {
        return 1;
    }
    public static class TemporarySlot extends RackSlot
    {

        public TemporarySlot(int size) {
            super(size);
        }
        @Override
        public int getSlotLimit(int slot)
        {
            return 0;
        }
    }
}
