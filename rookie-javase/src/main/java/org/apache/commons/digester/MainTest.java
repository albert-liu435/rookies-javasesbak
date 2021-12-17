package org.apache.commons.digester;

import org.apache.commons.digester3.Digester;

import java.io.File;

/**
 * @Classname MainTest
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/16 11:10
 * @Version 1.0
 */
public class MainTest {

    public static void main(String[] args) throws Exception{

        Digester digester = new Digester();
        digester.setValidating(false);

        //匹配department节点时，创建Department对象
        digester.addObjectCreate("department", Department.class);
        //匹配department节点时，设置对象属性
        digester.addSetProperties("department");
        //匹配department/user节点时，创建User对象
        digester.addObjectCreate("department/user", User.class);
        //匹配department/user节点时，设置对象属性
        digester.addSetProperties("department/user");
        //匹配department/user节点时，设置Department对象的addUser方法
        digester.addSetNext("department/user", "addUser");
        //匹配department/extension节点时，调用Department对象的puutExtension方法
        digester.addCallMethod("department/extension", "putExtension", 2);
        //调用方法的第一个参数为节点department/extension/property-name的内容
        digester.addCallParam("department/extension/property-name", 0);
        //        //调用方法的第二个参数为节点department/extension/property-value的内容
        digester.addCallParam("department/extension/property-value", 1);


        Department department=(Department)digester.parse(new File("C:\\work\\IDEAWorkSpace\\rookie-project\\haizhilangzigithub\\rookies-javases\\rookie-javase\\src\\main\\resources\\org\\test.xml"));
        System.out.println(department);

    }
}
