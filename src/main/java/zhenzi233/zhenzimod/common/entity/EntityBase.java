package zhenzi233.zhenzimod.common.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import zhenzi233.zhenzimod.common.misc.ModDamageSource;


public class EntityBase extends Entity {
//
//    private int fire;


    public EntityBase(World world){
        super(world);
    }

    protected void entityInit()
    {
    }

    protected void readEntityFromNBT(NBTTagCompound compound)
    {
    }

    protected void writeEntityToNBT(NBTTagCompound compound)
    {
    }

    @Override
    public void onEntityUpdate()
    {
        if (this.isInChargedWater())
        {
            this.setOnFireFromChargedWater();
            this.fallDistance *= 0.5F;
        }
    }

//    public void onStruckByLightningLight(EntityLightningBlotLight blotLight)
//    {
//        this.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 5.0F);
//        ++this.fire;
//
//        if (this.fire == 0)
//        {
//            this.setFire(8);
//        }
//    }

    protected void setOnFireFromChargedWater()
    {
        if (!this.isImmuneToFire)
        {
            this.attackEntityFrom(ModDamageSource.ENERGY_OVERLOAD, 4.0F);
            this.setFire(15);
        }
    }

    public boolean isInChargedWater()
    {
        return this.world.isMaterialInBB(this.getEntityBoundingBox().grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.WATER);
    }
}
