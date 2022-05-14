package zhenzi233.zhenzimod.common.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventTicker {

    Integer delay;
    Runnable function;
    public void tickDelay(Runnable function, int ticks){
        register();
        delay = ticks;
        this.function = function;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            // Delay expired
            if (delay < 1) {
                run();
                destroy();
            }
            delay--;
        }
    }

    @Mod.EventHandler()
    private void destroy() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Mod.EventHandler()
    private void register() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void run() {
        function.run();
    }
}

