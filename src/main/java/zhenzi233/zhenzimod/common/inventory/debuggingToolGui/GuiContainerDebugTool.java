package zhenzi233.zhenzimod.common.inventory.debuggingToolGui;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.client.book.BookButton;
import zhenzi233.zhenzimod.common.inventory.GuiElementLoader;
import zhenzi233.zhenzimod.common.item.ItemLoader;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiContainerDebugTool extends GuiContainer {

    public GuiContainerDebugTool(ContainerDebugTool inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = 256;
        this.ySize = 236;
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

//        this.drawVerticalLine(30, 19, 36, 0xFF000000);
//        this.drawHorizontalLine(8, 167, 43, 0xFF000000);
        String key = "container.zhenzimod.debug";
        String button_key1 = "container.zhenzimod.block.pos";
        String button_key2 = "container.zhenzimod.block.state";
        String title = I18n.format(key);
        String title1 = I18n.format(button_key1);
        String title2 = I18n.format(button_key2);

        this.fontRenderer.drawString(title1, 51, 28, 0x404040);
        this.fontRenderer.drawString(title2, 51, 58, 0x404040);
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);

        ItemStack item = new ItemStack(ItemLoader.DEBUGGING_TOOLS);
        this.itemRender.renderItemAndEffectIntoGUI(item, 234, 214);
    }
    public BookButton bookButton = new BookButton();


    @Override
    public void initGui() {
        super.initGui();
        bookButton.addButtonTypeAboutDebug(12, 20, BUTTON_1, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebug(12, 50, BUTTON_2, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebug(12, 80, BUTTON_3, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebug(12, 110, BUTTON_4, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebug(12, 140, BUTTON_5, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebug(12, 170, BUTTON_6, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
        bookButton.addButtonTypeAboutDebugChange(12, 200, BUTTON_7, TEXTURE, this.xSize, this.ySize, this.width, this.height, this.buttonList);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        EntityPlayer player = this.mc.player;
        BlockPos pos = player.getPosition();
        World world = this.mc.world;
        RayTraceResult playerLookResult = this.mc.objectMouseOver;
        if (button.id == BUTTON_7) {
            player.openGui(ZhenziMod.instance, GuiElementLoader.GUI_DEBUG_1, world, pos.getX(), pos.getY(), pos.getZ());
        }
        if (playerLookResult.typeOfHit == RayTraceResult.Type.BLOCK)
        {
            ItemStack stack = player.getHeldItemMainhand();
            BlockPos lookBlockPos = playerLookResult.getBlockPos();
            IBlockState lookBlockState = world.getBlockState(lookBlockPos);
            TileEntity tileEntity = world.getTileEntity(lookBlockPos);
            switch (button.id)
            {
                case BUTTON_1:
                    player.sendMessage(new TextComponentString("Pos: " + lookBlockPos));
                    break;
                case BUTTON_2:
                    player.sendMessage(new TextComponentString("State: " + lookBlockState));
                    break;
                case BUTTON_3:
                    if (tileEntity != null)
                    {
                        player.sendMessage(new TextComponentString("State: " + tileEntity));
                        break;
                    }
                case BUTTON_4:
                    BlockPos playerPosition = player.getPosition();
                    Material material = player.world.getBlockState(playerPosition).getMaterial();
                    player.sendMessage(new TextComponentString("State: " + material));
                    break;
                case BUTTON_5:
                    break;
                case BUTTON_6:
                    break;
                default:
                    super.actionPerformed(button);
                    break;
            }

        }
    }
}
