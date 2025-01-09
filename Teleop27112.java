package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "27112 Omnidrive (Java)")
public class Teleop27112 extends LinearOpMode {

  private DcMotor back_left_motor;
  private DcMotor front_left_motor;
  private DcMotor front_right_motor;
  private DcMotor back_right_motor;
  private DcMotor arm_slide;
  
  @Override
  public void runOpMode() {
    double Speed;

    back_left_motor = hardwareMap.get(DcMotor.class, "back_left_motor");
    front_left_motor = hardwareMap.get(DcMotor.class, "front_left_motor");
    front_right_motor = hardwareMap.get(DcMotor.class, "front_right_motor");
    back_right_motor = hardwareMap.get(DcMotor.class, "back_right_motor");
    arm_slide = hardwareMap.get(DcMotor.class, "Arm Slide");

    // Put initialization blocks here.
    front_right_motor.setDirection(DcMotor.Direction.REVERSE);
    Speed = 0.5;
    back_right_motor.setDirection(DcMotor.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad1.b) {
          Speed = 0;
        } else if (gamepad1.left_trigger >= 0.3) {
          Speed = 1;
        } else if (gamepad1.right_trigger >= 0.3) {
          Speed = 0.2;
        } else if (gamepad1.left_bumper) {
          Speed = 0.75;
        } else if (gamepad1.right_bumper) {
          Speed = 0.35;
        } else {
          Speed = 0.5;
        }
        front_left_motor.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x) + gamepad1.right_stick_x) * Speed);
        front_right_motor.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x) * Speed);
        back_left_motor.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x) + gamepad1.right_stick_x) * Speed);
        back_right_motor.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * Speed);
        if (gamepad1.dpad_up) {
          arm_slide.setPower(0.6);
        } else if (gamepad1.dpad_down) {
          arm_slide.setPower(-0.6);
        } else {
          arm_slide.setPower(0);
        }
      }
    }
  }
}
