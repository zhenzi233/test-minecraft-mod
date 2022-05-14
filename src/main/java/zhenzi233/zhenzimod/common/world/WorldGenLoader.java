package zhenzi233.zhenzimod.common.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldGenLoader {

    public WorldGenerator generatorGreenOre = new WorldGenGreenOre();
    private BlockPos pos;


    public WorldGenLoader()
    {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event)
    {
        if (!event.getPos().equals(this.pos))
        {
//            这里有一点需要说明，OreGenEvent.Pre和OreGenEvent.Post会在山地地形对应的区块分别调用两次，原因是原版游戏中生成绿宝石等山地特有矿物的阶段和生成其他普通矿物的阶段是分离的，
//            所以会分别调用两次，我们把调用的方块坐标位置记录下来以避免第二次调用的发生。
            this.pos = event.getPos();
            generatorGreenOre.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }

//    @SubscribeEvent
//    public void onOreGenGenerateMinable(OreGenEvent.GenerateMinable event)
//    {
//
//    }
}
