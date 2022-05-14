//import net.minecraft.command.CommandBase;
//
////package zhenzi233.zhenzimod.common.misc.command;
////
////import net.minecraft.command.CommandBase;
////import net.minecraft.command.CommandException;
////import net.minecraft.command.ICommandSender;
////import net.minecraft.command.WrongUsageException;
////import net.minecraft.entity.player.EntityPlayerMP;
////import net.minecraft.server.MinecraftServer;
////import net.minecraft.util.math.BlockPos;
////import net.minecraft.util.math.Vec3d;
////import net.minecraft.util.text.TextComponentString;
////import net.minecraft.util.text.TextComponentTranslation;
////import zhenzi233.zhenzimod.common.capability.CapablityLoader;
////import zhenzi233.zhenzimod.common.capability.PositionHistory.IPositionHistory;
////
////
////import javax.annotation.Nullable;
////import java.util.List;
////
//public class CommandPosition extends CommandBase {
////
////    @Override
////    public String getName()
////    {
////        return "position";
////    }
////
////    @Override
////    public String getUsage(ICommandSender sender)
////    {
////        return "commands.position.usage";
////    }
////
////    @Override
////    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
////    {
////        if (args.length > 1)
////        {
////            throw new WrongUsageException("commands.position.usage");
////        }
////        else
////        {
////            EntityPlayerMP entityPlayerMP = args.length > 0 ? CommandBase.getPlayer(server, sender, args[0])
////                    : CommandBase.getCommandSenderAsPlayer(sender);
////            Vec3d pos = entityPlayerMP.getPositionVector();
////            String key1 = "commands.position.success";
////            if (entityPlayerMP == sender && entityPlayerMP.hasCapability(CapablityLoader.positionHistory, null))
////            {
////                String key = "commands.position.history";
////                sender.sendMessage(new TextComponentTranslation(key));
////                IPositionHistory histories = entityPlayerMP.getCapability(CapablityLoader.positionHistory, null);
////                for (Vec3d vec3d : histories.getHistory())
////                {
////                    if (vec3d != null)
////                    {
////                        sender.sendMessage(new TextComponentString(vec3d.toString()));
////                    }
////                }
////                histories.pushHistory(pos);
////            }
////
////            sender.sendMessage(new TextComponentTranslation(key1 , entityPlayerMP.getName() ,
////                    pos));
////        }
////    }
////
////    @Override
////    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
////    {
////        if (args.length == 1)
////        {
////            String[] names = server.getOnlinePlayerNames();
////            return CommandBase.getListOfStringsMatchingLastWord(args, names);
////        }
////        return null;
////    }
////}
