package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends Command{
    Drivetrain drivet;
    double leftspeed, rightspeed;

    public AutoDrive (Drivetrain drivetrain, double leftsped, double rightsped){
        drivet = drivetrain;
        leftsped = leftspeed;
        rightsped = rightspeed;
        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        drivet.drive(rightspeed, leftspeed);
    }

    @Override
    public void end(boolean i ){
        drivet.stop();
    }
}