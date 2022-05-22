package zhenzi233.zhenzimod.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import zhenzi233.zhenzimod.common.block.tileentity.TileEntityRack;
import zhenzi233.zhenzimod.common.block.tileentity.runutil.RenderTileEntityRack;

public class MessageRack implements IMessage {
    public ItemStack itemStack = ItemStack.EMPTY;

    public BlockPos pos;

    public MessageRack(TileEntityRack rack) {
        this.pos = rack.getPos();
        this.itemStack = rack.getInventoryItem();
    }

    public MessageRack() {

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.pos.getX());
        buf.writeInt(this.pos.getY());
        buf.writeInt(this.pos.getZ());
        ByteBufUtils.writeItemStack(buf, this.itemStack);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
        this.itemStack = ByteBufUtils.readItemStack(buf);
    }


    public static class Handler implements IMessageHandler<MessageRack, IMessage>
    {
        @Override
        public IMessage onMessage(MessageRack message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT)
            {
                World world = Minecraft.getMinecraft().world;
                TileEntity tileEntity = world.getTileEntity(message.pos);
                if (tileEntity instanceof TileEntityRack)
                {
                    ((TileEntityRack) tileEntity).receiveMessageFromServer(message.itemStack);
                }
            }
            return null;
        }
    }
}
