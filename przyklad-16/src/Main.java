public class Main {

    public static void main(String[] args) {
        getStateOfSwitchBreak(0);
        getStateOfSwitchNoBreak(0);
    }

    public static void getStateOfSwitchBreak(int i) {
        switch (i) {
            case 0:
                System.out.println("getStateOfSwitchBreak: index 0");
            case 1:
                System.out.println("getStateOfSwitchBreak: index 1");
            default:
                System.out.println("getStateOfSwitchBreak: index 2");
        }
    }

    public static void getStateOfSwitchNoBreak(int i) {
        switch (i) {
            case 0:
                System.out.println("getStateOfSwitchNoBreak: index 0");
                break;
            case 1:
                System.out.println("getStateOfSwitchNoBreak: index 1");
                break;
            default:
                System.out.println("getStateOfSwitchNoBreak: index 2");
        }
    }
}

