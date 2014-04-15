import java.util.Hashtable;

// find if sum of 3 numbers equal to 0
// use the logic that a+ b = -c so create a hashtable of all -ve values 
//loop through and find which 2 numbers sum is equal to -ve of number.

public class SumOfThreeNum {

	void createHash(int[] arr){
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		// put all -ve of array elements as key
		for(int i=0;i<arr.length;i++)
		{
			ht.put(-arr[i],-arr[i]);
			//System.out.print(ht.get(arr[i]));
		}

		// chk for if a + b = -c
		for(int j =0;j<arr.length;j++)
		{
			for(int k=j+1;k<arr.length;k++){

				int sum = arr[j] + arr[k];
				// if -c present return a,b and c
				if(ht.get(sum)!=null)
				{
					System.out.println("numbers are :" + arr[j] + " " + arr[k] + " " + (-1)*ht.get(sum));
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,-9,4,8,12,-3,-5,2};
		Sumoffthreenum s = new Sumoffthreenum();
		s.createHash(arr);

	}
}
