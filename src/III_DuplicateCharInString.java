import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class III_DuplicateCharInString {
    public static void main(String[] args) {
        String str = "programming";
        System.out.println("Original String: " + str);

        findDuplicateCharactersUsingMap(str); // #1 Using Map

        findDuplicateCharsUsingSet(str); // #2 Using Set
    }

    public static void findDuplicateCharactersUsingMap(String str) {
        HashMap <Character, Integer> hm = new HashMap<>();

        for (char ch: str.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        System.out.println("Duplicate characters found using Map :");
        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() +" -> " + entry.getValue() + " times");
            }
        }
    }

    public static void findDuplicateCharsUsingSet(String str) {
        HashSet <Character> seen = new HashSet<>();
        HashSet <Character> duplicates = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c);
            } else {
                seen.add(c);
            }
        }
        System.out.println("Duplicate characters found using Set : " +duplicates);
    }
}
