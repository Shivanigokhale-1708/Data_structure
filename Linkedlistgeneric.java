import java.util.*;
class Node<T>
{
	 T data;
	Node<T> next;
	public Node(T d)
	{
		data=d;
		
	}

}
public class Linkedlistgeneric<T> {

	private Node<T> head=null;
	public void create_list(Node<T> node)
	{
		//node.setNext(node);
		
		//head=node;
		if(head==null)
		{
			head=node;
		}
		else{
			Node<T> temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=node;
		}
	}

	
	public void display()
	{
		Node<T> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public int count_nodes()
	{
		Node<T> temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		
		return count;                  //return no of nodes in linked list
	}
	public void delete_at_position()
	{
		int pos;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nenter pos from which data is to be deleted");
		pos=sc.nextInt();
		if(pos==1 && head!=null) //if pos is 1 and linkedlist is not empty
		{
			Node<T> temp=head;
			head=head.next;
			temp=null;
			display();
		}
		else if(pos<=count_nodes())   //delete data at any position in between
		{
			int count=1;
			Node<T> temp=head;
			Node<T> temp1=null;
			while(temp.next!=null && pos!=count)
			{
				temp1=temp;
				temp=temp.next;
				count++;
			}
			if(pos==count)
			{
				temp1.next=temp.next;
				temp.next=null;
			}
		
		System.out.println("after deletion");
			display();
		}
		else if(pos>count_nodes())
		{
			System.out.println("position you entered is out of bounds for given linked list size");
		}
		
		}
	public void insert_at_position(){
		Scanner sc=new Scanner(System.in);
		int pos,data_at_position;
		System.out.println("\nenter position where data is to be inserted");
		pos=sc.nextInt();
		System.out.println("enter data to be inserted");
		String ans=sc.next();
		if(pos==1 && head==null) //if position is 1 and linked list is empty
		{
			Node temp=new Node<String>(ans);
			head=temp;
		}
		else if(head!=null)
		{
			if(pos==1)           //insert at position 1 & linked list is not empty
			{
				Node temp=new Node<String>(ans);
				temp.next=head;
				head=temp;
			}
			else if(pos<=count_nodes())  //insert at any position in between
			{
				Node temp=head;
				Node temp1=null;
				int count=1;
				while(temp!=null && count!=pos)
				{
					temp1=temp;
					temp=temp.next;
					count++;
				}
				if(count==pos)
				{
					Node insert_at_pos=new Node<String>(ans);
				temp1.next=insert_at_pos;
				insert_at_pos.next=temp;
				}
				
			}
			else if(pos==count_nodes()+1)     //inserting at end of linkedlist
			{
				Node temp=head;
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				Node insert_at_pos=new Node<String>(ans);
				temp.next=insert_at_pos;
			}
			else{
				System.out.println("position entered is not valid for created list!!");
			}
		}
		display();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Linkedlistgeneric<String> list=new Linkedlistgeneric<String>();
list.create_list(new Node<String>("Shivani"));
list.create_list(new Node<String>("Shilpa"));
list.create_list(new Node<String>("Maithili"));
list.create_list(new Node<String>("Rugved"));
list.display();
list.delete_at_position();
list.insert_at_position();
	}

}
