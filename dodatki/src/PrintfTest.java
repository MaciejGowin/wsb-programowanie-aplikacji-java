public class PrintfTest {

    public static void main(String[] args) {
        // https://www.baeldung.com/java-printstream-printf
        /*
            s formats strings.
            d formats decimal integers.
            f formats floating-point numbers.
            t formats date/time values.
         */

        int myInt = 7;
        double myDouble = 1.23956;
        String myString = "test";

        System.out.printf("Format 1: myInt: %s: myDouble: %s: myString: %s\n", myInt, myDouble, myString);
        System.out.printf("Format 2: myInt: %d: myDouble: %f: myString: %s\n", myInt, myDouble, myString);
        System.out.printf("Format 3: myString: %12s\n", myString);
        System.out.printf("Format 4: myDouble: %12s\n", myDouble);
        System.out.printf("Format 5: myDouble: %.2f\n", myDouble);
        System.out.printf("Format 6: myDouble: %5.2f\n", myDouble);
    }
}
