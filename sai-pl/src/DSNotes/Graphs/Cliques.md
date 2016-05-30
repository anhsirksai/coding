A maximal complete subgraph (clique) is a complete subgraph that is not contained in any other complete subgraph.

## Sample Problem

You are given a graph and a node in the graph. Group the nodes connected to this node if they are also connected to each other. For example, the graph has nodes 1, 2, 3, 4, 5 where 1 is connected to 2, 3, 4; 2 and 3 are also connected to each other, 4 is just connected to 1 and 5 is a separate node. You are given node 1 as input. Output should be: 
2 3 
4


 
### Soln :
 Create Set<List<Node>>
 Iterate over all children of the given input Node.
 For each:
 Check if it was visited before. (Hashtable, Node->Boolean), skip if it was.
 If it was not create a new List<Node> and insert the Node into it. insert the List<...> into Set<List<Node>>
 Iterate over all children of the Node, for each discovered ChildNode check if it was visited before. (Hashtable, Node->Boolean), skip if it was. If it's not add into the List<Node>, mark as visited.
 
 Print Set<List<Node>>
 
 ### Soln:
```java
 //Time complexity: O(V+E). Space complexity: O(V+E)
 //I assume there are several other ways of doing this as well. 
 public class Node
 {
 	int value;
 	ArrayList<Node> connect;
 }
 
 
 public ArrayList<ArrayList<Integer>> groups(Node n)
 {
 	HashMap<Integer,Boolean> connected=new HashMap<Integer,Boolean>();
 	//Hash map with keys for all nodes connected to input node.
 	for(Node x: n.connect)
 	{
 		connected.put(x.value,false);
 	}
 	
 	ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
 	
 	for(Node x:n.connect)
 	{
 		ArrayList<Integer> connectedNodes=checkConnect(x,connected);
 		results.add(connectedNodes);
 	}
 	return connectedNodes;
 }
 
 private ArrayList<Integer> checkConnect(Node x,HashMap<Integer,Boolean> mp)
 {
 	ArrayList<Integer> r=new ArrayList<Integer>();
 	r.add(x.value);
 	mp.put(x.value,true);
 	if(x.connect!=null)
 	{
 		for(Node g:x.connect)
 		{
 			if(mp.containsKey(g.value))
 			{
 				boolean visited=mp.get(g.value);//Check if this vertex has already been visited
 				if(!visited)
 				{
 					r.add(g.value);
 				}
 			}
 		}
 	}
 	return r;
 }
```