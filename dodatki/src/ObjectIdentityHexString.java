public class ObjectIdentityHexString {

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);
        System.out.println(Integer.toHexString(car.hashCode()));

        System.out.println("----");
        String string1 = "Test";
        System.out.println(string1);
        System.out.println(Integer.toHexString(string1.hashCode()));

        System.out.println("----");
        String string2 = "Test";
        System.out.println(string2);
        System.out.println(Integer.toHexString(string2.hashCode()));

        System.out.println("----");
        System.out.println(Integer.toHexString("Test".hashCode()));
        System.out.println(Integer.toHexString("Test".hashCode()));
        System.out.println(Integer.toHexString(new String("Test").hashCode()));
        System.out.println(System.identityHashCode("Test"));
        System.out.println(System.identityHashCode("Test"));
        System.out.println(System.identityHashCode(new String("Test")));
    }
}

class Car {
}
