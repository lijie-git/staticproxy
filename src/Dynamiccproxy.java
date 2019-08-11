import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dynamiccproxy {
    public static void main(String[] args) {
        Student student=new Student();
        InvocationHandler invocationHandler=new StuInvocation(student);
        person stuProxy= (person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},invocationHandler);
        stuProxy.Marry();
    }

}
interface Person{
     void giveMoney();
}
class Student implements Person{

    @Override
    public void giveMoney() {
        System.out.println("上缴班费50元");
    }
}
class StuInvocation<T> implements InvocationHandler{
    T target;
    public StuInvocation(T target){
        this.target=target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=method.invoke(target,args);
        return result;
    }
}

