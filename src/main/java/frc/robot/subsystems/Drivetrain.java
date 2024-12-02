package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// v says "create a class that is like the imported class "subsytembase" exept it has new stuff (thermos vs. waterbottle idea)" 
public class Drivetrain extends SubsystemBase{
    VictorSP leftMotor;
//           v variable name 
    VictorSP rightMotor;
//  ^ variable type (they're the motors!! we have "victorsp" motors)

    //no return type=Constructor?
    public Drivetrain(){
        // set peramitor to motor connection... AKA "channel 1" means the VictorSP leftMotor is connected to port one of the RoboRIO
        leftMotor = new VictorSP(1);
        rightMotor = new VictorSP(0);
        // inverts left motor
        rightMotor.setInverted(true);
    }
    // saying how fast the motors should go. sets the number "speedLeft" to the speed of the leftMotor
    public void drive(double speedLeft, double speedRight){
        //        v this set method is from the wiplib thing and it sets the PWM value based on the speed given to it (through a double variable)
        leftMotor.set(speedLeft);
        rightMotor.set(speedRight);
    }
    // tells robot to stop by simultaneously stopping both left and right motors
    public void stop(){
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

}
