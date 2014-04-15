//Implementation of Merge Sort

public class MergeSort {
   int[] arr = {3,1,6,22,11,2,33,18};
   int[] arr1 = new int[8];
   
   public void MergeSort(int[] arr1,int low,int high){
	   if(low==high) return;
	   else{
	   int mid = (low + high)/2;
	   MergeSort(arr1,low,mid);
	   MergeSort(arr1,mid+1,high);
	   merge(arr1,low,high,mid+1);
	   }
	  
   }
   
   public void merge(int[] arr1,int low,int high,int mid){
	    int i = 0 ;
	    // have low ptr for the end to tranfer elements
	    int lowptr = low;
	    
	    // have midptr to chk for range
	    int midptr = mid -1;
	    int length = high - low + 1;
	    
	    // while low in less than mid or mid < high chk the data values nd add to new arr wht is low
	    while(low<=midptr && mid<=high) {
		   if(arr[low] < arr[mid])
		   {
			   arr1[i++] = arr[low++];
		   }
		   else {
                  arr1[i++] = arr[mid++];
		         }
		 }
	    
	    // add remaining elements to the new array
	    while(low<=midptr){
	    	arr1[i++] = arr[low++];
	    }
	    
	    while(mid<=high){
	     arr1[i++] = arr[mid++];
	                   }
	      // copy back to original array
	    	for(i =0;i<length;i++){
	    		arr[lowptr + i] = arr1[i];
	    	}
	    }
   
      
   public static void main(String[] args) {
	MergeSort ms = new MergeSort();
	int len = ms.arr.length;
	ms.MergeSort(ms.arr1, 0, len-1);
	for(int j =0;j<ms.arr.length;j++){
           System.out.print(ms.arr[j] + " " );  
      }
   }
                       	
	
}
