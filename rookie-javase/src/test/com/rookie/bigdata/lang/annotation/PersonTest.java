package com.rookie.bigdata.lang.annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Classname PersonTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/10/22 16:52
 * @Version 1.0
 */
public class PersonTest {


    @Test
    public void test1() throws Exception {
        Class<?> personClass = ClassLoader.getSystemClassLoader().loadClass("com.rookie.bigdata.lang.annotation.Person");

        Person personInstance = (Person) personClass.newInstance();
        Method method = personClass.getMethod("boy", new Class[]{String.class});

        method.invoke(personInstance, new Object[]{"张三"});

        //获取注解上面的值
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            //获取上面的注解
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            //获取注解的值
            String[] value = annotation.value();
            for (String s : value) {
                System.out.println(s);
            }
        }
    }


    @Test
    public void test2() {

        BigDecimal bigDecimal=new BigDecimal(12);
        System.out.println(bigDecimal);




        BigDecimal limitNum = test32();
        System.out.println(limitNum);


        if (limitNum == null || limitNum.intValue() <= 0) {
            System.out.println(limitNum);

        }


        List<String> list = new ArrayList<>();
        list.add("he");
        list.add("ds");

        for (int i = 0; i < list.size(); i++) {
            if (limitNum == null || limitNum.intValue() <= 0) {

                list.remove(i);
                i--;
                continue;
            }


        }
    }


    public BigDecimal test32() {
        // 会员限领取的数量
        BigDecimal memberGetNumberLimit = new BigDecimal(3);
        // 模板限领总量
        BigDecimal couponSendNum = new BigDecimal(200);
        // 模板已发送总量
        BigDecimal couponCreateNum = new BigDecimal(229);


        BigDecimal limitSend = new BigDecimal("0");
        if (memberGetNumberLimit != null && memberGetNumberLimit.intValue() > 0) {
            limitSend = new BigDecimal(memberGetNumberLimit.intValue() - 1);
        }
        if (null == couponSendNum || couponSendNum.compareTo(BigDecimal.ZERO) == 0) {
            return limitSend;
        }
        if (null == couponCreateNum) {
            couponCreateNum = BigDecimal.ZERO;
        }
        BigDecimal subtract = couponSendNum.subtract(couponCreateNum);
        if (subtract.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ZERO;
        }
        if (limitSend.compareTo(subtract) < 1) {
            return limitSend;
        } else {
            return subtract;
        }
    }


    @Test
    public void test11(){

        String str="137268794924842367, 91001786917938683, 137254321022517845, 137220264577521076, 137283444815318110, 137328121025452856, 137210976825847649, 137294964019145893, 137361386659684374, 137408187017667864, 137417367446342140, 137325781678667864, 137331937460365060, 137328445280821076, 137358686638100353, 137283410240210886, 137296586308581214, 137248597238500790, 90948324520118829, 137341155426336127, 137219400278424502, 137285102146182244, 137282006218065845, 90934500379859471, 137298098025433912, 137397999790255887, 137218464753666518, 137219796755665344, 137272718945910958, 137329923994244819, 137291330102777643, 137332047288171027, 137265445244214019, 137241145761493023, 91015646610459507, 137325241368221756, 137300688022392545, 137248525288860396, 137334891545057235, 137237257784391933, 137221632124843948, 137411463456228260, 137200644259326273, 137220480632350683, 137420391338647995, 137253241132170908, 137344035566881165, 137423019380727008, 137286506482976093, 137209680684596936, 137365058404232044, 91055427397118829, 137211804473244819, 137369810823170607, 137266129036094343, 137257849569166761, 137247697352815572, 90937236292909379, 137256589626976093, 137215548944296264, 137362790122318051, 91016546787389973, 137392203866156418, 90938064422239362, 137244133145213764, 137242549173492083, 137266634531213764, 91006466310398965, 137284310694901561, 137415135261193929, 90948612727129965, 137254501152817060, 90949656079648728, 137424567480396115, 137348965452282036, 91003874951418665, 137247301258595312, 137275344763804555, 137202912630632913, 137287548950507469, 91018562404089462, 137337949247872461, 137269334974746967, 137292048118184317, 137245609622595312, 90935580904088929, 137280170276846237, 137244169042891383, 137328123268981152, 137411175680446335, 137272646712122390, 137068526508133977, 137292338506651407, 137345725823282036, 137339823216450945, 137199852639803550, 137318833759212919, 137413839334896995, 137286036693750761, 137393679777046440";

        String[] split = str.split(",");
        for (String s : split) {
            String trim = s.trim();

            trim="'"+trim+"',";
            System.out.println(trim);


        }

    }


}