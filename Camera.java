package moe.atalanta.robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Camera {

    /**
     * 0、选择召唤师界面
     * 1、召唤师站街界面
     * 2、召唤师站街打开地图界面
     * 3、召唤师站街打开地图且蓝点位置在格蓝迪外界面
     * 4、地下城选择界面
     * 5/6、地图1打怪/通关界面
     * 7/8、地图2打怪/通关界面
     * 9/10、地图3打怪/通关界面
     * 11/12、地图4打怪/通关界面
     * 13/14、地图5打怪/通关界面
     * 15/16、地图6打怪/通关界面
     * 17/18、地图7打怪/通关结算界面
     *
     * 【0-4】【18】使用像素点判断
     * 【5-17】使用图像对比
     *
     * 91、使用ObjectDetection确定召唤师位置
     *
     * 92、每一步操作都应该确保该步操作已经正确执行，否则将持续操作并检测
     * 进行每一步操作前应判断状态，是否应该执行该步操作
     * 目前先不做检测，直接顺序执行
     * 后期将重构成根据当前状态决定下一步操作的switch结构
     */

    static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        }catch(Exception e){

        }
        try {

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void capture(Rectangle rectangle){
        BufferedImage im = robot.createScreenCapture(rectangle);
        try {
            File file = new File("E:\\dnf_capture", "capture_" + System.currentTimeMillis() + ".png");
            ImageIO.write(im, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    interface Maps{

    }

    interface MapLabels{

    }

    interface Pixels{

    }

    interface PixelColorRGBs{

    }

}
