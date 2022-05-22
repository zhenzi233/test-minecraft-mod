package zhenzi233.zhenzimod.common.misc.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;

import javax.annotation.Nonnull;

public class CreativeTabZhenzi extends CreativeTabs {
    public CreativeTabZhenzi(){
        super(ZhenziMod.MODID);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(Items.BED);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel()
    {
        return "zhenzimod.creative_tab.item.label";
    }
}
