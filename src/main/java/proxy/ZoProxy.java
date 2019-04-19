package proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Modraed Lau
 */
public class ZoProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(ZoClassLoader loader,
                                          Class<?>[] interfaces,
                                          ZoInvocationHandler h) {

        try {
            // 1、动态生成源代码
            String src = generateSrc(interfaces);
            System.out.println(src);

            // 2、Java文件输出到磁盘
            String filePath = ZoProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(ZoInvocationHandler.class);

            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package proxy;" + ln);

        sb.append("import java.lang.reflect.*;" + ln);

        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("ZoInvocationHandler h;" + ln);
        sb.append("public $Proxy0(ZoInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);

            sb.append("try {" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + ln);
            sb.append("return (" + m.getReturnType().getName() + ") this.h.invoke(this, m, null);" + ln);
            sb.append("} catch (Throwable e) {" + ln);
            sb.append("throw new RuntimeException(e.getCause());" + ln);
            sb.append("}" + ln);

            sb.append("}" + ln);
        }

        sb.append("}" + ln);

        return sb.toString();
    }
}
