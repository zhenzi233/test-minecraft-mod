package zhenzi233.zhenzimod.common.misc.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import zhenzi233.zhenzimod.ZhenziMod;

public class FluidChargedWater extends Fluid {

    public static final ResourceLocation still = new ResourceLocation(
            ZhenziMod.MODID + ":" + "blocks/charged_water_still"
    );
    public static final ResourceLocation flowing = new ResourceLocation(
            ZhenziMod.MODID + ":" + "blocks/charged_water_flowing"
    );

    public FluidChargedWater(){
        super("charged_water", still, flowing);
        this.setUnlocalizedName(ZhenziMod.MODID + "." + "charged_water");
        this.setDensity(3000); //密度
        this.setViscosity(3000); //粘度
        this.setLuminosity(6); // 亮度
        this.setTemperature(300);
        this.setGaseous(false);
    }
}
