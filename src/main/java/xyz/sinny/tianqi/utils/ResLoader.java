package xyz.sinny.tianqi.utils;

import java.io.InputStream;

public class ResLoader {
    ClassLoader defaultClassLoader;
    ClassLoader systemClassLoader;

    public ResLoader() {
        try{
            systemClassLoader = ClassLoader.getSystemClassLoader();
        } catch (SecurityException ignored) {
            ignored.printStackTrace();
        }
    }

    public InputStream loadJsonExample(){
        InputStream input = getResourceAsStream("jsonExample.json");
        return input;
    }



    InputStream getResourceAsStream(String res){
        return getResourceAsStream(null, res);
    }

    private InputStream getResourceAsStream(ClassLoader classLoader, String res) {
        return getResourceAsStream(res, getClassLoader(classLoader));
    }

    // 按照顺序选用其中的一个
    private InputStream getResourceAsStream(String res, ClassLoader[] classLoader) {
        for (ClassLoader cl : classLoader) {
            if (null != cl) {

                InputStream returnValue = cl.getResourceAsStream(res);

//                if (null != returnValue){
//                    returnValue = cl.getResourceAsStream("/"+res);
//                }

                if (null != returnValue){
                    return returnValue;
                }
            }
        }

        return null;
    }


    // 五个类加载器 选用其中一个
    private ClassLoader[] getClassLoader(ClassLoader classLoader) {
        return new ClassLoader[]{
                classLoader,
                defaultClassLoader,
                Thread.currentThread().getContextClassLoader(),
                getClass().getClassLoader(),
                systemClassLoader
        };
    }
}
