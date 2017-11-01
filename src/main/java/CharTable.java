public class CharTable {

    private static String unicodeToString(int codePoint) {
        final int high = 0xD800;
        final int low = 0xDC00;
        final int max = 0x10FFFF;
        if (codePoint < 0 || codePoint > max) {
            throw new RuntimeException("编码超出标准范围！");
        } else if (codePoint < high || (codePoint > 0xDFFF && codePoint < 0xFFFF)) {
            return "" + (char) codePoint;
        } else {
            int charNum = codePoint - 0x10000;
            char firstCode = (char) (high | (charNum >> 10));
            char secondCode = (char) (low | (charNum << 21 >> 21));
            return new String(new char[]{firstCode, secondCode});
        }
    }

    public static void main(String[] args) {
        System.out.println(123 << 12 >> 12);
        System.out.println(123 ^ 12);
        System.out.println('龥' + 1);
        System.out.println(unicodeToString(120));
        System.out.println(unicodeToString(20320));
        System.out.println(unicodeToString(64321));
        System.out.println(unicodeToString(40869));
    }
}
