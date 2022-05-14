package zhenzi233.zhenzimod.common.capability.PositionHistory;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import zhenzi233.zhenzimod.common.capability.CapablityLoader;


public class CapablityPositionHistory {

    public static class Storage implements Capability.IStorage<IPositionHistory>
    {
        @Override
        public NBTBase writeNBT(Capability<IPositionHistory> capability, IPositionHistory instance, EnumFacing side)
        {
            NBTTagList list = new NBTTagList();
            for (Vec3d vec3d : instance.getHistory())
            {
                NBTTagCompound compound = new NBTTagCompound();
                if (vec3d != null)
                {
                    compound.setDouble("x", vec3d.x);
                    compound.setDouble("y", vec3d.y);
                    compound.setDouble("z", vec3d.z);
                }
                list.appendTag(compound);
            }
            return list;
        }

        @Override
        public void readNBT(Capability<IPositionHistory> capability, IPositionHistory instance, EnumFacing side,
                            NBTBase nbt)
        {
            NBTTagList list = (NBTTagList) nbt;
            Vec3d[] histories = new Vec3d[list.tagCount()];
            for (int i = 0; i < histories.length; ++i)
            {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (!compound.hasNoTags())
                {
                    histories[i] = new Vec3d(compound.getDouble("x"), compound.getDouble("y"), compound.getDouble("z"));
                }
            }
            instance.setHistories(histories);
        }
    }

    public static class Implementation implements IPositionHistory
    {
        private Vec3d[] histories = new Vec3d[5];

        @Override
        public Vec3d[] getHistory()
        {
            return histories.clone();
        }

        @Override
        public void setHistories(Vec3d[] position)
        {
            histories = position.clone();
        }

        @Override
        public void pushHistory(Vec3d position)
        {
            for (int i = 1; i < histories.length; ++i)
            {
                histories[i - 1] = histories[i];
            }
            histories[histories.length - 1] = position;
        }
    }

    public static class ProviderPlayer implements ICapabilitySerializable<NBTTagCompound>
    {
        private IPositionHistory histories = new Implementation();
        private Capability.IStorage<IPositionHistory> storage = CapablityLoader.positionHistory.getStorage();

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing)
        {
            return CapablityLoader.positionHistory.equals(capability);
        }

        @Override
        public <T> T getCapability(Capability<T> capability, EnumFacing facing)
        {
            if (CapablityLoader.positionHistory.equals(capability))
            {
                @SuppressWarnings("unchecked")
                T result = (T) histories;
                return result;
            }
            return null;
        }

        @Override
        public NBTTagCompound serializeNBT()
        {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setTag("histories", storage.writeNBT(CapablityLoader.positionHistory, histories, null));
            return compound;
        }

        @Override
        public void deserializeNBT(NBTTagCompound compound)
        {
            NBTTagList list = (NBTTagList) compound.getTag("histories");
            storage.readNBT(CapablityLoader.positionHistory, histories, null, list);
        }
    }
}
