import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
	
	public static final String NULL_SYMBOL = "X";
	public static final String DELIMITER = ",";
	
	TreeNode root;

	public String serialize(TreeNode root) {
		
		if(root == null)
			return NULL_SYMBOL + DELIMITER;
		
		return root.data + DELIMITER + serialize(root.left) + serialize(root.right);
		
	}
	
	public TreeNode deserialize(String data) {
		Queue<String> remainingNodes = new LinkedList<>();
		remainingNodes.addAll(Arrays.asList(data.split(DELIMITER)));
		return deserializeHelper(remainingNodes);
	}
	
	private TreeNode deserializeHelper(Queue<String> remainingNodes) {
		
		String nodeVal = remainingNodes.poll();
		
		if(nodeVal.equals(NULL_SYMBOL))
			return null;
		
		TreeNode newNode = new TreeNode(Integer.valueOf(nodeVal));
		newNode.left = deserializeHelper(remainingNodes);
		newNode.right = deserializeHelper(remainingNodes);
		
		return newNode;
	}
	
	public void printPreorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
		SerializeAndDeserialize tree = new SerializeAndDeserialize();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(5);
		
		String serializedTree = tree.serialize(tree.root);
		
		System.out.println("Serialized Tree: " + serializedTree);
		
		TreeNode node = tree.deserialize(serializedTree);
		
		System.out.print("Deserialized tree: ");
		tree.printPreorder(node);

	}

}
