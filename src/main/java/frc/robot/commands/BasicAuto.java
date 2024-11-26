package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class BasicAuto extends SequentialCommandGroup{
             
    public BasicAuto(Drivetrain drivetrain, Arm arm,Shooter shooter){

        addCommands(

            // lift arm to match hight of top port
            new LiftArm(arm, 0.3).withTimeout(1),
    
            //begining of match, despences pre-loaded balls
            new Shoot(shooter, 1).withTimeout(3),
            
            //move backwards, away from chargeport
            new AutoDrive(drivetrain, -0.25, -0.25).withTimeout(2),

            // turn right 
            new AutoDrive(drivetrain, -0.25, 0.25).withTimeout(1),

            new WaitCommand(3),

            //despence ball
            new Shoot(shooter, 5).withTimeout(2)
        );
    }
}
