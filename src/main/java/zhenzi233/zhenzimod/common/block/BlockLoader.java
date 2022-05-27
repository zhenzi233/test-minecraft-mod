package zhenzi233.zhenzimod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.block.blocks.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = ZhenziMod.MODID)
public class BlockLoader {

    public static List<Block> blockList = new ArrayList<>();
    public static List<Item> itemBlockList = new ArrayList<>();

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

        };

        Block[] notNeedItemOfBlocks =
                {

                        setBlockName(CHARGED_WATER_BLOCK = new BlockChargedWater(), "charged_water"),

                };

        blockList.addAll(Arrays.asList(blocks));

        event.getRegistry().registerAll(blocks);
        event.getRegistry().registerAll(notNeedItemOfBlocks);

        for (Block block : blockList) {
            itemBlockList.add(setItemName(block));
        }
    }

    /**
     *
     * @param event registry item list from blocks event
     */

    @SubscribeEvent
    public static void registerItemFromBlock(RegistryEvent.Register<Item> event)
    {
        for (Item item : itemBlockList) {
            event.getRegistry().register(item);
        }
    }

    /**
     * register methods
     */
    public static Block setBlockName(Block block, String name){
        block.setRegistryName(ZhenziMod.MODID, name).setUnlocalizedName(ZhenziMod.MODID + "." + name);
        return block;
    }


    public static Item setItemName(Block block){
        return new ItemBlock(block).setRegistryName(ZhenziMod.MODID, block.getUnlocalizedName()).setUnlocalizedName(block.getUnlocalizedName());
    }

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
}
