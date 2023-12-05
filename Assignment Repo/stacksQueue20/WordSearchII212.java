package stacksQueue20;

public class WordSearchII212 {
	 private TrieNode[] links;
	    private boolean isEnd;
	    
	    public TrieNode() {
	        links = new TrieNode[26];
	    }
	    
	    public TrieNode get(char c) {
	        return links[c - 'a'];
	    }
	    
	    public void set(char c) {
	        links[c - 'a'] = new TrieNode();
	    }
	    
	    public boolean isEnd() {
	        return isEnd;
	    }
	    
	    public void setIsEnd(boolean value) {
	        isEnd = value;
	    }
	}

	class Trie {
	    private TrieNode root;
	    
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    public TrieNode getRoot() {
	        return root;
	    }
	    
	    public void insert(String word) {
	        TrieNode node = root;
	        
	        for (char c : word.toCharArray()) {
	            if (node.get(c) == null) {
	                node.set(c);
	            }
	            
	            node = node.get(c);
	        }
	        
	        node.setIsEnd(true);
	    }
	}

	class Solution {
	    public List<String> findWords(char[][] board, String[] words) {
	        List<String> result = new ArrayList<>();
	        Trie trie = new Trie();
	        
	        for (String word : words) {
	            trie.insert(word);
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	                dfs(board, i, j, new StringBuilder(), trie.getRoot(), result);
	            }
	        }
	        
	        return result;
	    }
	    
	    public void dfs(char[][] board, int i, int j, StringBuilder sb, TrieNode node, List<String> words) {
	        if (i < 0 || i == board.length || j < 0 || j == board[i].length || board[i][j] == '#') {
	            return;
	        }
	        
	        char c = board[i][j];
	        
	        if (node.get(c) == null) {
	            return;
	        }
	        
	        node = node.get(c);
	        sb.append(c);
	        
	        if (node.isEnd()) {
	            words.add(sb.toString());
	            node.setIsEnd(false);
	        }
	        
	        board[i][j] = '#';
	            
	        dfs(board, i - 1, j, sb, node, words);
	        dfs(board, i, j + 1, sb, node, words);
	        dfs(board, i + 1, j, sb, node, words);
	        dfs(board, i, j - 1, sb, node, words);
	        board[i][j] = c;
	        sb.setLength(sb.length() - 1);
	    }
}
