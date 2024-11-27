package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class BasicAuto extends SequentialCommandGroup{
    public BasicAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){
        addCommands(

        new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(1),
        
        new WaitCommand(1),

        //turns 180 left
        new AutoDrive(drivetrain, 0.35, -0.35).withTimeout(1.6),

        new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(0.5),

        new AutoDrive(drivetrain, -0.25, -0.25).withTimeout(0.5),

        new WaitCommand(1),

        //turns 180 right
        new AutoDrive(drivetrain, -0.35, 0.35).withTimeout(1.6),

        new LiftArm(arm, 0.4).withTimeout(0.5)

        );

    }
}
