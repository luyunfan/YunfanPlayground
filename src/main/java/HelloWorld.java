import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class HelloWorld {

    public static void main(String[] args) throws Exception {

        Method standardStream = FileDescriptor.class.getDeclaredMethod("standardStream", int.class);
        standardStream.setAccessible(true);
        new PrintStream(new FileOutputStream((FileDescriptor) standardStream.invoke(null, 1))).println("Hello World");
    }
}