package com.java.awt.event.eventlistener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Classname TimePrinter
 * @Description TODO
 * @Author rookie
 * @Date 2022/1/6 11:41
 * @Version 1.0
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is " + new Date());

        Toolkit.getDefaultToolkit().beep();
    }
}
