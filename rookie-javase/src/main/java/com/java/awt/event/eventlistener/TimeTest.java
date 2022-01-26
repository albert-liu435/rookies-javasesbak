package com.java.awt.event.eventlistener;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @Classname TimeTest
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:43
 * @Version 1.0
 */
public class TimeTest {

    public static void main(String[] args) {
        ActionListener listener=new TimePrinter();

        Timer t=new Timer(10000,listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");

        System.exit(0);
        //JOptionPane.showMessageDialog();
    }
}
