package zhenzi233.zhenzimod.jei;

import mezz.jei.api.*;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.jei.lightningconvert.LightningConvertRecipeCategory;
import zhenzi233.zhenzimod.jei.lightningconvert.LightningConvertRecipeMaker;

@JEIPlugin
public class JeiLightningPlugin implements IModPlugin {

    public JeiMethod zhenzi = new JeiMethod();

    /**
     * waiting for the future
     */
//    @Override
//    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry)
//    {
//
//    }
//
//    @Override
//    public void registerIngredients(IModIngredientRegistration registry) {
//
//    }
//
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registry.addRecipeCategories(
                new LightningConvertRecipeCategory(guiHelper)
        );

    }

    @Override
    public void register(IModRegistry registry)
    {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        zhenzi.addDescriptionOfItem(registry, ItemLoader.GREEN_DOG, "jei.zhenzimod.green_dog_title", "jei.zhenzimod.green_dog_describe");
        registry.addRecipes(LightningConvertRecipeMaker.getRecipe(jeiHelpers), LightningRecipeCategoryUid.LIGHTNING_CONVERT);

    }
}
