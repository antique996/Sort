package single;

public class Holder {

    private Holder() {

    }

    public static Holder getInstance() {
        return Inner.HOLDER;
    }

    public static class Inner {
        private static final  Holder HOLDER = new Holder();
    }

}
