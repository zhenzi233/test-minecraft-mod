package zhenzi233.zhenzimod.common.event;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.common.block.BlockLoader;


import java.util.List;
import java.util.Map;


public class EventLightningConvert {

    public static final EventBus EVENT_BUS = new EventBus();

    public static final EventLightningConvert CONVERT_LIGHTNING = new EventLightningConvert();

    public static final EventLightningConvert instance()
    {
        return CONVERT_LIGHTNING;
    }

    private final Map<IBlockState, IBlockState> convertList = Maps.<IBlockState, IBlockState>newHashMap();
    private final Map<ItemStack, ItemStack> convertListItem = Maps.<ItemStack, ItemStack>newHashMap();


    public EventLightningConvert()
    {
        MinecraftForge.EVENT_BUS.register(this);
        EventLightningConvert.EVENT_BUS.register(this);
    }


//    事件触发
    @SubscribeEvent
    public void LightningBlotConvert(EntityJoinWorldEvent event)
    {

        World world = event.getWorld();
        Entity entity = event.getEntity();
        if (entity instanceof EntityLightningBolt)
        {
            BlockPos entityPos = entity.getPosition();
            convert(world, entityPos);
            convert(world, entityPos.add(0, -1, 0));

        }
    }

//转化
    public void convert(World world, BlockPos pos)
    {
        IBlockState getBlockState = world.getBlockState(pos);
        IBlockState getBlockState2 = world.getBlockState(pos.add(0, -1, 0));
        IBlockState output = this.getConvertRecipe(getBlockState);
        IBlockState output2 = this.getConvertRecipe(getBlockState2);
        if (output2 != null && output == null)
        {
            world.destroyBlock(pos.add(0, -1, 0), false);
            world.setBlockState(pos.add(0, -1, 0), output2);
        }
        if (output != null) //判断方块是否符合条件
        {
            world.destroyBlock(pos, false);
            world.setBlockState(pos, output);
        }

    }
//添加过程方法
    public void addConvertRecipe(IBlockState inputState, IBlockState outputState)
    {
        this.convertList.put(inputState, outputState);
        this.convertListItem.put(new ItemStack(Item.getItemFromBlock(inputState.getBlock())),
                                 new ItemStack(Item.getItemFromBlock(outputState.getBlock())));
    }

//    获取转化列表中的方块
    public IBlockState getConvertRecipe(IBlockState getBlockState)
    {
        for (Map.Entry<IBlockState, IBlockState> entry : this.convertList.entrySet())
        {
            if (this.compareBlockState(getBlockState, entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return null;
    }
//    比较是否符合条件
    public boolean compareBlockState(IBlockState getBlockState, IBlockState inputState)
    {
        return getBlockState == inputState;
    }
//获取清单
    public Map<IBlockState, IBlockState> getConvertList()
    {
        return this.convertList;
    }
//    public IBlockState getInputBlock()
//    {
//        this.convertList.entrySet();
//        return convertList.getKey();
//    }
    public Map<ItemStack, ItemStack> getConvertListItem()
    {
        return this.convertListItem;
    }
}
