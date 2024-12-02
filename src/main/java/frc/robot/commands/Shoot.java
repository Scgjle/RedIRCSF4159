package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command{
    Shooter botmoter;
    double speed;

    // connecting variables again...
    public Shoot(Shooter motor, double Speed){
        botmoter = motor;
        speed = Speed;
        addRequirements(botmoter);
    }
    // changes execute method in the wiplib and calls MoveShooter from Shooter.java,setting the motor speeds to the variable "speed"
    @Override
    public void execute(){
        botmoter.MoveShooter(speed);
    }

    //stops both top and bottom shooter motors
    @Override
    public void end(boolean i){
        botmoter.stop();
    }
}