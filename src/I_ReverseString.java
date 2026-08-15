public class I_ReverseString {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println("Original String: " + str);

        String reversedStr = usingStringBuilder(str);
        System.out.println("Reversed String: " + reversedStr); // #1 Preferred

        String loopReversed = usingLoop(str);
        System.out.println("Reversed String (using loop): " + loopReversed); // #2

        String loopWithLeftRightReversed = usingLoopWithLeftRightLength(str);
        System.out.println("Reversed String (using loop with left-right length): " + loopWithLeftRightReversed); // #3 Fastest

        String recursionReversed = usingRecursion(str);
        System.out.println("Reversed String (using recursion): " + recursionReversed); //#4
    }

    public static String usingStringBuilder(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static String usingLoop (String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static  String usingLoopWithLeftRightLength (String str) {
        if(str == null || str.length() <= 1) {
            return str;
        }
        int left = 0, right = str.length()-1;
        char ch[] = str.toCharArray();
        while(left<right) {
            char temp = ch[left];
            ch[left]  = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }

    public static String usingRecursion(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return usingRecursion(str.substring(1)) + str.charAt(0);
    }

}
