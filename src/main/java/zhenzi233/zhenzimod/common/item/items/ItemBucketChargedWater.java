package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import zhenzi233.zhenzimod.common.block.BlockLoader;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;


public class ItemBucketChargedWater extends ItemBucket {
    public ItemBucketChargedWater(){
        super(BlockLoader.CHARGED_WATER_BLOCK);
        this.setContainerItem(Items.BUCKET);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
//        .registerFluidContainer(FluidLoader.fluidMercury, new ItemStack(this),
//                FluidContainerRegistry.EMPTY_BUCKET);
    }

}
