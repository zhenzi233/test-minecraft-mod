package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityUnstablePulseImpurity;
import zhenzi233.zhenzimod.common.item.ItemBase;
import zhenzi233.zhenzimod.common.misc.config.ConfigHandler;

public class ItemUnstablePulseImpurity extends ItemBase {
    public ItemUnstablePulseImpurity(){
        super();
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (ConfigHandler.swithcUnstablePulseImpurityThrew){
        ItemStack stack = player.getHeldItem(hand);
        if (!player.capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }
        if (!world.isRemote)
        {
            EntityUnstablePulseImpurity unstablePulseImpurity = new EntityUnstablePulseImpurity(world, player);
            unstablePulseImpurity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.0F, 1.0F);
            world.spawnEntity(unstablePulseImpurity);
        }
    }
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }
}
