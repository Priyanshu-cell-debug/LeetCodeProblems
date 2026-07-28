import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If the character is already in the current window,
            // move the left pointer.
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            // Store the latest index of the character.
            map.put(ch, right);

            // Update the maximum length.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}