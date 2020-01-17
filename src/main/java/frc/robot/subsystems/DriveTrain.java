package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    private WPI_TalonSRX leftPrimary;
    private WPI_TalonSRX leftFollower;
    private WPI_TalonSRX rightPrimary;
    private WPI_TalonSRX rightFollower;
    private DifferentialDrive diffDriveTrain;

    public DriveTrain(){
        leftPrimary = new WPI_TalonSRX(Constants.DT_LEFT_PRIMARY);
        rightPrimary = new WPI_TalonSRX(Constants.DT_RIGHT_PRIMARY);
        leftFollower = new WPI_TalonSRX(Constants.DT_LEFT_FOLLOWER);
        rightFollower = new WPI_TalonSRX(Constants.DT_RIGHT_FOLLOWER);
        leftFollower.follow(leftPrimary);
        rightFollower.follow(rightPrimary);
        diffDriveTrain = new DifferentialDrive(leftPrimary, rightPrimary);
    }

    public void arcadeDrive(GenericHID jstick){
        diffDriveTrain.arcadeDrive(jstick.getX(), jstick.getY());
    }

    public void stop() {
        diffDriveTrain.stopMotor();
    }

}