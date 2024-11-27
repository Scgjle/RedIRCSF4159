package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class BasicAuto extends SequentialCommandGroup{
             
    public TestAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){

        addCommands(
            //shoots the ball
            new Shoot(shooter, 1).withTimeout(1),

            //lifts arm or pivits shooter
            new LiftArm(arm, 0.2).withTimeout(1),

            //moves the robot left
            new AutoDrive(drivetrain, -0.2, 0.2).withTimeout(1),

            //moves robot back to original position
            new AutoDrive(drivetrain, 0.2, -0.2).withTimeout(1)
        );
    }
}
