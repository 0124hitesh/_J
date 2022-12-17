// https://leetcode.com/problems/word-ladder/solutions/1764371/a-very-highly-detailed-explanation/?orderBy=most_relevant

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> wList = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);

        int res = 1;
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize-- > 0){
                String s = q.poll();
                if(s.equals(endWord)) return res;
                
                for(int i = 0; i < s.length(); ++i){
                    for(int c = 'a'; c <= 'z'; ++c){
                        char[] arr = s.toCharArray();
                        arr[i] = (char)c;
                        String newWord = new String(arr);

                        if(wList.contains(newWord) && !vis.contains(newWord)){
                            vis.add(newWord);
                            q.add(newWord);
                        }
                    }
                }
            }
            ++res;
        }

        return 0;
    }
}