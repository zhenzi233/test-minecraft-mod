package zhenzi233.zhenzimod.common.recipe.recipeutil;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class RecipeRackUtil {
    private final Map<Item, ItemStack> rackConvertItemList = Maps.newHashMap();
    public static final RecipeRackUtil RACK = new RecipeRackUtil();
    public static RecipeRackUtil instance()
    {
        return RACK;
    }

    public ItemStack getRackRecipe(Item getItemStack)
    {
        for (Map.Entry<Item, ItemStack> entry : this.rackConvertItemList.entrySet())
        {
            if (this.compareItemStack(getItemStack, entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }
    public boolean compareItemStack(Item getStack, Item input)
    {
        return getStack == input;
    }
    public void addRackRecipe(Item input, ItemStack output)
    {
        this.rackConvertItemList.put(input, output);
    }


//    public Map<Item, ItemStack> getRackConvertItemList()
//    {
//        return this.rackConvertItemList;
//    }
}
