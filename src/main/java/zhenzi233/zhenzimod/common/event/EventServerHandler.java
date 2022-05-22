package zhenzi233.zhenzimod.common.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventServerHandler {
    public static final EventBus EVENT_BUS = new EventBus();

    public EventServerHandler(){
        MinecraftForge.EVENT_BUS.register(this);
        EventHandler.EVENT_BUS.register(this);
    }
    public static int worldTick = 0;
    @SubscribeEvent
    public void serverTickHandler(TickEvent.WorldTickEvent event)
    {
        worldTick++;
    }
}
