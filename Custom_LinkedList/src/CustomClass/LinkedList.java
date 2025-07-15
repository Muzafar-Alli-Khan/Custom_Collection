package CustomClass;

/*
 * //Singly LinkList


//===============
class Node<E> {

	int item;
	Node next; // ANN - Address of next code

	public Node(int item) {
		this.item = item;
		this.next = null;
	}
//	@Override
//	public String toString() {
//		return "Node [item=" + item + ", next=" + next + "]";
//	}
}
public class NodeDemo {

	public static void main(String[] args) {

		Node n1 = new Node(100);
		Node n2 = new Node(200);
		Node n3 = new Node(300);

		n1.next = n2;
		n2.next = n3;

		System.out.println(n1.item);
		System.out.println(n1.next.item);
		System.out.println(n1.next.next.item);
	}

}
 */
//Not a  good technique  because Any One Can Change the value In side the package so 
//use inner class
////////////-----------Costume LinkedList-----------------///////////////

/*
 * Available in java.Lang Package because this is Costume Linked-List
 * CustomClass is Available in java.util Package
 */
@SuppressWarnings("unused")
public class LinkedList {
	/**
	 * @About CustomClass A CustomClass must always contain a head node and a tail
	 *        node. We first create an instance of a node, because a CustomClass is
	 *        a collection of nodes. The first node is then assigned to both the
	 *        head and the tail. If there is only a single node, it will act as both
	 *        the head and the tail.
	 *
	 */

	/**
	 * @Size Whenever a new element (i.e., node) is added, the size increases.
	 *       Initially, the size is set to zero.
	 */

	private Node head, tail;
	private int size;

	/**
	 * @Constructor When an object of the CustomClass is created, the zero-argument
	 *              constructor is invoked. In this constructor, head and tail are
	 *              initialized to null, and size is set to zero.
	 */

	public LinkedList() {
		super();
		head = tail;
		size = 0;
	}

	/**
	 * @InnerClass This inner Node class is used to create nodes for the
	 *             CustomClass.
	 */

	private class Node {

		int item; // 100
		Node next; // next -> ANN (Address of node)

		public Node(int item) {
			super();
			this.item = item;
			this.next = null;
		}
	}

	/////-------------////////////////////////
	/**
	 * @AddingElement This method adds elements to the CustomClass using the add()
	 *                method. Internal implementation starts at line 101.
	 */
	public void add(int item) {

		/*
		 * add elements then will take parameter Integer item Whenever you add an
		 * element in the CustomClass then internally one node is created [line number
		 * :112] (Node means your Inner Class) This node contain item As a Constructor
		 * [Line number :91].
		 * 
		 * then We will check /verify head is null is not whenever you create object
		 * then head and tail is pointing to null. [when new node create then head and
		 * tail pointing to null]
		 *
		 */
		Node newNode = new Node(item);
		/**
		 * if(head == null) [ means CustomClass Single NOde is not Their] then head and
		 * tail both are point the new Node because Single node is created
		 */
		if (head == null) {
			head = tail = newNode;
			return;
		}
		/**
		 * if(head != null) [if head not pointing not null because one Node is Already
		 * Created [100] item is added . then if you Add next element/item then else
		 * part is work because your head is not Pointing to null [Already add 100] head
		 * tail node is pointing next node hear 2 node is created. and move tail first
		 * to last node
		 * 
		 * 
		 * then Size is Increase size++ [Because more element is added so Increase the
		 * Size]
		 */
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * @removeElement [remove the Element in the CustomClass]
	 * 
	 * 
	 */

	public void removeFirst() {
		/**
		 * if CustomClass Is Empty then how to remove element then show error
		 * CustomClass is Empty
		 */
		if (head == null) {
			System.err.println("CustomClass Is Empty");
			return;
		}
		/**
		 * if CustomClass is Not empty then else part you pointing the head node to
		 * Second node then head node is Eligible to Garbage Collector
		 */

		else {
			head = head.next; // 100 to 200[last node] means 100 is eligible for GarbageCollector
			size--;
		}
	}

	/**
	 * @DisplayElement DisplayThe Elements
	 */
	public void display() {
		/**
		 * Check Head is not Pointing the Null use loop then fetch the Element
		 */
		/**
		 * ------------ while(head!=null) { System.out.println(head.item);
		 * head=head.next; // 100 to 200 - 300 }
		 * 
		 * it is not a good technique. ------------------------
		 */
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.item + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		/*
		 * @Instanciate [object Creation] Hear we Create Constructor For CustomClass so
		 * Constructor invoke once Constructor invoke then head And tail node pointing
		 * null [Line number 72] Size = 0; [Line number : 73] then Add the Element
		 * Method [Line Number : 93]
		 */
		LinkedList list = new LinkedList();
		/**
		 * we add [100] element in the CustomClass Element List Implements starts [ line
		 * number :105]
		 */

		System.out.println("------");
		list.display();
		System.out.println("---");
		list.removeFirst();
		list.display();

	}
}
