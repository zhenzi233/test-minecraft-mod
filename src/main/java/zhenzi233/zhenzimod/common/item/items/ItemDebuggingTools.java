package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.inventory.GuiElementLoader;
import zhenzi233.zhenzimod.common.item.ItemBase;


public class ItemDebuggingTools extends ItemBase {
    public ItemDebuggingTools(){
        super();
        this.maxStackSize = 1;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote)
        {
            BlockPos pos = playerIn.getPosition();
            playerIn.openGui(ZhenziMod.instance, GuiElementLoader.GUI_DEBUG, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
