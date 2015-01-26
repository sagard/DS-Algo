import java.util.Queue;
import java.util.LinkedList;


public class BinaryTree {

	Tree root;


	public void insert(int data)
	{
		Tree current;

		if(root == null)
		{
			root = new Tree();
			root.data = data;
			root.left = null;
			root.right = null;
			System.out.println("Root data:" + root.data);
		}

		else{
			current = root;
			while(true)
			{
				if(data>current.data)
				{
					if(current.right!=null)
					{
						current = current.right;
					}
					else { Tree node = new Tree(); node.data = data; current.right = node; 
					System.out.println("right Data:" + node.data);
					return;
					}
				}
				else{
					if(current.left!=null)
					{
						current = current.left;
					}
					else {
						Tree node = new Tree(); node.data = data; current.left = node;
						System.out.println("left Data:" + node.data);
						return;
					}
				}
			}


		}

	}
/////////////////////////////////////////////////////////////
	public void print(Tree node)
	{
		if(node !=null)
		{
			print(node.left);
			System.out.println("tree data is :" + node.data);
			print(node.right);
		}
	}
/////////////////////////////////////////////////////////////
	public static int prev = 0;
	public boolean isBSTR(Tree node)
	{
		if(node !=null)
		{
			print(node.left);
			int value = node.data;
			if(node.data<prev) return false;
			prev = node.data;
			System.out.println("tree data is :" + node.data);
			print(node.right);
		}
		return true;
	}
/////////////////////////////////////////////////////////////
	//Time Complexity: O(n)
	//Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
	public boolean isBST(Tree root,int max,int min){
		//	System.out.println("root data in fun:"+root.data);
		if(root.data> max  || root.data< min) return false;

		if(root == null)
			return true;
		else 
		{
			boolean left = isBST(root.left,root.data,min);
			if(!left) return false;

			boolean right = isBST(root.right,max,root.data+1);
			return right;
		}

	}
/////////////////////////////////////////////////////////////
	public void search(int data,Tree root)
	{
		Tree curr = root;
		while(curr != null && curr.data!=data)
		{
			if(curr.data>data)
			{
				curr = curr.left;
			}
			else curr = curr.right;
		}

		if(curr != null) System.out.println("Found data"+curr.data);
		else System.out.println("Data not found");

	}

	public Tree searchTree(int data)
	{
		Tree curr = root;
		while(curr != null && curr.data!=data)
		{
			if(curr.data>data)
			{
				curr = curr.left;
			}
			else curr = curr.right;
		}

		if(curr != null) System.out.println("Found data"+curr.data);
		else System.out.println("Data not found");

		return curr;

	}
/////////////////////////////////////////////////////////////
	// Parent,left ,right
	public void preOrder(Tree node)
	{
		if(node != null)
		{   
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//left,parent,right
	public void inOrder(Tree node)
	{
		if(node != null)
		{
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	//left,right.parent
	public void postOrder(Tree node)
	{
		if(node != null)
		{
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

/////////////////////////////////////////////////////////////
	//lca for bst
	// if current node data is greater than both 1 and 2;lca is in left side
	// if current node data is greater than lca is in right side
	// if one is greater or less we have the lca..
	Tree getLCA(Tree root, int data1, int data2)
	{
		Tree currentTree = root;
		if(searchTree(data1)== null || searchTree(data2)==null){
			System.out.println("No lca as node missing");
			return null;
		}

		while (currentTree != null)
		{
			if (currentTree.data < data1 && currentTree.data < data2)
				currentTree = currentTree.right;
			else if (currentTree.data > data1 && currentTree.data > data2)
				currentTree = currentTree.left;
			else
				break;
		}

		System.out.println("lca: " + currentTree.data);


		return currentTree;
	}

	//lca for normal binary tree..assuming both nodes are present..
	public static Tree findLowestCommonAncestor(Tree root, Tree a, Tree b) {

		Tree left = null;
		Tree right = null;

		if (root == null) {
			return null;
		}

		/**
		 * If Tree a or Tree b is also the root, then the root itself is lowest common ancestor
		 */
		if (root == a || root == b) {
			return root;
		}

		left = findLowestCommonAncestor(root.left, a, b);
		right = findLowestCommonAncestor(root.right, a, b);

		/**
		 * If Tree a and Tree b lie in the left, their Lowest Common Ancestor is in the left.
		 * If Tree a and Tree b lie in the right,their Lowest Common Ancestor is in the right.
		 *
		 * Otherwise, root is the Lowest common ancestor.
		 */
		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}

/////////////////////////////////////////////////////////////

	//find max depth of binary tree..O(n)
	// just recurse and find max of left or right subtree
	public int findDepth(Tree root)
	{
		if(root == null) return 0;
		else{
			int ldepth = findDepth(root.left);
			int rdepth = findDepth(root.right);
			return (1 + Math.max(ldepth,rdepth));
		}    
	}

/////////////////////////////////////////////////////////////
	//find node with max depth of binary tree..do bfs..
	public Tree findMaxTree(Tree root)
	{
		Tree dTree=null;
		if(root == null) return root;
		else
		{
			Queue<Tree> q = new LinkedList<Tree>();
			q.add(root);
			while(!q.isEmpty())
			{
				dTree = q.peek();
				Tree temp = q.remove();
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
		}
		return dTree;
	}	 

/////////////////////////////////////////////////////////////
	
	//Check if 2 bst are same.. complexity O(n) where n is greater num of nodes
	public boolean sameTree(Tree a,Tree b)
	{
		if(a == null && b == null) return true;
		else if ((a == null && b!= null) || (a != null && b == null)) return false;
		else 
			return (a.data == b.data && sameTree(a.left,b.left) && sameTree(a.right,b.right));
	}
	
/////////////////////////////////////////////////////////////
	//max sum frm in tree from any node to other..
	public int findMax(Tree node) {
		if (node == null)
			return 0;
		int max=0;
		// recursively get sum of left and right path
		int left = Math.max(findMax(node.left), 0);
		int right = Math.max(findMax(node.right), 0);

		//update maximum here
		max = Math.max(node.data + left + right, max);

		// return sum of largest path of current node
		return node.data + Math.max(left, right);   // or jst left + right
	}
	
/////////////////////////////////////////////////////////////
	//chk if thr is sum path from root to leaf..
	boolean hasPathSum(Tree node, int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) {
			return(sum == 0);
		}
		else {
			// otherwise check both subtrees
			int subSum = sum - node.data;
			return(hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
		}
	}
/////////////////////////////////////////////////////////////



	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(20);
		bt.insert(8);
		bt.insert(22);
		bt.insert(4);
		bt.insert(12);
		bt.insert(10);
		bt.insert(14);
		//bt.print(bt.root);
		//boolean res = bt.isBSTR(bt.root);
		//System.out.println(res);
		//bt.search(9, bt.root);
		//boolean res = bt.isBST(bt.root,11,1);
		//if(res == true) System.out.println("truee");
		//else System.out.println("falsse");
		//	bt.getLCA(bt.root, bt.searchTree(10), bt.searchTree(22));
		//bt.getLCA(bt.root, 20, 20);
		int d = bt.findDepth(bt.root);
		System.out.println(d);
		boolean t = bt.hasPathSum(bt.root,4);
		System.out.println(t);		
	}

}
