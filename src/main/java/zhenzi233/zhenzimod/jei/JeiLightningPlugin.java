package zhenzi233.zhenzimod.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import zhenzi233.zhenzimod.common.item.ItemLoader;

@JEIPlugin
public class JeiLightningPlugin implements IModPlugin {

    public JeiMethod zhenzi = new JeiMethod();

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
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registry) {
//
//    }

    @Override
    public void register(IModRegistry registry)
    {
        zhenzi.addDescriptionOfItem(registry, ItemLoader.GREEN_DOG, "jei.zhenzimod.green_dog_title", "jei.zhenzimod.green_dog_describe");
    }

//    @Override
//    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
//
//    }

}
