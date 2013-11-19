package queue;

public class Queue<T> {
	private class QNode
	{
		private T data;
		private QNode next;
		public QNode(T data,QNode next)
		{
			this.data=data;
			this.next=next;
		}
	} 
	private QNode front;
	private QNode rear;
	public T con;
	public int initQueue()
	{
		rear=front=new QNode(null,null);
		if(front==null)
		{
			System.out.println("��ʼ������");
			return 0;
		}
		front.next=null;
		rear.next=null;
		return 1;
	}
	public int EnQueue(T item)
	{
		QNode q=new QNode(item,null);
		rear.next=q;
		rear=q;
		return 1;
	}
	public Object DeQueue()
	{
		if(rear==front)
		{
			System.out.println("����Ϊ��");
			return 0;
		}
		QNode t=front.next;
		con=t.data;
		if(front==rear)
		{
			rear=front;
		}
		front.next=t.next;
		return con;
	} 
	public int isEmpty()
	{
		if(rear==front)
			return 1;
		else
			return 0;
	}
	public void TraverseQueue()
	{
		QNode tmp=front;
		while(tmp!=rear)
		{
			System.out.print(tmp.next.data+" ");
			tmp=tmp.next;
		}
		System.out.println();
	}
	
	public static void main(String []args)
	{
		Queue<String> queue=new Queue<String>();
		queue.initQueue();
		queue.EnQueue("aaaaa");
		queue.EnQueue("ddddd");
		queue.EnQueue("ccccc");
		queue.TraverseQueue();
		queue.DeQueue();
		queue.TraverseQueue();
	}
	
}
