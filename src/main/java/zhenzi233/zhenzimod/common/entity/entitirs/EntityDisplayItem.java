package zhenzi233.zhenzimod.common.entity.entitirs;

import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDisplayItem extends EntityItem {

    public EntityDisplayItem(World worldIn)
    {
        super(worldIn);
    }
    public EntityDisplayItem(World world, double posX, double posY, double posZ, ItemStack itemStack)
    {
        super(world, posX, posY, posZ, itemStack);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.setEntityInvulnerable(true);
    }
    @Override
    public boolean hasNoGravity()
    {
        return true;
    }
    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn)
    {
    }


}
