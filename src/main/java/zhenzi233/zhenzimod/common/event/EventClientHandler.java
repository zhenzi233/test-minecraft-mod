package zhenzi233.zhenzimod.common.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventClientHandler {
    public static final EventBus EVENT_BUS = new EventBus();

    public EventClientHandler(){
        MinecraftForge.EVENT_BUS.register(this);
        EventHandler.EVENT_BUS.register(this);
    }

    public static int clientTick = 0;
    public static float angle = 0F;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void clientTickEvent(TickEvent.ClientTickEvent event)
    {
        if (event.phase == TickEvent.Phase.START)
        {
            clientTick++;
            angle++;
        }
        if (angle > 360F)
        {
            angle = 0;
        }
    }
}
