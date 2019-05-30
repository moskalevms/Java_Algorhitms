public class Degree {
    public static void main(String[] args) {
        System.out.println(degree(5, 4));
    }

    private static int degree(int num, int deg) {
        if (deg != 1) {
            return num * degree(num, deg - 1);
        } else
            return num;
    }
}
