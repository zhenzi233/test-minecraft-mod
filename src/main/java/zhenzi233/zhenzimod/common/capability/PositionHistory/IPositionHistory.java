package zhenzi233.zhenzimod.common.capability.PositionHistory;

import net.minecraft.util.math.Vec3d;

public interface IPositionHistory {

    public Vec3d[] getHistory();

    public void setHistories(Vec3d[] position);

    public void pushHistory(Vec3d position);

}
