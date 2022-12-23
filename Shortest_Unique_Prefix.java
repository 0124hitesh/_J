class A{

	class Trie{
		Trie[] characters = new Trie[26];
		int[] count = new int[26];
	}

	void insert(String word, Trie root){
		Trie node = root;

		for(int i = 0; i < word.length(); ++i){
			int ind = word.charAt(i) - 'a';
			
			if(node.characters[ind] != null){
				node.count[ind]++;
				node = node.characters[ind];
			}
			else{
				Trie newNode = new Trie();
				node.count[ind]++;
				node.characters[ind] = newNode;
				node = newNode;
			}
		}
	}

	String find(String word, Trie root){
		Trie node = root;
		StringBuilder res = new StringBuilder();

		for(int i = 0; i < word.length(); ++i){
			if(node.count[word.charAt(i) - 'a'] == 1){
				res.append(word.charAt(i));
				return res.toString();
			}
			else{
				res.append(word.charAt(i));
				node = node.characters[word.charAt(i) - 'a'];
			}
		}

		return res.toString();
	}

	String[] getShortestUniquePrefixes(String[] words) {
		Trie root = new Trie();
		for (int i = 0; i < words.length; i++) {
			insert(words[i], root);
		}

		String[] res = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			res[i] = find(words[i], root);
		}
		return res;
	}

    public static void main(String...args){
        String[] words = {};

        String[] ans = new A().getShortestUniquePrefixes(words);
        for(String s: ans){
            System.out.print(ans + " ");
        }
    }
}