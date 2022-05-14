package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import zhenzi233.zhenzimod.common.item.ItemLoader;

public class ContainerDebugToolItemStack extends Container {
    private ItemStackHandler item = new ItemStackHandler(1);
    private Slot putItem;
//    public int gainNum = 0;
//    public GuiContainerDebugToolItemStack guiContainerDebugToolItemStack;
    public ContainerDebugToolItemStack(EntityPlayer player)
    {
        super();
        this.addSlotToContainer(this.putItem = new SlotItemHandler(item, 0, 78, 24));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 10, 8 + j * 18, 84 + i * 18)
                {
                    @Override
                    public boolean canTakeStack(EntityPlayer playerIn)
                    {
                        return !this.getStack().getItem().equals(ItemLoader.DEBUGGING_TOOLS);
                    }
                });
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i + 1, 8 + i * 18, 142)
            {
                @Override
                public boolean canTakeStack(EntityPlayer playerIn)
                {
                    return !this.getStack().getItem().equals(ItemLoader.DEBUGGING_TOOLS);
                }
            });
        }
    }

//    @SideOnly(Side.CLIENT)
//    @Override
//    public void updateProgressBar(int id, int data)
//    {
//
//    }


    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (playerIn.isServerWorld())
        {
            ItemStack putStack = this.putItem.getStack();
            if (!putStack.isEmpty())
            {
                EntityItem item1 = playerIn.dropItem(putStack, true);
                World world = playerIn.world;
                world.spawnEntity(item1);

                System.out.println(putStack);
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return new ItemStack(ItemLoader.DEBUGGING_TOOLS).isItemEqual(playerIn.getHeldItemMainhand());
    }

}
