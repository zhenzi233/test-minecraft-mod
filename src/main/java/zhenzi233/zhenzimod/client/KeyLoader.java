package zhenzi233.zhenzimod.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;
import zhenzi233.zhenzimod.ZhenziMod;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ZhenziMod.MODID)
public class KeyLoader {

    public static KeyBinding debugSetDay;

    public KeyLoader()
    {

        KeyLoader.debugSetDay = new KeyBinding("key.zhenzimod.debugSetDay", Keyboard.KEY_Z, "key.categories.zhenzimod");

        ClientRegistry.registerKeyBinding(KeyLoader.debugSetDay);
    }


}
