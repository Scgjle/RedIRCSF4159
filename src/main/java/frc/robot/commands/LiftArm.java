package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

// adds on to Command class 
public class LiftArm extends Command{
    Arm botmoter; // <- botmotor=basemotor?
    double speed;// <- speed=Speed=leftspeed (from arm.java)? !!! why so many speeds? 
//declares some member variables

//is just connecting some variables.. !!! why? 
    public LiftArm(Arm arm, double Speed){
        botmoter = arm;
        speed = Speed;
        addRequirements(botmoter);
    }
//changing the execute method in the wiplib and calling the LiftArm method from Arm.java, which moves the base motor (botmotor) when given a s[ecifc speed]
    @Override
    public void execute(){
        botmoter.LiftArm(speed);
    }
//telling botmotor (base motor?) to stop moving
    @Override
    public void end(boolean i){
        botmoter.stop();
    }
}