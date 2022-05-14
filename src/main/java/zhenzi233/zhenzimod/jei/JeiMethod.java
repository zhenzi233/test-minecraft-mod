package zhenzi233.zhenzimod.jei;

import mezz.jei.api.IModRegistry;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JeiMethod {

    /**
     *  Description of Item
     */
    public void addDescriptionOfItem(IModRegistry registry, Item item, String... key)
    {
        registry.addIngredientInfo(new ItemStack(item), VanillaTypes.ITEM, key);
    }
}
