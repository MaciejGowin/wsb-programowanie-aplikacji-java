public class Main {

    public static void main(String[] args) {
        parametersReturns(2);
        parametersNoReturn(0);
        noneParametersReturns();
        noneParametersNoneReturn();
    }

    public static int parametersReturns(int parameter) {
        int result;
        if (parameter < 10) {
            result = parameter * 10;
        } else {
            result = parameter * 20;
        }
        System.out.printf("parameters: %s, returns: %s\n", parameter, result);
        return result;
    }

    public static void parametersNoReturn(int parameter) {
        if (parameter == 0) {
            return;
        }
        System.out.printf("parameters: %s, returns: %s\n", parameter, "none");
    }

    public static int noneParametersReturns() {
        int result = 1;
        System.out.printf("parameters: %s, returns: %s\n", "none", result);
        return result;
    }

    public static void noneParametersNoneReturn() {
        System.out.printf("parameters: %s, returns: %s\n", "none", "none");
    }
}
