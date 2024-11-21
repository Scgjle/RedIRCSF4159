package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class LiftArm extends Command{
    Arm botmoter;
    double speed;

    public LiftArm(Arm arm, double Speed){
        botmoter = arm;
        speed = Speed;
        addRequirements(botmoter);
    }

    @Override
    public void execute(){
        botmoter.LiftArm(speed);
    }

    @Override
    public void end(boolean i){
        botmoter.stop();
    }
}