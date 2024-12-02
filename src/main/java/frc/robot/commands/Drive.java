package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
// takes imported Command class and adds some stuff (Drive method) and changes some stuff (execute & end methods)
public class Drive extends Command{
    // uses constructors from Drivetrain.java and RobotContainer.java
    Drivetrain drivetrain;
    Joystick rightJoystick, leftJoystick;
 
    // connects the drivetrain subsystem and the joysticks for the robot to move in teleop
    public Drive(Drivetrain drivetrain, Joystick leftStick, Joystick rightStick){
        leftJoystick = leftStick;
        rightJoystick = rightStick;
        //v this.drivetrain is the member variable vs. drivetrain which is a parameter to the function
        this.drivetrain = drivetrain;
        // wiplib thing needs this line. !!! why? 
        addRequirements(drivetrain);
    }
    // changes the execute method in the wiplib to be run by the joysticks
    @Override
    public void execute(){
        // since y values are verticle   v This takes the y value of the joystick (how far you are pushing it forward)
        drivetrain.drive(-leftJoystick.getY(), -rightJoystick.getY());
        // this then takes those values and uses them as speed perameters for the drive method: drive(double speedLeft, double speedRight)                          
    }  
    // changes the end method so that it stops both motors (the stop method does that)
    @Override
    public void end(boolean interupted){
        drivetrain.stop();
    }
}
