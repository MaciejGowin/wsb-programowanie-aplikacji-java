class Top {
    protected String name = "top";
}

class Middle extends Top {
    protected String name = "middle";
}

class Low extends Middle {
    protected String name = "low";

    public void checkSuper() {
        System.out.println(name);
        System.out.println(super.name);
        System.out.println(((Middle) this).name);
        System.out.println(((Top) this).name);
    }
}

public class SuperOfSuper {

    public static void main(String[] args) {
        Low low = new Low();
        low.checkSuper();
    }
}
