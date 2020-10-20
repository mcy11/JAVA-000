import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yd
 * @version 1.0
 * @date 2020-10-20 15:20
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {

            Class<?> helloClass = new MyClassLoader().findClass("Hello");

            Object object = helloClass.newInstance();

            Method method = helloClass.getMethod("hello");

            method.invoke(object);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(this.getClass().getResource("/Hello.xlass").getPath());
        Long length = file.length();
        byte[] bytes = new byte[length.intValue()];
        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int index = 0; index < bytes.length; index++) {
            bytes[index] = (byte) (255 - bytes[index]);
        }
        return defineClass(name, bytes,0, length.intValue());
    }
}
