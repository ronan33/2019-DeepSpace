package com.spartronics4915.frc2019.auto.actions;

import com.spartronics4915.frc2019.subsystems.Drive;
import com.spartronics4915.lib.util.DriveSignal;
import edu.wpi.first.wpilibj.Timer;

public class OpenLoopDrive implements Action
{

    private static final Drive mDrive = Drive.getInstance();

    private double mStartTime;
    private final double mDuration, mLeft, mRight;

    public OpenLoopDrive(double left, double right, double duration)
    {
        mDuration = duration;
        mLeft = left;
        mRight = right;
    }

    @Override
    public boolean isFinished()
    {
        return Timer.getFPGATimestamp() - mStartTime > mDuration;
    }

    @Override
    public void update()
    {
    }

    @Override
    public void done()
    {
        mDrive.setOpenLoop(new DriveSignal(0.0, 0.0));
    }

    @Override
    public void start()
    {
        mDrive.setOpenLoop(new DriveSignal(mLeft, mRight));
        mStartTime = Timer.getFPGATimestamp();
    }
}
