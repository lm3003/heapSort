package heapsort;

public class HeapSort {
	
	public static int left(int i) {
		return 2*i + 1;
	}
	
	public static int right(int i) {
		return 2*i + 2;
	}
	
	public static void maxHeapify(int[] A, int heapSize, int i){
		int l = left(i);
		int r = right(i);
		int largest = 0;
		if(l <= heapSize && A[l] > A[i]) {
			largest = l;
		}else {
			largest = i;
		}
		if(r <= heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if(largest != i) {
			int temp = A[largest];
			A[largest] = A[i];
			A[i] = temp;
			maxHeapify(A, heapSize, largest);
		}
	}
	
	public static void buildHeap(int[] A,int heapSize) {
		for(int i = heapSize/2; i >=0; i--) {
			maxHeapify(A, heapSize, i);
		}
	}
	
	public static void heapSort(int[] A) {
		int heapSize = A.length - 1;
		buildHeap(A, heapSize);
		for(int i = A.length - 1; i > 0; i--) {
			int temp = A[0];
			A[0] = A[heapSize];
			A[heapSize] = temp;
			heapSize--;
			maxHeapify(A, heapSize, 0);
		}
	}
	
	public static void main(String args[]) {
		int[] A = {2, 1, 5, 0 , 3, 8, 3, 1};
		System.out.println("Unsorted Array: ");
		for(int ele: A) {
			System.out.print("\t" + ele);
		}
		heapSort(A);
		System.out.println("\nSorted Array: ");
		for(int ele: A) {
			System.out.print("\t" + ele);
		}
	}

}
