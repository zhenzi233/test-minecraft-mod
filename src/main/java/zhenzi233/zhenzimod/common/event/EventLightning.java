package zhenzi233.zhenzimod.common.event;

import com.google.common.collect.Maps;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityRack;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.recipe.recipeutil.RecipeRackUtil;

import java.util.Map;

public class EventLightning {
    public Map<Item, Float> itemListOfRackToExplosion = Maps.newHashMap();
    public static final EventLightning LIGHTNING = new EventLightning();
    public static EventLightning instance()
    {
        return LIGHTNING;
    }
    public EventLightning(){
        MinecraftForge.EVENT_BUS.register(this);
        EventHandler.EVENT_BUS.register(this);
    }

    public float getRackExplosionRecipe(Item item)
    {
        for (Map.Entry<Item, Float> entry : this.itemListOfRackToExplosion.entrySet())
        {
            if (this.compareItem(item, entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return 0F;
    }

    public void addRackToExplosionOfItem(Item item, float explosionStrength)
    {
        this.itemListOfRackToExplosion.put(item, explosionStrength);
    }

    public boolean compareItem(Item getItem, Item recipeItem)
    {
        return getItem == recipeItem;
    }

    @SubscribeEvent
    public void EventBlockRack(EntityJoinWorldEvent event)
    {
        World world = event.getWorld();
        Entity entity = event.getEntity();
        if (entity instanceof EntityLightningBolt)
        {
            BlockPos blotPos = entity.getPosition();
            TileEntity tileEntity = world.getTileEntity(blotPos);
            if (tileEntity instanceof TileEntityRack)
            {
                ItemStack itemStack = ((TileEntityRack) tileEntity).getInventoryItem();
                if (!itemStack.isEmpty())
                {
                    Item item = itemStack.getItem();
                    float strength = this.getRackExplosionRecipe(item);
                    world.createExplosion(null, blotPos.getX(), blotPos.getY(), blotPos.getZ(), strength, true);
                }
            }
        }
    }
}
