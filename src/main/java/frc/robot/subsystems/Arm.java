package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{
    VictorSP baseMoter;
   

    //Constructor
    public Arm(){
        // set peramitor to motor connection
        baseMoter = new VictorSP(2);   
    }

    public void LiftArm (double speedLeft){
        baseMoter.set(speedLeft);
        
    }
    public void stop(){
        baseMoter.stopMotor();
    }
}
