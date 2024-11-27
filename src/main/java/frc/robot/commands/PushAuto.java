package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class BasicAuto extends SequentialCommandGroup{
             
    public PushAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){

        addCommands(
            //waits for alliance member to finish thier auto
            new WaitCommand(5),

            //pushes robot
            new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(3),

            //re-allines with port
            new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(1),

            //moves the robot right
            new AutoDrive(drivetrain, 0.2, -0.2).withTimeout(1),

            //pushes against the port
            new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(1),

            //shoots the ball
            new Shoot(shooter, 1).withTimeout(1),

            //moves robot back to original position
            new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(4)
        );
    }
}