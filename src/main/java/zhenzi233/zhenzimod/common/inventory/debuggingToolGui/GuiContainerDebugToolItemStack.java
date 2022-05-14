package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.common.inventory.GuiElementLoader;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiContainerDebugToolItemStack extends GuiContainer {

    private static final String TEXTURE_PATH = ZhenziMod.MODID + ":" + "textures/gui/container/gui_debug_itemstack.png";

    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);


    public GuiContainerDebugToolItemStack(ContainerDebugToolItemStack inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 166;
    }



    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
//        if (this.recipeBookGui.isVisible() && this.widthTooNarrow)
//        {
//            this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
//            this.recipeBookGui.render(mouseX, mouseY, partialTicks);
//        }
//        else
//        {
//            this.recipeBookGui.render(mouseX, mouseY, partialTicks);
//            super.drawScreen(mouseX, mouseY, partialTicks);
//            this.recipeBookGui.renderGhostRecipe(this.guiLeft, this.guiTop, true, partialTicks);
//        }
//
//        this.renderHoveredToolTip(mouseX, mouseY);
//        this.recipeBookGui.renderTooltip(this.guiLeft, this.guiTop, mouseX, mouseY);
    }

    @Override
    public void initGui() {
        super.initGui();
        addButtonDraw(1, 68, 54);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        EntityPlayer player = this.mc.player;
        World world = this.mc.world;
        BlockPos pos = player.getPosition();
        ContainerDebugToolItemStack stack = new ContainerDebugToolItemStack(player);
        ItemStack item = stack.getSlot(0).getStack();
        if (button.id == 1)
        {
            player.sendMessage(new TextComponentString("State: " + item));
        }

    }

    public void addButtonDraw(int buttonId, int x, int y)
    {
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(buttonId, offsetX + x, offsetY + y, 35, 20, "") {
            @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
                if (this.visible) {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    int x = mouseX - this.x, y = mouseY - this.y;

                    if (x >= 0 && y >= 0 && x < this.width && y < this.height) {
                        this.drawTexturedModalRect(this.x, this.y, 0, 166, this.width, this.height);
                    } else {
                        this.drawTexturedModalRect(this.x, this.y, 35, 166, this.width, this.height);
                    }
                }
            }
        });
    }

}
