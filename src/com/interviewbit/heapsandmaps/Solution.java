package com.interviewbit.heapsandmaps;

/*
    Instructions:
    Please implement the top_k_words function to satisfy the following requirements:

      1) Given a string and integer return the top k words by frequency.
         Examples:
           String[] top_k_words("It's a dog eat dog world", 1) => ["dog"]
           String[] top_k_words("Hello New York, New York", 2) => ["new", "york"]
           String[] top_k_words("A poem about Mary. Mary had a little lamb, its fleece was white as snow; And everywhere that Mary went the lamb was sure to go.", 4) => ["mary", "lamb", "was", "a"]
      2) Treat uppercase and lowercase words as the same word.
      3) Remove punctuation.
      4) Once you have a working solution sorting top k words by frequency please
         apply an alphabetical secondary sort.
         Example:
           In the above example, ["mary", "lamb", "was", "a"] is correctly sorted by
           frequency.
             [["mary", 3], ["lamb", 2], ["was",2], ["a", 2]]
           Sorting by frequency, then alphabetical should yield
             [["mary", 3], ["a", 2], ["lamb",2], ["was", 2]]
           The final result should look like this:
             ["mary", "a", "lamb", "was"]
      5) As a caller of your function, I decide to call it with `top_k_words(str, -2)`. Calling `top_k_words` with `-2` does not yield any valid output. Modify your solution to handle this input.

    Feel free to use Google to check Java syntax and functionality

*/
import java.io.*;
import java.util.*;

class Solution {
    class Word {
        String str;
        int cnt;

        public Word(String s, int i) {
            str = s;
            cnt = i;
        }
    }

    public static void main(String[] args) {
        // String str = "Two vast and trunkless legs of stone Stand in the desert. Near them, on the sand, Half sunk, a shattered visage lies, whose frown, And wrinkled lip, and sneer of cold command, Tell that its sculptor well those passions read Which yet survive, stamped on these lifeless things, The hand that mocked them and the heart that fed: And on the pedestal these words appear: 'My name is Ozymandias, king of kings: Look on my works, ye Mighty, and despair!' Nothing beside remains. Round the decay Of that colossal wreck, boundless and bare The lone and level sands stretch far away.";

        String str = "A poem about Mary. Mary had a little lamb";
        System.out.println(Arrays.toString(new Solution().top_k_words(str, 10)));
    }

    public String[] top_k_words(String str, int k_words) {
        HashMap<String, Integer> wordMap = new HashMap<>(); // words with count
        ArrayList<String> result = new ArrayList<>();

        // remove punctuations and convert case
        String sanitizedString = str.replaceAll("[^A-Za-z0-9 ]", "");
        String []words = sanitizedString.toLowerCase().trim().split(" ");

        for (String s: words) {
            int cnt = 1;

            // update count of occurence
            if (wordMap.containsKey(s)) {
                cnt = wordMap.get(s) + 1;
            }

            wordMap.put(s, cnt);
        }

        // sort based on frequency
        PriorityQueue<Word> priorityQueue = new PriorityQueue<>(new Comparator<Word>(){
            public int compare(Word a, Word b) {
                if (a.cnt == b.cnt) {
                    return b.str.compareTo(a.str);
                } else {
                    return b.cnt - a.cnt;
                }
            }
        });

        for (Map.Entry<String,Integer> entry : wordMap.entrySet()) {
            priorityQueue.add(new Word(entry.getKey(), entry.getValue()));
        }

        // get top K words
        int cnt = 0;
        while (priorityQueue.size() > 0 && cnt < k_words) {
            result.add(priorityQueue.poll().str);
            cnt++;
        }

        return result.toArray(new String[result.size()]);
    }
}
