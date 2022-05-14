package zhenzi233.zhenzimod.common.event;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zhenzi233.zhenzimod.ZhenziMod;
import zhenzi233.zhenzimod.client.KeyLoader;
//import zhenzi233.zhenzimod.common.capability.CapablityLoader;
//import zhenzi233.zhenzimod.common.capability.EntityLivingBase.CapabilityEntityLivingBase;
import zhenzi233.zhenzimod.common.capability.CapablityLoader;
import zhenzi233.zhenzimod.common.capability.EntityLivingBase.CapabilityEntityLivingBase;
import zhenzi233.zhenzimod.common.capability.EntityLivingBase.IEntityLivingBase;
//import zhenzi233.zhenzimod.common.capability.PositionHistory.CapablityPositionHistory;
//import zhenzi233.zhenzimod.common.capability.PositionHistory.IPositionHistory;
import zhenzi233.zhenzimod.common.item.ItemLoader;
import zhenzi233.zhenzimod.common.misc.ModDamageSource;
import zhenzi233.zhenzimod.common.misc.enchantment.EnchantmentLoader;
import zhenzi233.zhenzimod.common.misc.potion.PotionLoader;

import java.util.Random;


//delay
public class EventHandler {

    public static final EventBus EVENT_BUS = new EventBus();

    public EventHandler(){
        MinecraftForge.EVENT_BUS.register(this);
        EventHandler.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void LightningBoltJoin(LightningBlotJoinWorld event)
    {
        if (!event.getWorld().isRemote)
        {
            System.out.println("event yes");
        }
    }

    @Cancelable
    public static class LightningBlotJoinWorld extends net.minecraftforge.event.entity.EntityJoinWorldEvent{

        public LightningBlotJoinWorld(EntityLightningBolt bolt, World world) {
            super(bolt, world);
        }
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        Entity target = event.getTarget();
        EntityPlayer player = event.getEntityPlayer();
        int value = EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.LIGHTNING_STRIKE,
                player.getHeldItemMainhand());
        ItemStack playerMainhandStack = player.getHeldItem(EnumHand.MAIN_HAND);
        Item playerMainHand = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
        boolean pulseIronSword = playerMainHand.equals(ItemLoader.PULSE_IRON_SWORD);
        if (!player.world.isRemote) {

            if (value == 1) {
                player.world.addWeatherEffect(new EntityLightningBolt(player.world, target.posX, target.posY, target.posZ, false));
            }

            if (pulseIronSword)
            {
                if (value != 1)
                {
                    Random random = new Random();
                    int v = random.nextInt(20);
                    if (v == 5)
                    {
                        player.world.addWeatherEffect(new EntityLightningBolt(player.world, target.posX, target.posY, target.posZ, false));
                        playerMainhandStack.damageItem(30, player);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onAttackEntityWithThunderKingPotion(AttackEntityEvent event) {
        PotionEffect effect = event.getEntityLiving().getActivePotionEffect(PotionLoader.THUNDER_KING);
        Entity target = event.getTarget();
        World world = event.getEntity().getEntityWorld();
        if (effect != null){
            world.addWeatherEffect(new EntityLightningBolt(world, target.posX, target.posY, target.posZ, false));
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if (KeyLoader.debugSetDay.isPressed())
        {
            World world = Minecraft.getMinecraft().world;
            EntityPlayer player = Minecraft.getMinecraft().player;
            world.setWorldTime(1000L);
            world.setTotalWorldTime(1000L);
            player.sendMessage(new TextComponentTranslation("chat.zhenzimod.debug.setday"));
        }
    }

    @SubscribeEvent
    public void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event)
    {
//        if (event.getObject() instanceof EntityPlayer)
//        {
//            ICapabilitySerializable<NBTTagCompound> provider = new CapablityPositionHistory.ProviderPlayer();
//            event.addCapability(new ResourceLocation(ZhenziMod.MODID + ":" + "position_history"), provider);
//        }
        if (event.getObject() instanceof EntityLivingBase)
        {
            ICapabilityProvider provider = new CapabilityEntityLivingBase.EntityLivingBaseProvider();
            event.addCapability(new ResourceLocation(ZhenziMod.MODID + ":" + "charged_water"), provider);
        }
    }

//    @SubscribeEvent
//    public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
//    {
//        Capability<IPositionHistory> capability = CapablityLoader.positionHistory;
//        Capability.IStorage<IPositionHistory> storage = capability.getStorage();
//
//        if (event.getOriginal().hasCapability(capability, null) && event.getEntityPlayer().hasCapability(capability, null))
//        {
//            NBTBase nbt = storage.writeNBT(capability, event.getOriginal().getCapability(capability, null), null);
//            storage.readNBT(capability, event.getEntityPlayer().getCapability(capability, null), null, nbt);
//        }
//    }


    @SubscribeEvent
    public void entityOnWaterCharged(LivingEvent.LivingUpdateEvent event)
    {
        EntityLivingBase entity = event.getEntityLiving();
        IEntityLivingBase getCap = entity.getCapability(CapablityLoader.entityLivingBase, null);
        Boolean result = getCap.isOnChargedWater(entity);
        if (result)
        {
            entity.attackEntityFrom(ModDamageSource.ENERGY_OVERLOAD, 2.0F);
        }
    }

    @SubscribeEvent
    public void nightVisionHelmet(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = event.player;
        if (player.inventory.armorInventory.get(3).getItem().equals(Items.DIAMOND_HELMET))
        {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 2400, 0));
        }
    }





//    public void fluidChargedWaterEvent()
}
