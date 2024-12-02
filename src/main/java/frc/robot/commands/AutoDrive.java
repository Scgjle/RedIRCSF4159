package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

// same thing as drive.java exept uses doubles leftsped and rightsped as speed inputs instead of joysticks
public class AutoDrive extends Command{
    Drivetrain drivet;
    double leftspeed, rightspeed;

    public AutoDrive (Drivetrain drivetrain, double leftsped, double rightsped){
        drivet = drivetrain;
        leftspeed = leftsped;
        rightspeed = rightsped;
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