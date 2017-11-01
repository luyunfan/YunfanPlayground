import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.List;

/**
 * 模仿.Net平台的Console类实现
 */
public class Console {
    public static void main(String[] args) throws Throwable {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        MethodHandle methodHandle = MethodHandles.publicLookup().findVirtual(ArrayList.class, "add", MethodType.methodType(Boolean.TYPE, Object.class));
        methodHandle.invoke(list, "Test");
        System.out.println(list);
    }
}
