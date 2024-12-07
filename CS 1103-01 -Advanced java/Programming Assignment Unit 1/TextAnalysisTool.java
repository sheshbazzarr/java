import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User Input
        System.out.println("Please input a paragraph or a lengthy text: ");
        String text = scanner.nextLine();
        
        // Character Count
        int charCount = text.length();
        System.out.println("Total number of characters: " + charCount);
        
        // Word Count
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);
        
        // Most Common Character
        String lowerText = text.toLowerCase();
        char mostCommonChar = getMostCommonCharacter(lowerText);
        System.out.println("Most common character: " + mostCommonChar);
        
        // Character Frequency
        System.out.println("Enter a character to find its frequency: ");
        char charToFind = scanner.next().toLowerCase().charAt(0);
        int charFrequency = getCharacterFrequency(lowerText, charToFind);
        System.out.println("Frequency of '" + charToFind + "': " + charFrequency);
        
        // Word Frequency
        System.out.println("Enter a word to find its frequency: ");
        String wordToFind = scanner.next().toLowerCase();
        int wordFrequency = getWordFrequency(lowerText, wordToFind);
        System.out.println("Frequency of '" + wordToFind + "': " + wordFrequency);
        
        // Unique Words Count
        int uniqueWordsCount = getUniqueWordsCount(lowerText);
        System.out.println("Number of unique words: " + uniqueWordsCount);
    }
    
    public static char getMostCommonCharacter(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
        return Collections.max(charCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
    public static int getCharacterFrequency(String text, char charToFind) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == charToFind) {
                count++;
            }
        }
        return count;
    }
    
    public static int getWordFrequency(String text, String wordToFind) {
        String[] words = text.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.equals(wordToFind)) {
                count++;
            }
        }
        return count;
    }
    
    public static int getUniqueWordsCount(String text) {
        String[] words = text.split("\\s+");
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }
}
