package zhenzi233.zhenzimod.common.block.tileentity.runutil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityRack;
import zhenzi233.zhenzimod.common.event.EventClientHandler;
import zhenzi233.zhenzimod.common.item.ItemLoader;

@SideOnly(Side.CLIENT)
public class RenderTileEntityRack extends TileEntitySpecialRenderer<TileEntityRack> {
    public ItemStack receiverItemStack;

    @Override
    public void render(TileEntityRack te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.translate(x, y, z);

        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        float time = EventClientHandler.clientTick + partialTicks;
        float angle = EventClientHandler.angle;


        if (!te.clientGetInventoryItemStack().isEmpty())
        {

            GlStateManager.translate(0.5D, 0.6D + 0.1 * Math.sin((time+ 10)/ 10D) , 0.5D);
            GlStateManager.scale(1.4D, 1.4D, 1.4D);
            GlStateManager.rotate((float) (time * 2.5), 0F, 1F, 0F);
            Minecraft mc = Minecraft.getMinecraft();
            mc.getRenderItem().renderItem(te.clientGetInventoryItemStack(), ItemCameraTransforms.TransformType.GROUND);

//            System.out.println(receiverItem);
        }

        GlStateManager.popMatrix();
    }

}
