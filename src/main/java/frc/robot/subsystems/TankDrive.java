// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class TankDrive extends SubsystemBase {
//varibles here
  private WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(0);
  private WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(3);
  private WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(4);
  private WPI_VictorSPX rightMotor2 = new  WPI_VictorSPX(1);
 
  private DifferentialDrive driveSys;
  
  private CommandXboxController driver;
  
  public TankDrive(CommandXboxController controller) {
   leftMotor2.follow(leftMotor1);
   rightMotor2.follow(rightMotor1);
    driver = controller;
 driveSys = new DifferentialDrive(leftMotor1, rightMotor1);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
 
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */

public void Drive(){
   /*switchedDirection = false;
    leftSide.setInverted(switchedDirection);*/
    driveSys.arcadeDrive(driver.getLeftY(), driver.getRightX());
    // moves the robot forward or backward depening on if you move the joystick  up or down
}


/*public void Spin(){
   /*  switchedDirection = false;
    leftSide.setInverted(switchedDirection);
    rightSide.setInverted(!switchedDirection);
    leftSide(7.25*driver.getRightX());
    rightSide(-7.25*driver.getLeftY());
      //inverts 1 motor and spins both*/



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
    //shows the voltage going to each side of the drive train in real time
    //updates the values frequently on the motor's inversion state
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
