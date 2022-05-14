package zhenzi233.zhenzimod.common.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zhenzi233.zhenzimod.common.block.BlockLoader;


import java.util.Random;

public class WorldGenGreenOre extends WorldGenerator {

    private final WorldGenerator greenoreGenerator = new WorldGenMinable(BlockLoader.GREEN_ORE_BLOCK.getDefaultState(), 4);

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
//        这个条件判断语句其实可以不存在，不过为什么我们要加上去呢？因为为了方便Mod间的相互协作，
//        我们向Forge触发了OreGenEvent.GenerateMinable事件，这样如果有Mod想要阻止萤石的生成，直接监听和原版类似的事件就可以了。与人方便，自己方便。
        if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        {
            for (int i = 0; i < 2; ++i)
            {
                int posX = pos.getX() + rand.nextInt(4);
                int posY = 3 + rand.nextInt(18);
                int posZ = pos.getZ() + rand.nextInt(4);
                BlockPos blockpos = new BlockPos(posX, posY, posZ);
//                关于生物群系
//                BiomeGenBase biomeGenBase = world.getBiomeGenForCoords(blockpos);
//                if (biomeGenBase.getIntRainfall() < rand.nextInt(65536))
//                {
                    greenoreGenerator.generate(world, rand, blockpos);
//                }
            }
        }
        return true;
    }

}
