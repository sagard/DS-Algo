// find if in arr 2 numbers sum upto a num using 2 method
// first one sorts the and has 2 pointers to find sum.
// other method creates a hash table and finds sum.

import java.util.Hashtable;

public class SumUptoNum {

	public void sumInplace(int[] arr,int k){
		//first sort the numbers if not sorted
		int sum =k;
		int j = arr.length - 1;
		int i =0;
		//take 2 pointers 1 frm start and end
		//if 1st and last equal tht sum print the number and increment 1st nd decrement 2nd
		//else if sum is greater;increment 1st num;
		//else increment 2nd
		while(j>i){
		if(arr[i]+arr[j] == sum)
		{
			System.out.println("sum is :"+arr[i]+"and"+arr [j]);
			i++; j--;
		}
		else if(arr[i]+ arr[j]< sum) i++;
		else if(arr[i]+ arr[j] >sum) j--;
	  }
	}
	

	public static void main(String[] args)
	{
		int[] arr ={1,2,2,3,4,4,5,7,8,9};
		int sum=9;
		sumUptoNum s = new sumUptoNum();
		s.sumInplace(arr,sum);

		//create hash table 
		Hashtable h =new Hashtable();
		int n = arr.length;
		for(int i=0;i<n;i++){
		  //chk if remainder in table;if there return both           numbers else add the number to table
			int rem = sum - arr[i];
			if(h.containsKey(rem))
			{
				System.out.println("sum is frm hash table :"+arr[i]+"and"+rem);
			}
			else
				h.put(arr[i], rem);
		}
	}	
}
