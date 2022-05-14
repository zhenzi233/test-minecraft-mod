package zhenzi233.zhenzimod.common.misc.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabLoader {
    public static CreativeTabs tabZhenziMod;
    public CreativeTabLoader(FMLPreInitializationEvent event){
        tabZhenziMod = new CreativeTabZhenzi();
    }
}
