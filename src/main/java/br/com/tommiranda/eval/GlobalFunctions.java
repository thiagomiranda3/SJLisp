package br.com.tommiranda.eval;

import br.com.tommiranda.lang.GlobalFunction;
import br.com.tommiranda.utils.Util;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class GlobalFunctions {

    private static final Map<String, Func> mapFunc = createMap();

    private static Map<String, Func> createMap() {
        Map<String, Func> mapFunc = new HashMap<>();

        Reflections reflections = new Reflections("br.com.tommiranda.lang", new MethodAnnotationsScanner());
        Set<Method> annotatedMethods = reflections.getMethodsAnnotatedWith(GlobalFunction.class);

        for (Method method : annotatedMethods) {
            String funcName = method.getAnnotation(GlobalFunction.class).value();
            if (Util.isNullOrEmpty(funcName)) {
                funcName = method.getName();
            }

            mapFunc.put(funcName, values -> {
                try {
                    return method.invoke(null, values);
                } catch (Exception e) {
                    if (e.getCause() != null) {
                        throw (Exception) e.getCause();
                    }

                    throw e;
                }
            });
        }

        return mapFunc;
    }

    public static void addFunction(String name, Func func) {
        mapFunc.put(name, func);
    }

    public static Func getFunc(String name) throws NoSuchMethodException {
        Func func = mapFunc.get(name);

        if (func != null) {
            return func;
        }

        throw new NoSuchMethodException(name + " method undefined");
    }
}
