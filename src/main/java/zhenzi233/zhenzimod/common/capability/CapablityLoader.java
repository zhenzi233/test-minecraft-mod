package zhenzi233.zhenzimod.common.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zhenzi233.zhenzimod.common.capability.EntityLivingBase.CapabilityEntityLivingBase;
import zhenzi233.zhenzimod.common.capability.EntityLivingBase.IEntityLivingBase;
import zhenzi233.zhenzimod.common.capability.PositionHistory.IPositionHistory;


public class CapablityLoader {
    @CapabilityInject(IPositionHistory.class)
    public static Capability<IPositionHistory> positionHistory;
    @CapabilityInject(IEntityLivingBase.class)
    public static Capability<IEntityLivingBase> entityLivingBase;

    public CapablityLoader(FMLPreInitializationEvent event)
    {
//        CapabilityManager.INSTANCE.register(IPositionHistory.class, new CapablityPositionHistory.Storage(),
//                CapablityPositionHistory.Implementation.class);
        CapabilityManager.INSTANCE.register(IEntityLivingBase.class, new CapabilityEntityLivingBase.Storage(),
                CapabilityEntityLivingBase.Implementation.class);
    }
}
