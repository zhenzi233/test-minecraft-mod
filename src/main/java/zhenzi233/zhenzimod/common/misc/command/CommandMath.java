package zhenzi233.zhenzimod.common.misc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandMath extends CommandBase {
    @Override
    public String getName()
    {
        return "math";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "commands.position.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        double[] Shuju = new double[] {81.8, 79.85, 90.8, 0, 0, 90.25, 81.8, 88.84, 85, 90, 85.3, 86};
        double result,result1,result2,result3,result4,result5,result6,result7,result8,result9,result10,result11;
        result = jisuanshuju(Shuju[0], 3.5);
        result1 = jisuanshuju(Shuju[1], 2.5);
        result2 = jisuanshuju(Shuju[2], 6);
        result3 = jisuanshuju(Shuju[3], 2);
        result4 = jisuanshuju(Shuju[4], 2);
        result5 = jisuanshuju(Shuju[5], 0.5);
        result6 = jisuanshuju(Shuju[6], 2);
        result7 = jisuanshuju(Shuju[7], 1);
        result8 = jisuanshuju(Shuju[8], 2.5);
        result9 = jisuanshuju(Shuju[9], 1);
        result10 = jisuanshuju(Shuju[10], 2);
        result11 = jisuanshuju(Shuju[11], 1);
        double result12 = result + result1 +result2+ result3 + result4 + result5 +result6+result7+result8+result9+result10+result11;
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);
        System.out.println(result11);
        System.out.println(result12);
    }
    public double jisuanshuju(double doubles, double xuefen)
    {
        double result;
        result = (doubles / 10 - 5) * xuefen;
        return result;
    }
}
