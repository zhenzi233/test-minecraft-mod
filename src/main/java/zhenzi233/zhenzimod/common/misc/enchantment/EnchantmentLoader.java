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

                setEnchantmentName(LIGHTNING_STRIKE = enchantmentBase(2, EnumEnchantmentType.WEAPON, EntityEquipmentSlot.MAINHAND), "lightning_strike"),

        };
        event.getRegistry().registerAll(enchantments);
    }


    public static Enchantment enchantmentBase(int rarity, EnumEnchantmentType type, EntityEquipmentSlot slot)
    {
        Enchantment.Rarity rarityChoose;
        switch (rarity)
        {
            default:
                rarityChoose = Enchantment.Rarity.COMMON;
                break;
            case 1:
                rarityChoose = Enchantment.Rarity.UNCOMMON;
                break;
            case 2:
                rarityChoose = Enchantment.Rarity.RARE;
                break;
            case 3:
                rarityChoose = Enchantment.Rarity.VERY_RARE;
                break;
        }
        return new Enchantment(rarityChoose, type,
                new EntityEquipmentSlot[]
                        {slot}) {
        };
    }


    public static Enchantment setEnchantmentName(Enchantment enchantment, String name){
        enchantment.setRegistryName(ZhenziMod.MODID, name).setName(ZhenziMod.MODID + "." + name);
        return enchantment;
    }
}
