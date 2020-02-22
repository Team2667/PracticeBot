package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import  edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveToDistance extends PIDCommand {
    private DriveTrain dt;
    private static double p = 1;
    private static double i = 0;
    private static double d = 0;

    public DriveToDistance(DriveTrain driveTrain) {

        super(new PIDController(p,i,d), 
                () -> driveTrain.getDSReading(), 
                ()-> 0.0,  // determine the distance to move to in inches. This could be a 
                           // parameter to this command 
                (double d) -> driveTrain.moveForward(d),
                 driveTrain);
        this.dt = driveTrain;
       

        /* 
            PIDCommand(PIDController controller, DoubleSupplier measurementSource,
                    DoubleSupplier setpointSource, DoubleConsumer useOutput,
                    Subsystem... requirements)
        */
    }

    @Override
    public boolean isFinished() {
        // call this.getController().getPositionError()
        // if within an exceptable range, return true.
        return false;
    }
    
    // implement end(boolean isInterupted)
}
