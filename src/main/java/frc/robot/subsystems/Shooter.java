package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    VictorSP topMotor;
    VictorSP bottomMotor;
   

    //Constructor
    public Shooter(){
        // set peramitor to motor connection
        topMotor = new VictorSP(3);  
        bottomMotor = new VictorSP(4);
        bottomMotor.setInverted(true);
    }

    public void MoveShooter (double mainSpeed){
        topMotor.set(mainSpeed);
        bottomMotor.set(mainSpeed);
    }
    public void stop(){
        topMotor.stopMotor();
        bottomMotor.stopMotor();
    }
}