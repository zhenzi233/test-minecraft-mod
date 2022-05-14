package zhenzi233.zhenzimod.common.misc.fluid;

//import net.minecraft.block.state.IBlockState;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.client.renderer.block.statemap.StateMapperBase;
//import net.minecraft.item.Item;
//import net.minecraftforge.client.model.ModelLoader;
//import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import zhenzi233.zhenzimod.ZhenziMod;
//import zhenzi233.zhenzimod.block.BlockLoader;


public class FluidLoader {
    public static Fluid CHARGED_WATER = new FluidChargedWater();

    public FluidLoader(FMLPreInitializationEvent event)
    {
//        if (FluidRegistry.isFluidRegistered(CHARGED_WATER))
//        {
//            event.getModLog().info("Found fluid {}, the registration is canceled. ", CHARGED_WATER.getName());
//            CHARGED_WATER = FluidRegistry.getFluid(CHARGED_WATER.getName());
//        }
//        else
//        {
            FluidRegistry.registerFluid(CHARGED_WATER);

            FluidRegistry.addBucketForFluid(CHARGED_WATER);
//        }
    }


//    @SideOnly(Side.CLIENT)
//    public static void registerRenders()
//    {
//        registerFluidRender((BlockFluidBase) BlockLoader.CHARGED_WATER_BLOCK, "fluid_charged_water");
//    }
//
//
//    @SideOnly(Side.CLIENT)
//    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
//    {
//        final String location = ZhenziMod.MODID + ":" + blockStateName;
//        final Item itemFluid = Item.getItemFromBlock(blockFluid);
//        ModelLoader.setCustomMeshDefinition(itemFluid, stack -> new ModelResourceLocation(location, "fluid"));
//        ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
//        {
//            @Override
//            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
//            {
//                return new ModelResourceLocation(location, "fluid");
//            }
//        });
//    }
}
