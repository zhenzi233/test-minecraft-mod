package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zhenzi233.zhenzimod.common.item.ItemLoader;

public class ContainerDebugTool1 extends Container {
    public int value = 0;

    public ContainerDebugTool1()
    {
        super();
    }

    @Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendWindowProperty(this, 1, value);
    }


    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

//        GuiContainerDebugTool1 containerDebugTool1 = listeners.

        for (IContainerListener icontainerlistener : this.listeners) {
            icontainerlistener.sendWindowProperty(this, 0, value);
            if (value == 1)
            {
                System.out.println(1);
                value = 2;
//                Item item = new Item().block
            }
        }


    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return new ItemStack(ItemLoader.DEBUGGING_TOOLS).isItemEqual(playerIn.getHeldItemMainhand());
    }

}
