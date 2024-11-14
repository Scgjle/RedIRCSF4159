package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    VictorSP leftMotor;
    VictorSP rightMotor;

    //Constructor
    public Drivetrain(){
        // set peramitor to motor connection
        leftMotor = new VictorSP(0);
        rightMotor = new VictorSP(1);
        // inverts left motor
        leftMotor.setInverted(true);
    }

    public void drive(double speedLeft, double speedRight){
        leftMotor.set(speedLeft);
        rightMotor.set(speedRight);
    }
    public void stop(){
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

}
