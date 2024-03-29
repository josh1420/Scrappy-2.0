// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class TankDrive extends SubsystemBase {
//varibles here
  private VictorSPX leftMotor1 = new VictorSPX(1);
  private VictorSPX leftMotor2 = new VictorSPX(4);
  private VictorSPX rightMotor1 = new VictorSPX(3);
  private VictorSPX rightMotor2 = new  VictorSPX(0);
  
  private CommandXboxController driver;
  
  public TankDrive(CommandXboxController controller) {
   driver = controller;

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
  private void leftSide(double speed){
    leftMotor1.set(VictorSPXControlMode.PercentOutput, speed);
    leftMotor2.set(VictorSPXControlMode.PercentOutput, speed);
    //puts 2 motors together so the programming will be easier from this point on
  }
  private void rightSide(double speed){
    rightMotor1.set(VictorSPXControlMode.PercentOutput, speed);
    rightMotor2.set(VictorSPXControlMode.PercentOutput, speed);
  }
public void Drive(){
   /*switchedDirection = false;
    leftSide.setInverted(switchedDirection);*/
    leftSide(7.25*driver.getLeftY());
    rightSide(7.25*driver.getLeftY());
    // moves the robot forward or backward depening on if you move the joystick  up or down
}


public void Spin(){
   /*  switchedDirection = false;
    leftSide.setInverted(switchedDirection);
    rightSide.setInverted(!switchedDirection);*/
    leftSide(7.25*driver.getRightX());
    rightSide(-7.25*driver.getLeftY());
      //inverts 1 motor and spins both
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Side Voltage", leftMotor1.getMotorOutputVoltage());
    SmartDashboard.putNumber("Right Side Voltage", rightMotor1.getMotorOutputVoltage());
    //shows the voltage going to each side of the drive train in real time
    //updates the values frequently on the motor's inversion state
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
