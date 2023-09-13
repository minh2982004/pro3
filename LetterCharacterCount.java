package lettercharactercount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LetterCharacterCount {

    private Map<Character, Integer> charCount = new HashMap<>();
    private Map<String, Integer> wordCount = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        LetterCharacterCount count = new LetterCharacterCount();
        count.analyze(content);
        count.display();
    }

    public void display() {
        System.out.println("Character Counts:");
        System.out.print("{");
        boolean firstChar = true;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (!firstChar) {
                System.out.print(", ");
            } else {
                firstChar = false;
            }
            System.out.print(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("}");

        System.out.println("Word Counts:");
        System.out.print("{");
        boolean firstWord = true;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (!firstWord) {
                System.out.print(", ");
            } else {
                firstWord = false;
            }
            System.out.print(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("}");
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (!charCount.containsKey(ch)) {
                charCount.put(ch, 1);
            } else {
                charCount.put(ch, charCount.get(ch) + 1);
            }
        }

        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, wordCount.get(token) + 1);
            }
        }
    }
}
