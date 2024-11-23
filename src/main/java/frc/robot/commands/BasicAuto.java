package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class BasicAuto extends SequentialCommandGroup{
    public BasicAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){

        new AutoDrive(drivetrain, 0.25, 0.25).withTimeout(1);

        new WaitCommand(3);

        new LiftArm(arm, 0.4).withTimeout(0.5);

        new Shoot(shooter, 5).withTimeout(2);

    }
}
