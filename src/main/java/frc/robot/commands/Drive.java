package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command{
    Drivetrain drivetrain;
    Joystick rightJoystick, leftJoystick;

    public Drive(Drivetrain drivetrain, Joystick leftStick, Joystick rightStick){
        leftJoystick = leftStick;
        rightJoystick = rightStick;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        drivetrain.drive(-leftJoystick.getY(), -rightJoystick.getY());
    }

    @Override
    public void end(boolean interupted){
        drivetrain.stop();
    }
}
