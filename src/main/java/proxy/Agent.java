package proxy;

import java.lang.reflect.Method;

/**
 * @author Modraed Lau
 */
public class Agent implements ZoInvocationHandler {
    private Subject realSubject;

    public Object getInstance(Subject subject) {
        this.realSubject = subject;
        Class<? extends Subject> clazz = realSubject.getClass();
        return ZoProxy.newProxyInstance(new ZoClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if ("sellBooks".equals(method.getName())) {
            int invoke = (int) method.invoke(realSubject, args);
            System.out.println("调用的是卖书的方法");
            return invoke;
        } else {
            String string = (String) method.invoke(realSubject, args);
            System.out.println("调用的是说话的方法");
            return string;
        }
    }
}
