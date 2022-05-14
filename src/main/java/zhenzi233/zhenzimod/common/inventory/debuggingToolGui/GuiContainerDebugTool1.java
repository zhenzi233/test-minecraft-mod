package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.item.EntityItem;
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
import zhenzi233.zhenzimod.common.item.ItemLoader;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiContainerDebugTool1 extends GuiContainer {
    public int gainNum1;

    public GuiContainerDebugTool1(ContainerDebugTool1 inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = 256;
        this.ySize = 236;
//        this.gainNum1 = inventorySlotsIn.getGainNum();
    }

    private static final String TEXTURE_PATH = ZhenziMod.MODID + ":" + "textures/gui/container/gui_debug.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    private static final int BUTTON_1 = 1;
    private static final int BUTTON_2 = 2;
    private static final int BUTTON_3 = 3;
    private static final int BUTTON_4 = 4;
    private static final int BUTTON_5 = 5;
    private static final int BUTTON_6 = 6;
    private static final int BUTTON_7 = 7;

    private int num = 0;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
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


    @Override
    public void initGui() {
        super.initGui();
        addButtonDraw(BUTTON_1, 12, 20);
        addButtonDraw(BUTTON_2, 12, 50);
        addButtonDraw(BUTTON_3, 12, 80);
        addButtonDraw(BUTTON_4, 12, 110);
        addButtonDraw(BUTTON_5, 12, 140);
        addButtonDraw(BUTTON_6, 12, 170);
        addButtonDrawChangePage(BUTTON_7, 12, 200);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        EntityPlayer player = this.mc.player;
        World world = this.mc.world;
        BlockPos pos = player.getPosition();
        ContainerDebugTool1 containerDebugTool1 = (ContainerDebugTool1) player.openContainer;
        switch (button.id)
        {
            case BUTTON_7:
                player.openGui(ZhenziMod.instance, GuiElementLoader.GUI_DEBUG, world, pos.getX(), pos.getY(), pos.getZ());
                break;
        }
        switch (button.id)
        {
            case BUTTON_1:
                EntitySnowball snowball = new EntitySnowball(world, player);
                snowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(snowball);
                this.onGuiClosed();
                break;
            case BUTTON_2:
                player.openGui(ZhenziMod.instance, GuiElementLoader.GUI_DEBUG_2, world,pos.getX(), pos.getY(), pos.getZ());
                break;
            case BUTTON_3:
//                player.dropItem(new ItemStack(ItemLoader.GREEN_DOG), false);
//                world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemLoader.GREEN_DOG)));
                containerDebugTool1.value = 1;
                break;
            case BUTTON_4:
                System.out.println(containerDebugTool1.value);
                break;
            case BUTTON_5:
                containerDebugTool1.value = 0;
                break;
            case BUTTON_6:
                break;
            default:
                super.actionPerformed(button);
                break;
        }

    }

    public int getNum()
    {
        return this.num;
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
                        this.drawTexturedModalRect(this.x, this.y, 0, 236, this.width, this.height);
                    } else {
                        this.drawTexturedModalRect(this.x, this.y, 105, 236, this.width, this.height);
                    }
                }
            }
        });
    }

    public void addButtonDrawChangePage(int buttonId, int x, int y)
    {
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(buttonId, offsetX + x, offsetY + y, 10, 16, ""){
            @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F);

                mc.getTextureManager().bindTexture(TEXTURE);
                int x = mouseX - this.x, y = mouseY - this.y;

                if (x >= 0 && y >= 0 && x < this.width && y < this.height)
                {
                    this.drawTexturedModalRect(this.x, this.y, 240, 236, this.width, this.height);
                } else {
                    this.drawTexturedModalRect(this.x, this.y, 230, 236, this.width, this.height);
                }
            }
        });
    }

}

