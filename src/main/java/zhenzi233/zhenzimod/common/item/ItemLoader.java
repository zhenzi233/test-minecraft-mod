package zhenzi233.zhenzimod.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.item.items.*;
import zhenzi233.zhenzimod.common.misc.material.MaterialHandler;

@Mod.EventBusSubscriber(modid = ZhenziMod.MODID)
public class ItemLoader
{
    //    register Item
    public static Item GREEN_DOG = null;
    public static Item LIGHTNING_STAFF = null;
    public static Item SC_IRON_PICKAXE = null;
    public static Item SC_IRON_AXE = null;
    public static Item SC_IRON_SWORD = null;
    public static Item SC_IRON_SPADE = null;
    public static Item SC_IRON_HOE = null;
    public static Item PULSE_IMPURITY = null;
    public static Item UNSTABLE_PULSE_IMPURITY = null;
    public static Item DEBUGGING_TOOLS = null;
    public static Item SUPER_CHARGED_IRON_INGOT = null;
    public static Item PULSE_IRON_SWORD = null;
    public static Item SC_IRON_HELMET = null;
    public static Item SC_IRON_BOOT = null;
    public static Item SC_IRON_CHESTPLATE = null;
    public static Item SC_IRON_LEGGINGS = null;
    public static Item SCI_LIGHTNING_STAFF = null;
    public static Item STABLE_PULSE_INGOT = null;
    public static Item STICK_WITH_UPI = null;
    public static Item LIGHTNING_BOOK = null;
    public static Item SCROLL = null;
//    public static Item BUCKET_CHARGED_WATER = null;


    //    registerEvent
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        Item[] items = {
                setItemName(GREEN_DOG = new ItemBase(), "green_dog"),
                setItemName(LIGHTNING_STAFF = new ItemLightningStaff(), "lightning_staff"),
                setItemName(SC_IRON_PICKAXE = new ItemSCIronTools.ItemSCIronPickaxe(MaterialHandler.SCIRON_TOOL), "sc_iron_pickaxe"),
                setItemName(SC_IRON_AXE = new ItemSCIronTools.ItemSCIronAxe(MaterialHandler.SCIRON_TOOL, 9.0f, -2.9f), "sc_iron_axe"),
                setItemName(SC_IRON_HOE = new ItemSCIronTools.ItemSCIronHoe(MaterialHandler.SCIRON_TOOL), "sc_iron_hoe"),
                setItemName(SC_IRON_SPADE = new ItemSCIronTools.ItemSCIronSpade(MaterialHandler.SCIRON_TOOL), "sc_iron_spade"),
                setItemName(SC_IRON_SWORD = new ItemSCIronTools.ItemSCIronSword(MaterialHandler.SCIRON_TOOL), "sc_iron_sword"),
                setItemName(PULSE_IMPURITY = new ItemBase(), "pulse_impurity"),
                setItemName(UNSTABLE_PULSE_IMPURITY = new ItemUnstablePulseImpurity(), "unstable_pulse_impurity"),
                setItemName(DEBUGGING_TOOLS = new ItemDebuggingTools(), "debugging_tools"),
                setItemName(SUPER_CHARGED_IRON_INGOT = new ItemBase(), "super_charged_iron_ingot"),
                setItemName(PULSE_IRON_SWORD = new ItemPulseIronSword(), "pulse_iron_sword"),
                setItemName(SC_IRON_CHESTPLATE = new ItemBase(), "sc_iron_chestplate"),
                setItemName(SC_IRON_BOOT = new ItemBase(), "sc_iron_boot"),
                setItemName(SC_IRON_LEGGINGS = new ItemBase(), "sc_iron_leggings"),
                setItemName(SC_IRON_HELMET = new ItemBase(), "sc_iron_helmet"),
                setItemName(SCI_LIGHTNING_STAFF = new ItemBase(), "sci_lightning_staff"),
                setItemName(STABLE_PULSE_INGOT = new ItemBase(), "stable_pulse_ingot"),
                setItemName(STICK_WITH_UPI = new ItemBase(), "stick_with_upi"),
                setItemName(LIGHTNING_BOOK = new ItemBase(), "lightning_book"),
                setItemName(SCROLL = new ItemBase(), "scroll")
//                setItemName(BUCKET_CHARGED_WATER = new ItemBucketChargedWater(), "bucket_charged_water"),
        };
        event.getRegistry().registerAll(items);
    }



    //    register function
    public static Item setItemName(Item item, String name){
        item.setRegistryName(ZhenziMod.MODID, name).setUnlocalizedName(ZhenziMod.MODID + "." + name);
        return item;
    }


}
