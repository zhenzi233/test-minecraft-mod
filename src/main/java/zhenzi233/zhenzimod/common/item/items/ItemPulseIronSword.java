package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.inventory.GuiElementLoader;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;

public class ItemPulseIronSword extends ItemSword {


    public ItemPulseIronSword()
    {
        super(ToolMaterial.IRON);
        this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
    }

//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//        if (!worldIn.isRemote)
//        {
//
//            RayTraceResult rayTraceResult = playerIn.rayTrace(40.0F, 1.0F);
//            BlockPos pos = rayTraceResult.getBlockPos();
//            worldIn.createExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true);
//        }
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//    }
}
