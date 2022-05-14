package zhenzi233.zhenzimod.common.block.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zhenzi233.zhenzimod.ZhenziMod;

public class TileEntityLoader {

    public TileEntityLoader(FMLPreInitializationEvent event)
    {
        registerTileEntity(TileEntitySCIFurnace.class, "sci_furnace");
        registerTileEntity(TileEntityRack.class, "rack");
    }

    public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name)
    {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(ZhenziMod.MODID + ":" + name));
    }

}
