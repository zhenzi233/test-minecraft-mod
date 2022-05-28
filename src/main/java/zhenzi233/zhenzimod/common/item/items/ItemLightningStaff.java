package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.item.ItemBase;
import zhenzi233.zhenzimod.common.misc.config.ConfigHandler;


import javax.annotation.Nonnull;

public class ItemLightningStaff extends ItemBase {
    public int damage;
    public float distanceBlock;
    public ItemLightningStaff(int damage, float distanceBlock){
        super();
        this.damage = damage;
        this.maxStackSize = 1;
        if (damage != -1)
        {
            this.setMaxDamage(damage);
        }
        this.distanceBlock = distanceBlock;
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
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (!worldIn.isRemote)
        {
            if (playerIn.isSneaking())
            {
                RayTraceResult rayTraceResult = playerIn.rayTrace(this.distanceBlock, 1F);
                Entity entity = rayTraceResult.entityHit;
                if (entity != null)
                {
                    if (spawnLightningInRemote(rayTraceResult, worldIn, playerIn, handIn))
                    {
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
                    }
                }
                if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    if (spawnLightningInRemote(rayTraceResult, worldIn, playerIn, handIn))
                    {
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
                    }
                }
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
            }
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
    }
    public boolean spawnLightningInRemote(RayTraceResult rayTraceResult, World world, EntityPlayer player, EnumHand hand)
    {
        BlockPos blockPos = rayTraceResult.getBlockPos();

        world.addWeatherEffect(new EntityLightningBolt(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), false));

        ItemStack stack = player.getHeldItem(hand);

        stack.damageItem(10, player);

        if (!player.isCreative())
        {
            player.getCooldownTracker().setCooldown(this, 100);
        }
        return true;
    }

}
