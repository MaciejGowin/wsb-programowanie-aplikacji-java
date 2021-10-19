public class Main {

    public static void main(String[] args) {
        System.out.println("--- Standard");
        System.out.println("1, foo: " + new Standard(1, "foo").hashCode());
        System.out.println("1, foo: " + new Standard(1, "foo").hashCode());
        System.out.println("1, bar: " + new Standard(1, "bar").hashCode());
        System.out.println("2, foo: " + new Standard(2, "foo").hashCode());
        System.out.println("2, bar: " + new Standard(2, "bar").hashCode());

        System.out.println("--- ObjectsBased");
        System.out.println("1, foo: " + new ObjectsBased(1, "foo").hashCode());
        System.out.println("1, foo: " + new ObjectsBased(1, "foo").hashCode());
        System.out.println("1, bar: " + new ObjectsBased(1, "bar").hashCode());
        System.out.println("2, foo: " + new ObjectsBased(2, "foo").hashCode());
        System.out.println("2, bar: " + new ObjectsBased(2, "bar").hashCode());

        System.out.println("--- IntellijGenerated");
        System.out.println("1, foo: " + new IntellijGenerated(1, "foo").hashCode());
        System.out.println("1, foo: " + new IntellijGenerated(1, "foo").hashCode());
        System.out.println("1, bar: " + new IntellijGenerated(1, "bar").hashCode());
        System.out.println("2, foo: " + new IntellijGenerated(2, "foo").hashCode());
        System.out.println("2, bar: " + new IntellijGenerated(2, "bar").hashCode());
    }
}
