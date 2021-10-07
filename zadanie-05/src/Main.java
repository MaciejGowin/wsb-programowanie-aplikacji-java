public class Main {

    public static void main(String[] args) {
        int age = 5;
        String animal = "dog";

        if (animal == "cat") {
            if (age > 3) {
                System.out.println("You are an adult cat");
            } else {
                System.out.println("You are a child cat");
            }
        } else if (animal == "dog") {
            if (age > 6) {
                System.out.println("You are an adult dog");
            } else {
                System.out.println("You are a child dog");
            }
        } else {
            System.out.println("Unknown animal");
        }
    }
}
