package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//adds on to subsystembase
public class Arm extends SubsystemBase{
    VictorSP baseMoter;
    //^ variable baseMoter is a motor (likely the one that moves the basic version of the arm subsystem)
   

    //new constructor!! is also added to the robotcontainer 
    public Arm(){
        // set peramitor to motor connection... AKA says that the base motor is connected to port 2 of the PDH
        baseMoter = new VictorSP(2);   
    }
    //  It turns the base motor, the motor that is connected to the large hex shaft by chain, to turn
    // note, there is a method with the same name in the LiftArm file, but that one takes two perameters. !!! why?
    //Called in the execute method in the LiftArm file.
    public void LiftArm (double speedLeft){
        //             v this (I think) is connected to leftsped in the TestAuto file, and can be changed to change the motors speed
        baseMoter.set(speedLeft);
        //         ^ this is setting the pwm value to make the base motor move at a certain speed. 
        
    }
    public void stop(){
        baseMoter.stopMotor();
        //        ^ stops the motor!! 
    }
}
