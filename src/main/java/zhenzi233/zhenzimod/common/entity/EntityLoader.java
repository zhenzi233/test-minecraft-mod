package zhenzi233.zhenzimod.common.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityDisplayItem;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityOneEyeSkeleton;
import zhenzi233.zhenzimod.common.entity.render.EntityRenderFactory;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityUnstablePulseImpurity;
import zhenzi233.zhenzimod.common.entity.render.RenderOneEyeSkeleton;


public class EntityLoader {
    private static int nextID = 0;


    public EntityLoader()
    {
        registerEntity(EntityOneEyeSkeleton.class, "OneEyeSkeleton", 80, 3, true);
        registerEntity(EntityUnstablePulseImpurity.class, "UnstablePulseImpurity", 64, 10, true);
        registerEntity(EntityDisplayItem.class, "DisplayItem", 64, 10, true);
//        registerEntity(EntityLightningBlotLight.class, "LightningBlotLight", 10, 10, true);
        registerEntityEgg("OneEyeSkeleton",  0xffff66, 0x660000);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
                                       int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(ZhenziMod.MODID + ":" + name), entityClass, name, nextID++, ZhenziMod.instance
        , trackingRange, updateFrequency, sendsVelocityUpdates);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerEntityRender(EntityOneEyeSkeleton.class, RenderOneEyeSkeleton.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
    }

    private static void registerEntityEgg(String name, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerEgg(new ResourceLocation(ZhenziMod.MODID + ":" + name), eggPrimary, eggSecondary);
    }
}
