package yml.minla.jnitest.jnipack;

public class JniTest {

    static {
        System.loadLibrary("minla_core");
    }

    public native String getJniLibraryName();


}
