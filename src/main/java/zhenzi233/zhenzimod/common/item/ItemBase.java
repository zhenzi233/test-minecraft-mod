package zhenzi233.zhenzimod.common.item;

import net.minecraft.item.Item;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

public class ItemBase extends Item {
    public ItemBase(){
        super();
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }
}
