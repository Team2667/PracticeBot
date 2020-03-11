package frc.robot.coprocessor;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import java.nio.ByteBuffer;

public class Lidar {
    private static I2C Wire;

    public static void initI2c(){
		Wire = new I2C(Port.kOnboard, 4);
    }
    
    public static int getDistance() {
        int numbytes = 4;
        byte[] returnData = new byte[numbytes];
        Wire.readOnly(returnData, numbytes);
		return ByteBuffer.wrap(returnData, 0, 4).getInt();
	}
}