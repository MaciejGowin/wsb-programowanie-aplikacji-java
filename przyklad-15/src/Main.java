public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.printf("=== Testing: %d%n", i);
            System.out.printf("State of switch: %s%n", getStateOfSwitch(i));
            System.out.printf("State of if: %s%n", getStateOfIf(i));
        }
    }

    public static String getStateOfSwitch(int i) {
        String state;
        switch (i) {
            case 0:
                state = "stop";
                break;
            case 1:
                state = "low-speed";
                break;
            case 2:
                state = "top-speed";
                break;
            default:
                state = "unknown";
        }
        return state;
    }


    public static String getStateOfIf(int i) {
        String state;
        if (i == 0) {
            state = "stop";
        } else if (i == 1) {
            state = "low-speed";
        } else if (i == 2) {
            state = "top-speed";
        } else {
            state = "unknown";
        }
        return state;
    }
}

