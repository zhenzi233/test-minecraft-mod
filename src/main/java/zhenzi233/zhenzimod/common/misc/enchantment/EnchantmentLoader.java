package zhenzi233.zhenzimod.common.misc.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.ZhenziMod;

@Mod.EventBusSubscriber(modid = ZhenziMod.MODID)
public class EnchantmentLoader {
    public static Enchantment LIGHTNING_STRIKE = null;

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event)
    {
        Enchantment[] enchantments = {
               setEnchantmentName(LIGHTNING_STRIKE = new Enchantment(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]
                       {EntityEquipmentSlot.MAINHAND}) {

               }, "lightning_strike"),
        };
        event.getRegistry().registerAll(enchantments);
    }


    public static Enchantment setEnchantmentName(Enchantment enchantment, String name){
        enchantment.setRegistryName(ZhenziMod.MODID, name).setName(name);
        return enchantment;
    }
}
