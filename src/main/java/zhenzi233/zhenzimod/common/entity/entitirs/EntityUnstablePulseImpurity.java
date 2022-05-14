package zhenzi233.zhenzimod.common.entity.entitirs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.misc.config.ConfigHandler;


public class EntityUnstablePulseImpurity extends EntityThrowable {

    public EntityUnstablePulseImpurity(World world){
        super(world);
    }

    public EntityUnstablePulseImpurity(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityUnstablePulseImpurity(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(ItemLoader.UNSTABLE_PULSE_IMPURITY));
            }
        }
    }

    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.world.isRemote)
        {
            if (this.rand.nextInt(ConfigHandler.unstablePulseImpuritySpawnLightningProbability) == 0)
            {
                int i = 1;
                for (int j = 0; j < i; ++j)
                {
                    EntityLightningBolt bolt = new EntityLightningBolt(this.world, this.posX, this.posY, this.posZ, false);
                    this.world.addWeatherEffect(bolt);
                }
            }

            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}
