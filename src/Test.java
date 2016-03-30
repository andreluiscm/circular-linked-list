
public class Test
{

	void run()
	{
		// Create Empty list
		List list = new List();
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Insert Head
		list.insertHead(1);
		list.insertHead(2);
		list.insertHead(3);
		list.insertHead(4);

		System.out.println("--------------------------------------------------------------------------------");
		
		// Print List
		list.print();
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Recursive Print List
		list.recursivePrint(list.head, list.getLastNode());
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Reverse Print List
		list.reversePrint(list.head, list.getLastNode());
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Is Empty?
		System.out.println("Is the list " + list + " empty?");
		System.out.println(list.isEmpty());
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Search
		Node nodeToSearch;
		nodeToSearch = list.search(1, true);
		System.out.println();
		nodeToSearch = list.search(2, true);
		System.out.println();
		nodeToSearch = list.search(3, true);
		System.out.println();
		nodeToSearch = list.search(4, true);
		System.out.println();
		nodeToSearch = list.search(5, true);
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Remove
		list.remove(1);
		System.out.println();
		list.remove(1);
		System.out.println();
		list.remove(2);
		System.out.println();
		list.print();
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Recursive Remove
		list.recursiveRemove(1, null, list.head, list.getLastNode());
		System.out.println();
		list.recursiveRemove(1, null, list.head, list.getLastNode());
		System.out.println();
		list.recursiveRemove(2, null, list.head, list.getLastNode());
		System.out.println();
		list.print();
		
		System.out.println("--------------------------------------------------------------------------------");
		
		// Free
		list = list.free();
		System.out.println("List = " + list);
		
		System.out.println("--------------------------------------------------------------------------------");
	}
	
}
