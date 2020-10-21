
/**
 * 自定义Classloader<br>
 * <p>单例 TODO</p>
 * <p>重写defineClass()</p>
 *
 * @author 李家宁
 * @date 2020/10/21 18:13
 */
public class CustomerClassloader extends ClassLoader{

    Class<?> defineClass(String name, byte[] b) throws ClassFormatError {
        return defineClass(name, b, 0, b.length, null);
    }
}
