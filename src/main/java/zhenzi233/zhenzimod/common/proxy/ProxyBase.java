package zhenzi233.zhenzimod.common.proxy;

import net.minecraft.item.Item;

public class ProxyBase {
    public boolean isServer()
    {
        return false;
    }

    public void registerItemRenderer(Item item, int meta, String id) {
        //Ignored
    }
}