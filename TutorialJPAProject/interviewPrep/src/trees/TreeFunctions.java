package trees;

public class TreeFunctions {
	class TreeNode<T>{
		T val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(){
			val = null;
			left = null;
			right = null;
		}
		
		TreeNode(T v){
			val = v;
			left = null;
			right = null;
		}

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}
	
	public static int maxDepth(TreeNode root){
		if(root == null)
		return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	

}
