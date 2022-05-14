package zhenzi233.zhenzimod.common.entity.render;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.entity.entitirs.EntityOneEyeSkeleton;
import zhenzi233.zhenzimod.common.entity.model.ModelTest;


@SideOnly(Side.CLIENT)
public class RenderOneEyeSkeleton extends RenderLiving<EntityOneEyeSkeleton> {


        private static final ResourceLocation TEXTURE = new ResourceLocation(
                ZhenziMod.MODID + ":" + "textures/entity/one_eye_skeleton.png");

        public RenderOneEyeSkeleton(RenderManager renderManager)
        {
            super(renderManager, new ModelTest(), 0.5F);
        }

        @Override
        protected void preRenderCallback(EntityOneEyeSkeleton entity, float partialTickTime)
        {
            GlStateManager.scale(2.0F, 2.0F, 2.0F);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityOneEyeSkeleton entity)
        {
            return RenderOneEyeSkeleton.TEXTURE;
        }

        @Override
        public void doRender(EntityOneEyeSkeleton entity, double x, double y, double z, float entityYaw, float partialTicks)
        {
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }

}
