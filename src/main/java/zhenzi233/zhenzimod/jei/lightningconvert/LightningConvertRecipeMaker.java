//package zhenzi233.zhenzimod.jei.lightningconvert;
//
//import mezz.jei.api.IJeiHelpers;
//import mezz.jei.api.recipe.IStackHelper;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.FurnaceRecipes;
//import zhenzi233.zhenzimod.common.event.EventLightningConvert;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class LightningConvertRecipeMaker {
//    private LightningConvertRecipeMaker()
//    {
//
//    }
//    public static List<LightningConvertRecipeWrapper> getRecipe(IJeiHelpers helpers)
//    {
//        IStackHelper stackHelper = helpers.getStackHelper();
//        EventLightningConvert convertRecipe = EventLightningConvert.instance();
//        Map<ItemStack, ItemStack> smeltingMap = convertRecipe.getConvertListItem();
//
//        List<LightningConvertRecipeWrapper> recipes = new ArrayList<>();
//
//        for (Map.Entry<ItemStack, ItemStack> entry : smeltingMap.entrySet()) {
//            ItemStack input = entry.getKey();
//            ItemStack output = entry.getValue();
//
//            List<ItemStack> inputs = stackHelper.getSubtypes(input);
//            LightningConvertRecipeWrapper recipe = new LightningConvertRecipeWrapper(inputs, output);
//            recipes.add(recipe);
//        }
//
//        return recipes;
//    }
//}
