
public class SubsetSum {
	int[] arr = {1,-4,5,-3,6,-5,-7};
	// keep 2 var and return the max sum in sequence of pos nd neg numbers
	public int maxsum(){
		int maxsum=0;
		int sum =0;
		
		for(int i=0;i<arr.length;i++)
		{
		    sum = sum + arr[i];
		    
			//if at any time the sum is greater than maxsum assng sum to maxsum		    
		    if(sum>maxsum)
			{
				maxsum = sum;
				System.out.println(maxsum);
			}
		    
		    //if it becomes less than 0 make sum as 0
			else if(sum<0)
			{
				sum = 0;
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetSum s = new SubsetSum();
		int max = s.maxsum();
		System.out.println("The max sum is :"+max);
	}
}
