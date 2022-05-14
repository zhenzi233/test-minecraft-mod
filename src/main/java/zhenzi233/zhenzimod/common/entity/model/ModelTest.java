package zhenzi233.zhenzimod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTest extends ModelBase {
    private final ModelRenderer test;

    public ModelTest() {
        textureWidth = 16;
        textureHeight = 16;

        test = new ModelRenderer(this);
        test.setRotationPoint(0.0F, 24.0F, 0.0F);
        test.cubeList.add(new ModelBox(test, 0, 0, -3.0F, -6.0F, -3.0F, 6, 6, 6, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        test.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
