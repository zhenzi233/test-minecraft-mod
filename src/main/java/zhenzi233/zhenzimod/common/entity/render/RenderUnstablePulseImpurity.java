package zhenzi233.zhenzimod.common.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityUnstablePulseImpurity;
import zhenzi233.zhenzimod.common.item.ItemLoader;


public class RenderUnstablePulseImpurity extends RenderSnowball<EntityUnstablePulseImpurity> {
    public RenderUnstablePulseImpurity(RenderManager renderManager){
        super(renderManager, ItemLoader.UNSTABLE_PULSE_IMPURITY, Minecraft.getMinecraft().getRenderItem());
    }


}
