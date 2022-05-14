package zhenzi233.zhenzimod.client.book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class BookButton {
    public void addButtonTypeAboutDebug(int x, int y, int buttonId, ResourceLocation TEXTURE, int xSize, int ySize, int width, int height, List<GuiButton> buttonList)
    {
        int offsetX = (width - xSize) / 2, offsetY = (height - ySize) / 2;
        buttonList.add(new GuiButton(buttonId, offsetX + x, offsetY + y, 35, 20, "") {
            @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
                if (this.visible) {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    int x = mouseX - this.x, y = mouseY - this.y;

                    if (x >= 0 && y >= 0 && x < this.width && y < this.height) {
                        this.drawTexturedModalRect(this.x, this.y, 0, 236, this.width, this.height);
                    } else {
                        this.drawTexturedModalRect(this.x, this.y, 105, 236, this.width, this.height);
                    }
                }
            }
        });
    }
    public void addButtonTypeAboutDebugChange(int x, int y, int buttonId, ResourceLocation TEXTURE, int xSize, int ySize, int width, int height, List<GuiButton> buttonList)
    {
        int offsetX = (width - xSize) / 2, offsetY = (height - ySize) / 2;
        buttonList.add(new GuiButton(buttonId, offsetX + x, offsetY + y, 10, 16, ""){
            @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F);

                mc.getTextureManager().bindTexture(TEXTURE);
                int x = mouseX - this.x, y = mouseY - this.y;

                if (x >= 0 && y >= 0 && x < this.width && y < this.height)
                {
                    this.drawTexturedModalRect(this.x, this.y, 220, 236, this.width, this.height);
                } else {
                    this.drawTexturedModalRect(this.x, this.y, 210, 236, this.width, this.height);
                }
            }
        });
    }
}
