// Quick Sort Implementation

public class QuickSort {
	int[] arr = {3,1,6,22,11,2,33,18};
    
	void QuickSort(int[] arr,int low,int high)
	{
		int index = partition(arr,low,high);
		if(low<index-1)
			QuickSort(arr,low,index-1);
		if(index<high)
			QuickSort(arr,index,high);
		return;
	}
	
    public int partition(int[] arr,int low,int high){
    	//select middle element as pivot
    	int pivot = arr[(low+high)/2];
   	
    	// till low nd high pointers cross over continue
    	while(low<=high){
    		//go from strt till u get a element greater than pivot
    		while(arr[low]<pivot)
    			low++;
    		
    		// go from high till u get element less than pivot
    		while(arr[high]>pivot)
    		{
    			high--;
    		}
    		
    		//swap low nd high
    		if(low<=high){
    			int temp = arr[low];
    			arr[low]=arr[high];
    			arr[high] = temp;
    			low++;
    			high--;
    		}
    	}
    	
    	// pass the new low value
      return low;
    	   	
    }
    
    public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.QuickSort(qs.arr, 0, qs.arr.length-1);
		for(int j =0;j<qs.arr.length;j++){
	           System.out.print(qs.arr[j] + " " );  
	} 
		}
    }
