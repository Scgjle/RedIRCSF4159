// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.TestAuto;
import frc.robot.commands.Drive;
import frc.robot.commands.LiftArm;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
// class v
public class RobotContainer {
  // v this is made in the Drivetrain file and sets up commands such as drive and stop wich tell the motors to move in specific ways
  private final Drivetrain drivetrain = new Drivetrain();
  // v these have been made in the wiplib thing and connect the joysticks to the robot
  private final Joystick righJoystick = new Joystick(2);
  private final Joystick lefJoystick = new Joystick(1);
  // v this is made in the Drive file, it tells the robot to drive at a certain speed given how far the joysticks are pushed
  private final Drive drive = new Drive(drivetrain, righJoystick, lefJoystick);
  // arm constructor!! 
  private final Arm arm = new Arm();
  // shooter constructor, adds motor(s) connected with the shooter mechanism
  private final Shooter motor = new Shooter();
  // connects joystick button 3 on each joystick -> the arm moving up or down
  private JoystickButton armDownButton = new JoystickButton(lefJoystick, 3);
  private JoystickButton armUpButton = new JoystickButton(righJoystick, 3);
  // connects joystick button 1 on each joystick -> the shooter (either shooting the ball OUT or bringing the ball IN)
  private JoystickButton moveinbutton = new JoystickButton(righJoystick, 1);
  private JoystickButton moveoutbutton = new JoystickButton(lefJoystick, 1);


  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  public RobotContainer() {
    // Configure the trigger bindings

    configureBindings();
    // tells the robot to follow drive commands during teleop
    drivetrain.setDefaultCommand(drive);

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // v the button specified in RobotContainer to do a specific task (eg. armUpButton is button 3 on the right joystick)
    armUpButton.whileTrue(new LiftArm(arm,0.2)); // <- executes the LiftArm function, giving the speed variable a value of 0.2
    //            ^ while button being held is true, do ()           // ^ this makes the base motor always turn at a speed of 0.2
    armDownButton.whileTrue(new LiftArm(arm, -0.2)); // <- inverts the speed of the base motor to make it turn the other way
    moveinbutton.whileTrue(new Shoot(motor, 0.5));
    moveoutbutton.whileTrue(new Shoot(motor, -0.5));
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new TestAuto(drivetrain, arm, motor);
  }
}
