package zhenzi233.zhenzimod.common.misc.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    private static Configuration config;



    public static boolean switchLightningStaff;
    public static boolean swithcUnstablePulseImpurityThrew;
    public static int unstablePulseImpuritySpawnLightningProbability;


    public static void configLoad(File configFile){
        config = new Configuration(configFile);
        config.load();
        load();
    }

    public static void load(){

        String comment,comment1,comment2;

        comment = "Whether to enable LightningStaff (true / false) ";
        switchLightningStaff = config.get(Configuration.CATEGORY_GENERAL, "switchLightningStaff", true, comment).getBoolean();

        comment1 = "Whether to enable throw of 'Unstable Pulse Impurity' (true / false)";
        swithcUnstablePulseImpurityThrew = config.get(Configuration.CATEGORY_GENERAL, "swithcUnstablePulseImpurityThrew" , true, comment1).getBoolean();

        comment2 = "Sets the probability of 'Unstable Pulse Impurity' generating lightning ( 0 : no longer generate) ";
        unstablePulseImpuritySpawnLightningProbability = config.get(Configuration.CATEGORY_GENERAL, "unstablePulseImpuritySpawnLightningProbability", 8, comment2).getInt();

        config.save();

    }
}

