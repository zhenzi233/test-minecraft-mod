package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import zhenzi233.zhenzimod.common.item.ItemLoader;

public class ContainerDebugTool extends Container {
    public ContainerDebugTool()
    {
        super();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return new ItemStack(ItemLoader.DEBUGGING_TOOLS).isItemEqual(playerIn.getHeldItemMainhand());
    }
}
