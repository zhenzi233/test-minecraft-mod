package zhenzi233.zhenzimod.common.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.recipe.recipeutil.RecipeRackUtil;

public class RecipeRack {



    public static void addRecipe()
    {
        addRackRecipeItem(Items.IRON_INGOT, ItemLoader.SUPER_CHARGED_IRON_INGOT);
        addRackRecipeItem(Item.getItemFromBlock(Blocks.RED_FLOWER), Item.getItemFromBlock(BlockLoader.THUNDER_FLOWER));
        addRackRecipeItem(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), Item.getItemFromBlock(BlockLoader.THUNDER_FLOWER));
        addRackRecipeItem(Item.getItemFromBlock(Blocks.SAPLING), Item.getItemFromBlock(Blocks.DEADBUSH));
        addRackRecipeItem(Item.getItemFromBlock(Blocks.IRON_BLOCK), Item.getItemFromBlock(BlockLoader.SUPER_CHARGED_IRON_BLOCK));

    }
    public static void addRackRecipeItem(Item input, Item output)
    {
        RecipeRackUtil.instance().addRackRecipe(input, new ItemStack(output));
    }


}
