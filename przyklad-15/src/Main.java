public class Main {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("State of switch: " + getStateOfSwitch(i));
        System.out.println("State of switch: " + getStateOfInt(i));
    }

    public static String getStateOfSwitch(int i) {
        String state;
        switch (i) {
            case 0:
                state = "stop";
            case 1:
                state = "low-seed";
            case 2:
                state = "top-speed";
            default:
                state = "unknown";
        }
        return state;
    }


    public static String getStateOfInt(int i) {
        String state;
        if (i == 0) {
            state = "stop";
        } else if (i == 1) {
            state = "low-seed";
        } else if (i == 2) {
            state = "top-speed";
        } else {
            state = "unknown";
        }
        return state;
    }
}

