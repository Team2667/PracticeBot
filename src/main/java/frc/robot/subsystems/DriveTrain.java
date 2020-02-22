package frc.robot.subsystems;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

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
    // Add an analog sensor for the distance sensor


    public DriveTrain(){
        leftPrimary = new WPI_TalonSRX(Constants.DT_LEFT_PRIMARY);
        rightPrimary = new WPI_TalonSRX(Constants.DT_RIGHT_PRIMARY);
        leftFollower = new WPI_TalonSRX(Constants.DT_LEFT_FOLLOWER);
        rightFollower = new WPI_TalonSRX(Constants.DT_RIGHT_FOLLOWER);
        leftFollower.follow(leftPrimary);
        rightFollower.follow(rightPrimary);
        rightPrimary.setInverted(true);
        rightFollower.setInverted(true);
        diffDriveTrain = new DifferentialDrive(leftPrimary, rightPrimary);
    }

    public void arcadeDrive(GenericHID jstick){
        diffDriveTrain.arcadeDrive(jstick.getX(), jstick.getY());
    }

    public double getDSReading(){
        // return distance in inches based on distance sensor reading.
        return 0;
    }

    public void moveForward(double value) {
        // Use value to set the speed for the drivetrain.
    }

    public void stop() {
        diffDriveTrain.stopMotor();
    }

}