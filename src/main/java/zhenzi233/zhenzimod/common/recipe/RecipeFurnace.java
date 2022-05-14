package zhenzi233.zhenzimod.common.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zhenzi233.zhenzimod.common.item.ItemLoader;


public class RecipeFurnace {

    public static void registerSmelting()
    {
        GameRegistry.addSmelting(ItemLoader.PULSE_IMPURITY, new ItemStack(ItemLoader.UNSTABLE_PULSE_IMPURITY), 1F);
    }
}
