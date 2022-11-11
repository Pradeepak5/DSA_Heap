import java.util.Scanner;

public class BinaryHeap {
	
	Integer[] heap;
	int n;
	
	public BinaryHeap(int capacity) {
		heap=new Integer[capacity+1];
		n=0;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public int length() {
		return n;
	}
	
	public void insert(int x) {
		if(n==heap.length-1) {
			resize(2*heap.length);
		}
		n++;
		heap[n]=x;
		swim(n);
	}

	public void swim(int k) {
		while(k>1 && heap[k/2]<heap[k]) {
			int temp=heap[k];
			heap[k]=heap[k/2];
			heap[k/2]=temp;
			k=k/2;
		}
	}

	public void resize(int c) {
		Integer[] temp=new Integer[c];
		for(int i=0;i<heap.length;i++) {
			temp[i]=heap[i];
		}
		heap=temp;
	}
	
	public void printHeap() {
		for(int i=1;i<=n;i++) {
			System.out.print(heap[i]+" ");
		}
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Array Capacity : ");
		int capacity=s.nextInt();
		BinaryHeap b=new BinaryHeap(capacity);
		b.insert(5);
		b.insert(4);
		b.insert(10);
		b.insert(9);
		b.insert(3);
		b.printHeap();
		System.out.println();
		System.out.println("Size of the Heap : "+b.length());
	}

}
