package zhenzi233.zhenzimod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.block.blocks.*;

@Mod.EventBusSubscriber(modid = ZhenziMod.MODID)
public class BlockLoader {

    /**
     * Create Block List
     */

    public static Block SUPER_CHARGED_IRON_BLOCK = null;
    public static Block GREEN_ORE_BLOCK = null;

    public static Block CHARGED_WATER_BLOCK = null;
    public static Block LIGHTNING_BLOCK = null;
    public static Block IRON_LIGHTNING_BLOCK = null;
    public static Block SCI_PULSE_FURNACE = null;
    public static Block IRON_LIGHTNING_RS_BLOCK = null;
    public static Block RACK = null;
    public static Block THUNDER_FLOWER = null;
    public static Block IRON_LIGHTNING_BLOCK_BROKEN = null;

    /**
     *
     * @param event register block list event
     */
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event)
    {
        Block[] blocks = {
                setBlockName(SUPER_CHARGED_IRON_BLOCK = new BlockBase(Material.IRON), "super_charged_iron_block"),
                setBlockName(GREEN_ORE_BLOCK = new BlockGreenOre(), "green_ore_block"),
                setBlockName(LIGHTNING_BLOCK = new BlockLightning(), "lightning_block"),
                setBlockName(IRON_LIGHTNING_BLOCK = new BlockIronLightning(), "iron_lightning_block"),
                setBlockName(SCI_PULSE_FURNACE = new BlockSCIPulseFurnace(), "sci_pulse_furnace"),
                setBlockName(IRON_LIGHTNING_RS_BLOCK = new BlockIronLightningRS(), "iron_lightning_rs_block"),
                setBlockName(RACK = new BlockRack(), "rack"),
                setBlockName(THUNDER_FLOWER = new BlockThunderFlower(), "thunder_flower"),
                setBlockName(IRON_LIGHTNING_BLOCK_BROKEN = new BlockIronLightningBroken(), "iron_lightning_block_broken"),

                setBlockName(CHARGED_WATER_BLOCK = new BlockChargedWater(), "charged_water"),


        };
        event.getRegistry().registerAll(blocks);
//        Item item = new ItemBlock(Blocks.BONE_BLOCK);
        Item item = Item.getItemFromBlock(Blocks.TORCH);
    }

    /**
     *
     * @param event registry item list from blocks event
     */

    @SubscribeEvent
    public static void registerItemFromBlock(RegistryEvent.Register<Item> event)
    {
        Item[] items = {
                setItemName(new ItemBlock(SUPER_CHARGED_IRON_BLOCK), "super_charged_iron_block"),
                setItemName(new ItemBlock(GREEN_ORE_BLOCK), "green_ore_block"),
                setItemName(new ItemBlock(LIGHTNING_BLOCK), "lightning_block"),
                setItemName(new ItemBlock(IRON_LIGHTNING_BLOCK), "iron_lightning_block"),
                setItemName(new ItemBlock(SCI_PULSE_FURNACE), "sci_pulse_furnace"),
                setItemName(new ItemBlock(IRON_LIGHTNING_RS_BLOCK), "iron_lightning_rs_block"),
                setItemName(new ItemBlock(RACK), "rack"),
                setItemName(new ItemBlock(THUNDER_FLOWER), "thunder_flower"),
                setItemName(new ItemBlock(IRON_LIGHTNING_BLOCK_BROKEN), "iron_lightning_block_broken")

        };
        event.getRegistry().registerAll(items);
    }

    /**
     * register methods
     */
    public static Block setBlockName(Block block, String name){
        block.setRegistryName(ZhenziMod.MODID, name).setUnlocalizedName(ZhenziMod.MODID + "." + name);
        return block;
    }


    public static Item setItemName(Item item, String name){
        item.setRegistryName(ZhenziMod.MODID, name).setUnlocalizedName(ZhenziMod.MODID + "." + name);
        return item;
    }
}
