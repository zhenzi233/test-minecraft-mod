package zhenzi233.zhenzimod.common.misc.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import zhenzi233.zhenzimod.ZhenziMod;


public class PotionThunderKing extends Potion {

    public static ResourceLocation res = new ResourceLocation(ZhenziMod.MODID + ":" + "textures/gui/potion.png");

    public PotionThunderKing(){
        super(true, 0x1C86EE);
        this.setPotionName(ZhenziMod.MODID + "." + "thunder_king");
        this.setIconIndex(0, 0);
    }

    @Override
    public boolean hasStatusIcon() {
        return false;
    }

    @Override
    public void renderInventoryEffect(PotionEffect effect, net.minecraft.client.gui.Gui gui, int x, int y, float z) {
        // 绘制逻辑，可直接交给 renderHUDEffect，此时 alpha = 1F
        Minecraft.getMinecraft().getTextureManager().bindTexture(res);
        // func_146110_a
        // x, y 为绘制的起点，u, v 为纹理的起点，w, h 为选取的纹理的宽和高，texW 和 texH 代表整张纹理的宽和高
        gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 256, 256);
    }

    @Override
    public void renderHUDEffect(PotionEffect effect, net.minecraft.client.gui.Gui gui, int x, int y, float z, float alpha) {
        // 绘制逻辑
        Minecraft.getMinecraft().getTextureManager().bindTexture(res);
        // func_146110_a
        // x, y 为绘制的起点，u, v 为纹理的起点，w, h 为选取的纹理的宽和高，texW 和 texH 代表整张纹理的宽和高
        gui.drawModalRectWithCustomSizedTexture(x + 3, y + 4, 0, 0, 18, 18, 256, 256);
    }

}
