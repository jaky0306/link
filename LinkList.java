package list;

public class LinkList<T> 
{
	private class Node
	{

	// hehehehee
		
		private T data;
		private Node next;
		public Node(){}
		public Node(Node n)
		{
			this.data=n.data;
			this.next=n.next;
		}
		public Node(T data,Node next)
		{
			this.data=data;
			this.next=next;
		}
	}
	private Node head;
	public T con;
	public int initList()
	{ 
		head=new Node(null,null);
		//System.out.println(head);
		if(head==null)
		{
			System.out.println("初始化错误");
			return 0;
		}
		head.next=null;
		return 1;
	}
	
	public int ListEmpty()
	{
		if(head.next == null)
			return 0;
		else
			return 1;
	}
	
	public int ListLength()
	{
		int total=0;
		Node p=head.next;
		while(p!=null)
		{
			p=p.next;
			total++;
		}
		return total;
	}
	public void traverseList()
	{
		Node p=head.next;
		while(p!=null)
		{
			System.out.println(p.data);
			p=p.next;
		}
	}
	
	public int ListInsert(T item,int pos)
	{
		Node p=head;
//		System.out.println(head);
//		System.out.println(p);
//		System.out.println(head.next);
//		System.out.println(p.next);
		int i=0;
		while(p.next!=null)//////////////////////////////////
		{
			if(i+1==pos)
				break;
			p=p.next;
			i++;

		}
		//System.out.println(p);
		if(p==null)
		{
			//System.out.println(p);
			System.out.println("数据插入无效");
			return 0;
		}
		Node t=new Node(item,null);
		t.next=p.next;
		p.next=t;
		
		return	1;
	}
	public int ListDelete(T item)
	{
		Node p=head;
		
		while(p.next!=null)
		{
			//System.out.println("````"+p.next.data);
			if(p.next.data.equals(item))
			{
				break;
			}
			p=p.next;
		}
		Node t=p.next;
		p.next=t.next;
		return 1;
	}
	public int Find_item(T item)
	{  
		Node p=head.next;
		int pos=0; 
		while(p!=null)
	    { 
	        pos++;
			if(p.data==item) break;
			p=p.next;
		}
		if(p!=null) return pos; //返回位置编号
		else  return 0;    //查找失败
	}
	public Object Find_pos(int pos)
	{  
		Node p=head.next;
		int i=1; 
		while(p!=null && i!=pos){ 
			p=p.next;
			i++; 
		}
		if(p==null){ 
			System.out.println("查找位置无效");
			return 0;
		}
		con=p.data;
		return con; 
	}
	
	public static void main(String []args)
	{
		LinkList<String> list=new LinkList<String>();
		list.initList();
		list.ListInsert("aaaa", 1);
		list.ListInsert("bbbb", 1);
		list.ListInsert("cccc", 1);
		System.out.println("neirong:"+list.Find_pos(1));
		System.out.println("xiabiao:"+list.Find_item("cccc"));
		list.traverseList();
		list.ListDelete("bbbb");
		list.traverseList();
	}

}

