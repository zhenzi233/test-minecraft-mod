//package zhenzi233.zhenzimod.jei.lightningconvert;
//
//
//import mezz.jei.api.ingredients.IIngredients;
//import mezz.jei.api.ingredients.VanillaTypes;
//import mezz.jei.api.recipe.IRecipeWrapper;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.FontRenderer;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.FurnaceRecipes;
//import zhenzi233.zhenzimod.common.event.EventLightningConvert;
//
//import java.awt.*;
//import java.util.Collections;
//import java.util.List;
//
//public class LightningConvertRecipeWrapper implements IRecipeWrapper {
//    public List<List<ItemStack>> inputs;
//    public ItemStack output;
//
//    public LightningConvertRecipeWrapper(List<ItemStack> inputs, ItemStack output)
//    {
//        this.inputs = Collections.singletonList(inputs);
//        this.output = output;
//    }
//
//    @Override
//    public void getIngredients(IIngredients ingredients) {
//        ingredients.setInputLists(VanillaTypes.ITEM, inputs);
//        ingredients.setOutput(VanillaTypes.ITEM, output);
//    }
//
//    @Override
//    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
//    }
//}
