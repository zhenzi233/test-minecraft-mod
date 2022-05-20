package zhenzi233.zhenzimod.common.block.tileentity.runutil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
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
        IItemHandler up = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        IItemHandler down = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
        ItemStack rackUpStack = up.getStackInSlot(0);
        ItemStack rackDownStack = down.getStackInSlot(0);
//        ItemStack receiverItem = te.receiveMessageFromServer();

        boolean flag = te.getInventoryItemStack().isEmpty();
        if (!flag)
        {
            Minecraft mc = Minecraft.getMinecraft();
            mc.getRenderItem().renderItem(te.getInventoryItemStack(), ItemCameraTransforms.TransformType.GROUND);
//            System.out.println(receiverItem);
        }

        GlStateManager.popMatrix();
    }

}
