package zhenzi233.zhenzimod.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.inventory.container.ContainerSCIFurnace;
import zhenzi233.zhenzimod.common.inventory.debuggingToolGui.*;
import zhenzi233.zhenzimod.common.inventory.guiContainer.GuiContainerSCIFurnace;


public class GuiElementLoader implements IGuiHandler {
    public static final int GUI_DEMO = 1;
    public static final int GUI_DEBUG = 2;
    public static final int GUI_DEBUG_1 = 3;
    public static final int GUI_DEBUG_2 = 4;
    public static final int GUI_FURNACE = 5;

    public GuiElementLoader(){
        NetworkRegistry.INSTANCE.registerGuiHandler(ZhenziMod.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
//            case GUI_DEMO:
//                return new ContainerDemo(player);
            case GUI_DEBUG:
                return new ContainerDebugTool();
            case GUI_DEBUG_1:
                return new ContainerDebugTool1();
            case GUI_DEBUG_2:
                return new ContainerDebugToolItemStack(player);
            case GUI_FURNACE:
                return new ContainerSCIFurnace(player, world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID)
        {
//            case GUI_DEMO:
//                return new GuiContainerDemo(new ContainerDemo(player));
            case GUI_DEBUG:
                return new GuiContainerDebugTool(new ContainerDebugTool());
            case GUI_DEBUG_1:
                return new GuiContainerDebugTool1(new ContainerDebugTool1());
            case GUI_DEBUG_2:
                return new GuiContainerDebugToolItemStack(new ContainerDebugToolItemStack(player));
            case GUI_FURNACE:
                return new GuiContainerSCIFurnace(new ContainerSCIFurnace(player, world.getTileEntity(new BlockPos(x, y, z))));
            default:
                return null;
        }
    }

}
