package zhenzi233.zhenzimod.client;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityRack;
import zhenzi233.zhenzimod.common.block.tileentity.runutil.RenderTileEntityRack;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityUnstablePulseImpurity;
import zhenzi233.zhenzimod.common.entity.render.RenderUnstablePulseImpurity;
import zhenzi233.zhenzimod.common.item.ItemLoader;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ZhenziMod.MODID)
public class ModelLoader {
    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
        registerItemModel(ItemLoader.GREEN_DOG, 0);
        registerItemModel(ItemLoader.LIGHTNING_STAFF, 0);
        registerItemModel(ItemLoader.SC_IRON_SWORD, 0);
        registerItemModel(ItemLoader.SC_IRON_PICKAXE, 0);
        registerItemModel(ItemLoader.SC_IRON_SPADE, 0);
        registerItemModel(ItemLoader.SC_IRON_HOE, 0);
        registerItemModel(ItemLoader.SC_IRON_AXE, 0);
//        registerItemModel(ItemLoader.BUCKET_CHARGED_WATER, 0);
        registerItemModel(ItemLoader.UNSTABLE_PULSE_IMPURITY, 0);
        registerItemModel(ItemLoader.PULSE_IMPURITY, 0);
        registerItemModel(ItemLoader.DEBUGGING_TOOLS, 0);
        registerItemModel(ItemLoader.SUPER_CHARGED_IRON_INGOT, 0);
        registerItemModel(ItemLoader.STICK_WITH_UPI, 0);
        registerItemModel(ItemLoader.SC_IRON_CHESTPLATE, 0);
        registerItemModel(ItemLoader.STABLE_PULSE_INGOT, 0);
        registerItemModel(ItemLoader.SCI_LIGHTNING_STAFF, 0);
        registerItemModel(ItemLoader.SC_IRON_HELMET, 0);
        registerItemModel(ItemLoader.SC_IRON_LEGGINGS, 0);
        registerItemModel(ItemLoader.SC_IRON_BOOT, 0);
        registerItemModel(ItemLoader.PULSE_IRON_SWORD, 0);
        registerItemModel(ItemLoader.LIGHTNING_BOOK, 0);
        registerItemModel(ItemLoader.SCROLL, 0);

        registerBlockModel(BlockLoader.SUPER_CHARGED_IRON_BLOCK, 0);
        registerBlockModel(BlockLoader.GREEN_ORE_BLOCK, 0);
        registerBlockModel(BlockLoader.LIGHTNING_BLOCK, 0);
        registerBlockModel(BlockLoader.IRON_LIGHTNING_BLOCK, 0);
        registerBlockModel(BlockLoader.SCI_PULSE_FURNACE, 0);
        registerBlockModel(BlockLoader.IRON_LIGHTNING_RS_BLOCK, 0);
        registerBlockModel(BlockLoader.RACK, 0);
        registerBlockModel(BlockLoader.THUNDER_FLOWER, 0);
        registerBlockModel(BlockLoader.IRON_LIGHTNING_BLOCK_BROKEN, 0);

        registerFluidRender((BlockFluidBase) BlockLoader.CHARGED_WATER_BLOCK, "fluid_charged_water");

        RenderingRegistry.registerEntityRenderingHandler(EntityUnstablePulseImpurity.class, RenderUnstablePulseImpurity::new);

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRack.class, new RenderTileEntityRack());
    }


    public static void registerItemModel(Item item, int meta) {
        net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerBlockModel(Block block, int meta) {
        net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
    {
        final String location = ZhenziMod.MODID + ":" + blockStateName;
        final Item itemFluid = Item.getItemFromBlock(blockFluid);
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(itemFluid, stack -> new ModelResourceLocation(location, "fluid"));
        net.minecraftforge.client.model.ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(location, "fluid");
            }
        });
    }

//    public static void registerEntityRender()


}
