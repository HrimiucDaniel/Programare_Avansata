public class Lab1 {
    public static int digitsum(int n) {
        int s = 0;
        while (n >= 10) {
            s = 0;
            while (n > 0) {
                s = s + n%10;
                n /= 10;
            }
            n = s;
        }
        return n;
    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        int result;

        System.out.println(n);

        n *= 3;
        System.out.println(n);

        n += 0b10101;
        System.out.println(n);

        n += 0xFF;
        System.out.println(n);

        n *= 6;
        System.out.println(n);

        result = digitsum(n);
        System.out.println(result);

        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]);
    }




}

