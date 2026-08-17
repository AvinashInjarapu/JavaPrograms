import java.util.LinkedHashMap;
import java.util.Map;

public class IV_FindFirstNonRepeatingCharacter {

    public static void main(String[] args) {
        firstNonRepeatingCharUsingMap("swiss"); // #1

        firstNonRepeatingCharUsingArray("markram"); // #2 fast and efficient
    }

    public static void firstNonRepeatingCharUsingMap(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        char result = '\0';     // placeholder to mean “no character yet”
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue()==1) {
                result = entry.getKey();
                break;
            }
        }
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static void firstNonRepeatingCharUsingArray(String str) {
        int[] freq = new int[256];
        for (int i=0; i<str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        char result = '\0';
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                result = str.charAt(i);
                break;
            }
        }
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
