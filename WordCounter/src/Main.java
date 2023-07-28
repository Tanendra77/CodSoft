import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t______________________________________________________________");
        System.out.println("\t\t\t\t\t\tWORD COUNTER");
        System.out.println("\t______________________________________________________________");

        System.out.print("\n\tENTER THE TEXT : ");
        String input = scanner.nextLine();

        String[] words = input.split("[\\s\\p{Punct}]+");// Splitting the word

        int wordCount = words.length;//count no of words

        Map<String, Integer> wordFrequency = new HashMap<>();// 2d array to store word

        for (String word : words) {
            String normalizedWord = word.toLowerCase();//convert the word

            wordFrequency.put(normalizedWord, wordFrequency.getOrDefault(normalizedWord, 0) + 1);
        }

        System.out.println("\n\tTotal number of words: " + wordCount);
        System.out.println("\tDuplicate words:");

        int dw=1;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {// show the duplicate word
            if (entry.getValue() > 1) {
                System.out.println("\t\t"+ dw++ +") " + entry.getKey() + ": " + entry.getValue());//display duplicate word
            }
        }

        scanner.close();
    }
}