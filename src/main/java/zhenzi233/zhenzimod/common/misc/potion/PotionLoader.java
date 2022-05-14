package zhenzi233.zhenzimod.common.misc.potion;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.ZhenziMod;

@Mod.EventBusSubscriber(modid = ZhenziMod.MODID)
public class PotionLoader {
    public static Potion THUNDER_KING = null;

    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event)
    {
        Potion[] potions = {
                setPotionName(THUNDER_KING = new PotionThunderKing(), "thunder_king"),
        };
        event.getRegistry().registerAll(potions);
    }

    public static Potion setPotionName(Potion potion, String name){
        potion.setRegistryName(ZhenziMod.MODID, name);
        return potion;
    }



}
