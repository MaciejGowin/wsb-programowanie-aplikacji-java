public class Main {

    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";
        String s3 = "another";
        String s4 = new String("test");
        String s5 = new String("another");
        String s6 = s1;

        System.out.printf("s1 == s2: %b%n", s1 == s2);
        System.out.printf("s1 == s3: %b%n", s1 == s3);
        System.out.printf("s1 == s4: %b%n", s1 == s4);
        System.out.printf("s1 == s5: %b%n", s1 == s5);
        System.out.printf("s1 == s6: %b%n", s1 == s6);

        System.out.printf("s1 equals s2: %b%n", s1.equals(s2));
        System.out.printf("s1 equals s3: %b%n", s1.equals(s3));
        System.out.printf("s1 equals s4: %b%n", s1.equals(s4));
        System.out.printf("s1 equals s5: %b%n", s1.equals(s5));
        System.out.printf("s1 equals s6: %b%n", s1.equals(s6));
    }
}
