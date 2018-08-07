import sun.misc.Unsafe;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        FileDescriptor out = (FileDescriptor) unsafe.allocateInstance(FileDescriptor.class);
        unsafe.putInt(out, unsafe.objectFieldOffset(FileDescriptor.class.getDeclaredField("fd")), 1);
        new FileOutputStream(out).write(
                new byte[]{0x48, 0x65, 0x6C, 0x6C,
                        0x6F, 0x20, 0x57, 0x6F, 0x72,
                        0x6C, 0x64
                });
    }
}
