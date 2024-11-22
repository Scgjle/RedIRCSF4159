package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command{
    Shooter botmoter;
    double speed;

    public Shoot(Shooter motor, double Speed){
        botmoter = motor;
        speed = Speed;
        addRequirements(botmoter);
    }

    @Override
    public void execute(){
        botmoter.MoveShooter(speed);
    }

    @Override
    public void end(boolean i){
        botmoter.stop();
    }
}