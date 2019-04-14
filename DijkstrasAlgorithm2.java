import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// my version, has a bug

class DijkstrasAlgorithm2
{
  public static void main(String[] args) {
    
    // Create nodes
    Node node1 = new Node("A");
    Node node2 = new Node("B");
    Node node3 = new Node("C");
    Node node4 = new Node("D");
    Node node5 = new Node("E");

    // Connect nodes
    node1.adjacentNodes.add(new Edge(node1, node3, 10.0));
		node1.adjacentNodes.add(new Edge(node1, node2, 17.5));
		node3.adjacentNodes.add(new Edge(node3, node2, 55));
		node3.adjacentNodes.add(new Edge(node3, node4, 9));
		node3.adjacentNodes.add(new Edge(node3, node5, 11));
		node2.adjacentNodes.add(new Edge(node2, node4, 1));
		node4.adjacentNodes.add(new Edge(node4, node5, 6));
    
    
    DijkstrasAlgorithm shortestPath = new DijkstrasAlgorithm();
    shortestPath.dijkstras(node1);
      
    System.out.println("Calculating minimum distance");
      
    DijkstrasAlgorithm dijkstras = new DijkstrasAlgorithm();
    dijkstras.dijkstras(node1);
      
      
    System.out.println("Minimum distance from 1 to 1: "+node1.shortestDistance);
    System.out.println("Minimum distance from 1 to 2: "+node2.shortestDistance);
    System.out.println("Minimum distance from 1 to 3: "+node3.shortestDistance);
    System.out.println("Minimum distance from 1 to 4: "+node4.shortestDistance);
    System.out.println("Minimum distance from 1 to 5: "+node5.shortestDistance);
      
    System.out.println("Calculating Paths");
      
    System.out.println("Shortest Path from 1 to 2: "+dijkstras.shortestPathTo(node2));
    System.out.println("Shortest Path from 1 to 3: "+dijkstras.shortestPathTo(node3));
    System.out.println("Shortest Path from 1 to 4: "+dijkstras.shortestPathTo(node4));
    System.out.println("Shortest Path from 1 to 5: "+dijkstras.shortestPathTo(node5));

  }
}

class Node
{
  String name;
  ArrayList<Edge> adjacentNodes;
  Node previous;
  boolean visited;
  double shortestDistance;

  Node (String n)
  {
    name = n;
    adjacentNodes = new ArrayList<>();
  }

  void addNeighbor(Edge e)
  {
    adjacentNodes.add(e);
  }
  
  void setVisited(boolean b)
  {
	  visited = b;
  }
  
  ArrayList<Edge> getAdjacentNodes()
  {
	  return adjacentNodes;
  }
  
  boolean isVisited()
  {
	  return visited;
  }
  
  public String toString()
  {
	  return name;
  }
}

class Edge
{
  Node from;
  Node to;
  double weight;

  Edge (Node f, Node t, double w)
  {
    from = f;
    to = t;
    weight = w;
  }
}


// every node has a distance (shortest distance)
// gives every node that shortest distance from a given source node
class DijkstrasAlgorithm
{
	public void dijkstras(Node sourceNode)
	{
		sourceNode.shortestDistance = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(sourceNode);
		sourceNode.setVisited(true);
		
		while(!pq.isEmpty())
		{
			Node currentNode = pq.poll();
			
			for(Edge e : currentNode.getAdjacentNodes())
			{
				Node n = e.to;
				if(!n.isVisited())
				{
					double proposedDistance = currentNode.shortestDistance + e.weight;
					
					if(proposedDistance < n.shortestDistance)
					{
						pq.remove(n);
						n.shortestDistance = proposedDistance;
						n.previous = currentNode;
						pq.add(n);
					}
						
				}
			}
			currentNode.visited = true;
		}
	}
	
	public ArrayList<Node> shortestPathTo(Node end)
	{
		ArrayList<Node> path = new ArrayList<>();
		
		for(Node node = end; node != null; node = node.previous)
		{
		//System.out.println(node.previous);
			path.add(node);
		}
		Collections.reverse(path);
		return path;
	}
}
