package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.item.ItemBase;
import zhenzi233.zhenzimod.common.misc.config.ConfigHandler;


import javax.annotation.Nonnull;

public class ItemLightningStaff extends ItemBase {
    public int damage;
    public ItemLightningStaff(int damage){
        super();
        this.damage = damage;
        this.maxStackSize = 1;
        if (damage != -1)
        {
            this.setMaxDamage(damage);
        }
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ){
//        world.isRemote()通常用来判断世界是否在客户端连接的服务器上，或者它是否在运行 Minecraft 的计算机上（客户端）。
        if (ConfigHandler.switchLightningStaff){
            if(!world.isRemote){
                ItemStack stack = player.getHeldItem(hand);
                world.addWeatherEffect(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false));
                if (damage != -1)
                {
                    stack.damageItem(1, player);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }
}
