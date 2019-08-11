import reflectTest.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz=Class.forName("reflectTest.reflect");
        reflect reflect= (reflectTest.reflect) clazz.newInstance();
        Method method=clazz.getMethod("ask");
        Field field=clazz.getField("name");
        Field field1=clazz.getDeclaredField("password");
       // System.out.println(field.get(clazz));
        field1.setAccessible(true);
        System.out.println(field1.get(reflect));
        method.invoke(reflect);

    }
}
