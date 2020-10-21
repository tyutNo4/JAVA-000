
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * 测试类
 *
 * @author 李家宁
 * @date 2020/10/21 18:14
 */
public class MainTest {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        CustomerClassloader customerClassloader = new CustomerClassloader();

		String path = "H:\\tyutNo4\\workspace_geektime\\JAVA-000\\Week_01\\classloader\\";
		
//        File file = new File(path + "Test.class");
        File file = new File(path + "Hello.xlass");

//        String className = "Test";
        String className = "Hello";
//        String methodName = "test";
        String methodName = "hello";

//        byte[] b = FileUtils.readFileToByteArray(file);
        byte[] oriB = FileUtils.readFileToByteArray(file);
        byte[] b = new byte[oriB.length];
        for (int i = 0; i < oriB.length; i++) {
            b[i] = (byte) (255 - oriB[i]);
        }

        Class<?> defineClass = customerClassloader.defineClass(className, b);
        Method method = defineClass.getMethod(methodName);
        method.invoke(defineClass.newInstance());
    }

}
