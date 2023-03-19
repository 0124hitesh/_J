class Trie {
	class TrieNode {
		private TrieNode[] alpha = new TrieNode[26];
		private boolean isEnd = false;
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		char[] arr = word.toCharArray();
		TrieNode node = root;
		int idx = 0;

		for (char c : arr) {
			idx = c - 'a';
			if (node.alpha[idx] == null) {
				node.alpha[idx] = new TrieNode();
			}
			node = node.alpha[idx];
		}

		node.isEnd = true;
	}

	public boolean search(String word) {
		char[] arr = word.toCharArray();
		TrieNode node = root;
		int idx = 0;

		for (char c : arr) {
			idx = c - 'a';
			if (node.alpha[idx] == null)
				return false;
			node = node.alpha[idx];
		}

		return node.isEnd;
	}

	public boolean startsWith(String prefix) {
		char[] arr = prefix.toCharArray();
		TrieNode node = root;
		int idx = 0;

		for (char c : arr) {
			idx = c - 'a';
			if (node.alpha[idx] == null)
				return false;
			node = node.alpha[idx];
		}

		return true;
	}
}

// Using this, but slow

// class Trie {

// 	private Trie[] alpha;
// 	private boolean isEnd;

// 	public Trie() {
// 		this.alpha = new Trie[26];
// 		this.isEnd = false;
// 	}

// 	public void insert(String word) {
// 		char[] arr = word.toCharArray();
// 		Trie node = this;
// 		int idx = 0;

// 		for (char c : arr) {
// 			idx = c - 'a';
// 			if (node.alpha[idx] == null) {
// 				node.alpha[idx] = new Trie();
// 			}
// 			node = node.alpha[idx];
// 		}

// 		node.isEnd = true;
// 	}

// 	public boolean search(String word) {
// 		char[] arr = word.toCharArray();
// 		Trie node = this;
// 		int idx = 0;

// 		for (char c : arr) {
// 			idx = c - 'a';
// 			if (node.alpha[idx] == null)
// 				return false;
// 			node = node.alpha[idx];
// 		}

// 		return node.isEnd;
// 	}

// 	public boolean startsWith(String prefix) {
// 		char[] arr = prefix.toCharArray();
// 		Trie node = this;
// 		int idx = 0;

// 		for (char c : arr) {
// 			idx = c - 'a';
// 			if (node.alpha[idx] == null)
// 				return false;
// 			node = node.alpha[idx];
// 		}

// 		return true;
// 	}
// }