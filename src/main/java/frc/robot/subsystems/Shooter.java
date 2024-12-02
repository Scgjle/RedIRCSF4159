package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    VictorSP topMotor; //motor on the top of the paddle
    VictorSP bottomMotor; //motor on the bottom of the paddle
   

    //Constructor
    public Shooter(){
        // set peramitor to motor connection
        topMotor = new VictorSP(3);  // says "topmotor is a victorsp motor connected to port 3 in the roboRio"
        bottomMotor = new VictorSP(4);// connected to port 4 in roborio
        bottomMotor.setInverted(true); //inverts the bottom motor
    }
    // creates the MoveShooter method which will make both motors turn at a given speed (mainspeed)
    public void MoveShooter (double mainSpeed){
        topMotor.set(mainSpeed);
        bottomMotor.set(mainSpeed);
    }
    // stops both motors
    public void stop(){
        topMotor.stopMotor();
        bottomMotor.stopMotor();
    }
}