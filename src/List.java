
public class List
{
	
	Node head;

	public List()
	{
		super();
		
		System.out.println("An empty list " + this + " has been created");
	}
	
	Node getLastNode()
	{
		Node lastNode = null;
		
		for (Node currentNode = this.head.next; currentNode != null; currentNode = currentNode.next)
		{
			if (currentNode.next == this.head)
			{
				lastNode = currentNode;
				
				break;
			}
		}
		
		return lastNode;
	}
	
	void insertHead(int value)
	{
		if (isEmpty())
		{
			this.head = new Node(value, this.head);
			this.head.next = this.head;
		}
		else
		{
			Node lastNode = getLastNode();
			
			this.head = new Node(value, this.head);

			lastNode.next = this.head;
		}
		
		System.out.println("Value " + value + " has been inserted into the beginning of the list " + this);
	}
	
	void print()
	{
		System.out.println("Printing list " + this);
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			System.out.println("Node: " + this.head + "\tValue: " + this.head.value);
			
			for (Node currentNode = this.head.next; currentNode != this.head; currentNode = currentNode.next)
			{
				System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
			}
		}
	}
	
	void recursivePrint(Node currentNode, Node lastNode)
	{	
		if (this.head == currentNode)
		{
			System.out.println("Printing list " + this + " recursively");
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		if (currentNode != lastNode)
		{
			System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
			
			recursivePrint(currentNode.next, lastNode);
		}
		else
		{
			System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
		}
	}
	
	void reversePrint(Node currentNode, Node lastNode)
	{
		if (this.head == currentNode)
		{
			System.out.println("Printing reverse list " + this);
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		if (currentNode != lastNode)
		{
			reversePrint(currentNode.next, lastNode);
			
			System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
		}
		else
		{
			System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
		}
	}
	
	boolean isEmpty()
	{
//		System.out.println("Is this list empty?");
		
		if (this.head == null)
		{
			return true;
		}
		
		return false;
	}
	
	Node search(int value, boolean showMessage)
	{
		if (showMessage)
		{
			System.out.println("Looking for number " + value + " in list " + this);
			
			if (isEmpty())
			{
				System.out.println("This list is empty");
			}
		}
		
		Node lastNode = getLastNode();
		
		for (Node currentNode = this.head; currentNode != lastNode; currentNode = currentNode.next)
		{
			if (currentNode.value == value)
			{
				if (showMessage)
				{
					System.out.println("Found");
					System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
				}
				
				return currentNode;
			}
		}
		
		if (lastNode.value == value)
		{
			if (showMessage)
			{
				System.out.println("Found");
				System.out.println("Node: " + lastNode + "\tValue: " + lastNode.value);
			}
			
			return lastNode;
		}
		else
		{
			if (showMessage)
			{
				System.out.println("Not found");
			}
			
			return null;
		}
	}
	
	Node getPreviousNode(Node nextNode)
	{
		for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.next)
		{
			if (currentNode.next == nextNode)
			{
				return currentNode;
			}
		}
		
		return null;
	}
	
	void remove(int value)
	{
		System.out.println("Looking for number " + value + " to be removed from the list " + this);
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			Node nodeToRemove = search(value, false);
			
			if (nodeToRemove != null)
			{
				if (nodeToRemove == this.head)
				{
					Node lastNode = this.getLastNode();
					
					this.head = this.head.next;
					
					lastNode.next = this.head;
				}
				else
				{
					Node previousNode = getPreviousNode(nodeToRemove);
					previousNode.next = nodeToRemove.next;					
				}
				
				System.out.println("Found");
				System.out.println("Node: " + nodeToRemove + "\tValue: " + nodeToRemove.value);
				
				nodeToRemove = null;
			}
			else
			{
				System.out.println("Not found");
			}
		}
	}
	
	void recursiveRemove(int value, Node previousNode, Node currentNode, Node lastNode)
	{
		if (this.head == currentNode)
		{
			System.out.println("Looking for number " + value + " to be removed recursively from the list " + this);			
		}
		
		if (isEmpty())
		{
			System.out.println("This list is empty");
		}
		else
		{
			if (currentNode != lastNode)
			{
				if (currentNode.value == value)
				{
					if (previousNode == null)
					{
						this.head = currentNode.next;
						
						lastNode.next = this.head;
					}
					else
					{
						previousNode.next = currentNode.next;
					}
					
					System.out.println("Found");
					System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
					
					currentNode = null;
				}
				else
				{
					recursiveRemove(value, currentNode, currentNode.next, lastNode);
				}
			}
			else if (currentNode == lastNode)
			{
				if (currentNode.value == value)
				{
					previousNode.next = currentNode.next;
					
					System.out.println("Found");
					System.out.println("Node: " + currentNode + "\tValue: " + currentNode.value);
					
					currentNode = null;
				}
				else
				{
					System.out.println("Not found");
				}
			}
		}
	}
	
	List free()
	{
		System.out.println("Deallocating memory from the list " + this);

		Node previousNode;
		Node currentNode = this.head; 
		Node lastNode = getLastNode();
		
		while (currentNode != lastNode)
		{
			previousNode = currentNode;
			
			currentNode = currentNode.next;
			
			previousNode = null;
		}
		
		currentNode = lastNode;
		
		lastNode = null;

		return null;
	}
	
}
