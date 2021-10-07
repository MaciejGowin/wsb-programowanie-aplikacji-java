public class Main {

    public static void main(String[] args) {
        int age = 17;

        if (age < 18) {
            System.out.println("Warning!");
        }

        String type = (age < 18) ? "Child": "Adult";
        System.out.printf("You are: %s\n", type);
    }
}
