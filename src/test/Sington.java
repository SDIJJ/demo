package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/4/9 20:14
 * @version: v1.0.0
 */
public class Sington {
    private Sington() {
    }

    static class SingtonInstance {
        private static Sington instance = new Sington();
    }

    public static Sington getInstance() {
        return SingtonInstance.instance;
    }
}
