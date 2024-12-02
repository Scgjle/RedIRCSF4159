package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class TestAuto extends SequentialCommandGroup{
             
    public TestAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){

        addCommands(
            // robot waits for 3 seconds before moving
           new WaitCommand(3),

            //shoots the ball
           // new Shoot(shooter, 1).withTimeout(1),

            //turns
             new AutoDrive(drivetrain, 0.35, -0.35) .withTimeout(2.78),

            //lifts arm
            new LiftArm(arm, 0.25) .withTimeout(2),

            //turns back 
            new AutoDrive(drivetrain, -0.35, 0.35) .withTimeout(2.78)
        );
    }
}
