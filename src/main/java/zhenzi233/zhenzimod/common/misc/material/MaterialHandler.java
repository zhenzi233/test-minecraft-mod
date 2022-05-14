package zhenzi233.zhenzimod.common.misc.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import zhenzi233.zhenzimod.ZhenziMod;

public class MaterialHandler {

    public static final Item.ToolMaterial SCIRON_TOOL = EnumHelper.addToolMaterial(
            ZhenziMod.MODID + ":" + "sciron_tool", 2, 450, 7.5f, 2.5f, 20);
    public static final ItemArmor.ArmorMaterial SCIRON_ARMOR = EnumHelper.addArmorMaterial(
            ZhenziMod.MODID + ":" +"sciron_armor", ZhenziMod.MODID + ":sciron",
            27, new int[]{2,5,7,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.75f);

    public static final Material SCIRON = new Material(MapColor.IRON);
    public static final Material CHARGED_WATER = new MaterialLiquid(MapColor.WATER);
}
