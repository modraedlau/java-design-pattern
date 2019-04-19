package proxy;

import java.lang.reflect.Method;

/**
 * @author Modraed Lau
 */
public interface ZoInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
