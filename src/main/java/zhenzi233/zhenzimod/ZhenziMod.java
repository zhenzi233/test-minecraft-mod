package zhenzi233.zhenzimod;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import zhenzi233.zhenzimod.client.KeyLoader;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityLoader;
import zhenzi233.zhenzimod.common.capability.CapablityLoader;
import zhenzi233.zhenzimod.common.entity.EntityLoader;
import zhenzi233.zhenzimod.common.entity.render.RenderLoader;
import zhenzi233.zhenzimod.common.event.EventHandler;
import zhenzi233.zhenzimod.common.event.EventLightningConvert;
import zhenzi233.zhenzimod.common.inventory.GuiElementLoader;
//import zhenzi233.zhenzimod.common.misc.command.CommandLoader;
import zhenzi233.zhenzimod.common.misc.command.CommandLoader;
import zhenzi233.zhenzimod.common.misc.config.ConfigHandler;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;
import zhenzi233.zhenzimod.common.misc.fluid.FluidLoader;
import zhenzi233.zhenzimod.common.network.NetworkLoader;
import zhenzi233.zhenzimod.common.proxy.ProxyBase;
import zhenzi233.zhenzimod.common.recipe.RecipeFurnace;
import zhenzi233.zhenzimod.common.recipe.RecipeLightningConvertBlock;
import zhenzi233.zhenzimod.common.recipe.RecipeRack;
import zhenzi233.zhenzimod.common.util.Reference;
import zhenzi233.zhenzimod.common.world.WorldGenLoader;

@Mod(modid = ZhenziMod.MODID, name = ZhenziMod.NAME, version = ZhenziMod.VERSION, acceptedMinecraftVersions = ZhenziMod.MC_VERSION)
public class ZhenziMod
{


    public static final String MODID = "zhenzimod";
    public static final String NAME = "Zhenzi Mod";
    public static final String VERSION = "1.0.0";
    public static final String MC_VERSION = "[1.12.2]";

    public static Logger logger;

    @Mod.Instance(ZhenziMod.MODID)
    public static ZhenziMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static ProxyBase proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        logger.info(ZhenziMod.MODID + ":" + "Starting loading config");
        ConfigHandler.configLoad(event.getSuggestedConfigurationFile());
        logger.info(ZhenziMod.MODID + ":" + "Finished loading config");

        new CapablityLoader(event);
//
        new CreativeTabLoader(event);
//
        new FluidLoader(event);

        new EntityLoader();

        new TileEntityLoader(event);

        if (!proxy.isServer())
        {
            new RenderLoader();
        }

        new NetworkLoader(event);


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (!proxy.isServer()){
            new KeyLoader();
        }

        new EventHandler();

        new EventLightningConvert();


        new WorldGenLoader();

        RecipeFurnace.registerSmelting();
        RecipeLightningConvertBlock.addRecipe();
        RecipeRack.addRecipe();

        new GuiElementLoader();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        new CommandLoader(event);
    }

    public ZhenziMod(){
        FluidRegistry.enableUniversalBucket();
    }


}
