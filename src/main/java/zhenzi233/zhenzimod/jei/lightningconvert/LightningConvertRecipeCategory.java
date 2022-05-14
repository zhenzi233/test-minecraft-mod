//package zhenzi233.zhenzimod.jei.lightningconvert;
//
//import mezz.jei.api.IGuiHelper;
//import mezz.jei.api.gui.IDrawable;
//import mezz.jei.api.gui.IRecipeLayout;
//import mezz.jei.api.ingredients.IIngredients;
//import mezz.jei.api.ingredients.VanillaTypes;
//import mezz.jei.api.recipe.IRecipeCategory;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.resources.I18n;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import zhenzi233.zhenzimod.ZhenziMod;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LightningConvertRecipeCategory implements IRecipeCategory<LightningConvertRecipeWrapper> {
//    public static final String UID = "Lightning Convert";
//    private final IDrawable background;
//    private final String localizedName;
//
//    public LightningConvertRecipeCategory(IGuiHelper guiHelper) {
//        background = guiHelper.createBlankDrawable(142, 55);
//        localizedName = I18n.format("botania.nei.manaPool");
//    }
//
//    @Nonnull
//    @Override
//    public String getUid() {
//        return UID;
//    }
//
//    @Nonnull
//    @Override
//    public String getTitle() {
//        return localizedName;
//    }
//
//    @Nonnull
//    @Override
//    public IDrawable getBackground() {
//        return background;
//    }
//
//    @Nullable
//    @Override
//    public IDrawable getIcon() {
//        return null;
//    }
//
//    @Override
//    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull LightningConvertRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
//        int index = 0;
//
//        recipeLayout.getItemStacks().init(index, true, 32, 12);
//        recipeLayout.getItemStacks().set(index, ingredients.getInputs(VanillaTypes.ITEM).get(0));
//
//        index++;
//
//        if(ingredients.getInputs(VanillaTypes.ITEM).size() > 1) {
//            // Has catalyst
//            recipeLayout.getItemStacks().init(index, true, 12, 12);
//            recipeLayout.getItemStacks().set(index, ingredients.getInputs(VanillaTypes.ITEM).get(1));
//            index++;
//        }
//
//
//        recipeLayout.getItemStacks().init(index, false, 93, 12);
//        recipeLayout.getItemStacks().set(index, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
//    }
//
//    @Nonnull
//    @Override
//    public List<String> getTooltipStrings(int mouseX, int mouseY) {
//        return new ArrayList<>();
//    }
//
//    @Nonnull
//    @Override
//    public String getModName() {
//        return ZhenziMod.MODID;
//    }
//
//}
