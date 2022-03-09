public class GreatestSumSplitArray {
	
	public static void main(String[] args) {
		
		int arr[] = {7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(arr, m));
		
	}
	
	public static int splitArray(int[] nums, int m) {
        
		int start = 0;
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > start) {
				start = nums[i];
			}
			end = end + nums[i];
		}
		
		while (start < end) {

			int mid = start + (end - start)/2;
			
			int sum = 0;
			int splitting = 1;
			
			for (int num : nums) {
				if (sum + num > mid) {
					//finding sum of the new sub array
					//so we need to calculate sum from the later number
					sum = num;
					//as we are splitting, so we need to increase the splitting number
					splitting++;
				} else {
					sum += num;
				}
			}
			if (splitting > m) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
    }
	
}
