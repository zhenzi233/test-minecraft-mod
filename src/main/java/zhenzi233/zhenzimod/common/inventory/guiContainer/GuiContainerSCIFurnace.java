package zhenzi233.zhenzimod.common.inventory.guiContainer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.inventory.container.ContainerSCIFurnace;

public class GuiContainerSCIFurnace extends GuiContainer {
    private static final String TEXTURE_PATH = ZhenziMod.MODID + ":" + "textures/gui/container/gui_demo.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);

    protected ContainerSCIFurnace inventory;

    private int totalBurnTime1;

    public GuiContainerSCIFurnace(ContainerSCIFurnace inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 166;
        this.inventory = inventorySlotsIn;
        this.totalBurnTime1 = inventorySlotsIn.getTotalBurnTime();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);

        int burnTime = this.inventory.getBurnTime();
        int textureWidth = 1 + (int) Math.ceil(51.0 * burnTime / this.totalBurnTime1);
        this.drawTexturedModalRect(offsetX + 62, offsetY + 36, 176, 0, textureWidth, 17);

    }
}
