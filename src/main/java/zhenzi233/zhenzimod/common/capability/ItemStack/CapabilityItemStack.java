//package zhenzi233.zhenzimod.common.capability.ItemStack;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.nbt.NBTBase;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagInt;
//import net.minecraft.nbt.NBTTagIntArray;
//import net.minecraft.util.EnumFacing;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ICapabilityProvider;
//import zhenzi233.zhenzimod.common.capability.CapablityLoader;
//import zhenzi233.zhenzimod.common.capability.EntityLivingBase.CapabilityEntityLivingBase;
//import zhenzi233.zhenzimod.common.capability.EntityLivingBase.IEntityLivingBase;
//import zhenzi233.zhenzimod.common.misc.material.MaterialHandler;
//
//import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
//
//public class CapabilityItemStack {
//    public static class Storage implements Capability.IStorage<IItemStack>
//    {
//        @Nullable
//        @Override
//        public NBTBase writeNBT(Capability<IEntityLivingBase> capability, IEntityLivingBase instance, EnumFacing side) {
//            NBTTagIntArray debuggingToolPage = new NBTTagIntArray(new int[]{1, 2});
//            return null;
//        }
//
//        @Override
//        public void readNBT(Capability<IEntityLivingBase> capability, IEntityLivingBase instance, EnumFacing side, NBTBase nbt) {
//
//        }
//    }
//    public static class Implementation implements IEntityLivingBase
//    {
//        @Override
//        public boolean isOnChargedWater(Entity entity)
//        {
//            return entity.world.isMaterialInBB(entity.getEntityBoundingBox().grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), MaterialHandler.CHARGED_WATER);
//        }
//    }
//
//    public static class EntityLivingBaseProvider implements ICapabilityProvider
//    {
//        private IEntityLivingBase isOnChargedWaterResult = new CapabilityEntityLivingBase.Implementation();
//
//        @Override
//        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
//            return CapablityLoader.entityLivingBase.equals(capability);
//        }
//
//        @Nullable
//        @Override
//        public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
//            if (CapablityLoader.entityLivingBase.equals(capability))
//            {
//                @SuppressWarnings("unchecked")
//                T result = (T) isOnChargedWaterResult;
//                return result;
//            }
//            return null;
//        }
//    }
//}
