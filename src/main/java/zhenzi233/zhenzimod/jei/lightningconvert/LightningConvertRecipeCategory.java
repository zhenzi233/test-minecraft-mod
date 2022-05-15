package zhenzi233.zhenzimod.jei.lightningconvert;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.jei.LightningRecipeCategoryUid;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class LightningConvertRecipeCategory implements IRecipeCategory<LightningConvertRecipeWrapper> {
    private final IDrawable background;
    private final String localizedName;
    private final IDrawable icon;
    private final String RESOURCE_NAME = ZhenziMod.MODID + ":" + "textures/gui/jei.png";
    private final ResourceLocation iconResource = new ResourceLocation(RESOURCE_NAME);

    public LightningConvertRecipeCategory(IGuiHelper guiHelper) {
        super();
//        background = guiHelper.createBlankDrawable(142, 55);
        background = guiHelper.createDrawable(iconResource, 0, 16, 82, 54);
        localizedName = I18n.format("jei.zhenzimod.lightning_convert.name");
        icon = guiHelper.createDrawable(iconResource, 0, 0, 16, 16);
    }
    @Nonnull
    @Override
    public String getUid() {
        return LightningRecipeCategoryUid.LIGHTNING_CONVERT;
    }
    @Nonnull
    @Override
    public String getTitle() {
        return localizedName;
    }
    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }
    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;
    }
    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull LightningConvertRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        int inputSlot = 0;
        int outputSlot = 1;
        recipeLayout.getItemStacks().init(inputSlot, true, 6, 18);
        recipeLayout.getItemStacks().init(outputSlot, false, 58, 18);
        recipeLayout.getItemStacks().set(ingredients);
    }
    @Nonnull
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return new ArrayList<>();
    }
    @Nonnull
    @Override
    public String getModName() {
        return ZhenziMod.MODID;
    }

}
