import java.io.*;
import java.util.*;

/*
 * Two methods of checking if a string contains all unique
 * characters.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome");
    strings.add("Unique");
    strings.add("test");
    strings.add("This");

    for (String string : strings) {
      System.out.println(check_if_unique(string));
      System.out.println(check_if_unique2(string));
    }
  }

  public static boolean check_if_unique(String str) {

    // Create array to rpresent occurrrence of characters.
    // Size of 255 required for all possible ASCII values.
    boolean [] char_occurrence = new boolean[255];

    // Iterate over each character in string.
    for (char c : str.toCharArray()) {
      // If array at index of character value has already been set
      // to true, all characters are not unique.
      if (char_occurrence[c]) {
        return false;
      } else {
        char_occurrence[c] = true;
      }
    }

    return true;
  }

  public static boolean check_if_unique2(String str) {
    // Convert string to char array and then sort.
    char[] char_arr = str.toCharArray();
    Arrays.sort(char_arr);

    // Iterate over sorted string and check if two consecutive
    // characters are identical. If they are, not all characters
    // are unique.
    for (int i = 0; i < char_arr.length - 1; i++) {
      if (char_arr[i] == char_arr[i + 1]) {
        return false;
      }
    }

    return true;
  }
}
