package zhenzi233.zhenzimod.common.entity.entitirs;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityOneEyeSkeleton extends EntitySkeleton {
    public EntityOneEyeSkeleton(World world){
        super(world);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    protected void dropFewItems(boolean arg1, int arg2)
    {
        if (this.rand.nextInt(10) == 0)
        {
            this.dropItem(Items.BONE, 2);
        }
        super.dropFewItems(arg1, arg2);
    }
}
