package zhenzi233.zhenzimod.common.block.blocks;

import net.minecraftforge.fluids.BlockFluidClassic;
import zhenzi233.zhenzimod.common.misc.fluid.FluidLoader;
import zhenzi233.zhenzimod.common.misc.material.MaterialHandler;


public class BlockChargedWater extends BlockFluidClassic {
    public BlockChargedWater(){
        super(FluidLoader.CHARGED_WATER, MaterialHandler.CHARGED_WATER);
    }
}
