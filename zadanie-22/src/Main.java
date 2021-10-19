public class Main {

    public static void main(String[] args) {
        System.out.println(normalizeTitle(" W pustyni i w PUSZCZy"));
        System.out.println(normalizeTitle(" o dwóch TAKICH co ukradli      Księżyc"));
        System.out.println(normalizeTitle("pan   tadeusz"));
    }

    public static String normalizeTitle(String value) {
        if (value == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(String subValue: value.split(" ")) {
            String normalizedSubValue = capitalize(subValue.trim());
            if (!normalizedSubValue.isEmpty()) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(normalizedSubValue);
            }
        }
        return stringBuilder.toString();
    }

    public static String capitalize(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }
}


