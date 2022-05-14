package zhenzi233.zhenzimod.common.item.items;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.*;
import zhenzi233.zhenzimod.common.misc.creativetab.CreativeTabLoader;
import zhenzi233.zhenzimod.common.misc.material.MaterialHandler;


public class ItemSCIronTools {
    public static class ItemSCIronPickaxe extends ItemPickaxe {
        public ItemSCIronPickaxe(ToolMaterial material) {
            super(material);
            this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
        }

        @Override
        public float getDestroySpeed(ItemStack stack, IBlockState state) {
            Material material = state.getMaterial();
            return material != MaterialHandler.SCIRON ? super.getDestroySpeed(stack, state) : this.efficiency;
        }
    }

    public static class ItemSCIronAxe extends ItemAxe {
        public ItemSCIronAxe(ToolMaterial material, float damage, float speed) {
            super(material, damage, speed);
            this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
        }
    }

    public static class ItemSCIronHoe extends ItemHoe {
        public ItemSCIronHoe(ToolMaterial material) {
            super(material);
            this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
        }


    }


        public static class ItemSCIronSpade extends ItemSpade {
            public ItemSCIronSpade(ToolMaterial material) {
                super(material);
                this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
            }
        }

        public static class ItemSCIronSword extends ItemSword {
            public ItemSCIronSword(ToolMaterial material) {
                super(material);
                this.setCreativeTab(CreativeTabLoader.tabZhenziMod);
            }
        }
    }

