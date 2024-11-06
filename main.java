package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "_27112Omnidrive (Blocks to Java)")
public class _27112Omnidrive extends LinearOpMode {

  private DcMotor back_left_motor;
  private DcMotor front_left_motor;
  private DcMotor front_right_motor;
  private DcMotor back_right_motor;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    double Speed;

    back_left_motor = hardwareMap.get(DcMotor.class, "back_left_motor");
    front_left_motor = hardwareMap.get(DcMotor.class, "front_left_motor");
    front_right_motor = hardwareMap.get(DcMotor.class, "front_right_motor");
    back_right_motor = hardwareMap.get(DcMotor.class, "back_right_motor");

    // Put initialization blocks here.
    back_left_motor.setDirection(DcMotor.Direction.REVERSE);
    Speed = 0.5;
    front_left_motor.setDirection(DcMotor.Direction.REVERSE);
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
        front_left_motor.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * Speed);
        front_right_motor.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x) * Speed);
        back_left_motor.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * Speed);
        back_right_motor.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x) + gamepad1.right_stick_x) * Speed);
        // Put loop blocks here.
        telemetry.update();
      }
    }
  }
}
