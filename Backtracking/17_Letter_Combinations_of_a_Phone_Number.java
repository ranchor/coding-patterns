class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return Collections.emptyList();
        HashMap<Character, String> lookup = createLookUpTable();
        List<String> output = new ArrayList<>();
        backtrack(lookup, new StringBuffer(), digits, 0, output);
        return output;
    }

    // 23,
    // currDigitsIndex =0
    // currString = a
    void backtrack(HashMap<Character, String >lookup, StringBuffer currString, String digits, int currDigitsIndex,
            List<String> output) {
        if (currDigitsIndex == digits.length()) {
            output.add(currString.toString());
            return;
        }

        String possibleLetters = lookup.get(digits.charAt(currDigitsIndex));
        for (char letter: possibleLetters.toCharArray()) {
            currString.append(letter);
            backtrack(lookup, currString, digits, currDigitsIndex + 1, output);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    HashMap<Character, String> createLookUpTable() {
        HashMap<Character, String> lookup = new HashMap<>();
        lookup.put('2', "abc");
        lookup.put('3', "def");
        lookup.put('4', "ghi");
        lookup.put('5', "jkl");
        lookup.put('6', "mno");
        lookup.put('7', "pqrs");
        lookup.put('8', "tuv");
        lookup.put('9', "wxyz");
        return lookup;
    }
}