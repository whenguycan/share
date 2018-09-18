import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author WANG
 * @date 2018/9/18 19:49
 */
public class Robot1 {

    public static void main(String[] args) {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void go() throws Exception {
        Robot robot = new Robot();
        Rectangle rect = new Rectangle(100, 100, 100, 100);
        BufferedImage img = robot.createScreenCapture(rect);
        ImageIO.write(img, "png", new File("C:\\Users\\Administrator\\Desktop\\x.png"));
    }

}
