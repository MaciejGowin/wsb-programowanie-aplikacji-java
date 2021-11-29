public class LineCounter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Specify filename");
            return;
        }

        FileUtils.countLines(args[0]).ifPresent(count -> System.out.printf("Lines: %d%n", count));
    }
}
