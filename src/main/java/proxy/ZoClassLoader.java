package proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Modraed Lau
 */
public class ZoClassLoader extends ClassLoader {

    private File classPathFile;

    public ZoClassLoader() {
        String classPath = ZoClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = ZoClassLoader.class.getPackage().getName() + "." + name;
        File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
        if (classFile.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
