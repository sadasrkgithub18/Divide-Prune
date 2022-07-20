package divide;

import java.util.Arrays;
import java.util.Random;

public class MinimumInRotatedSortedArray 
{

	//TC:Theta(log n)   SC:O(1)
	public static int minInRotatedSortedArray(int[] in) 
	{
		int l = 0, r = in.length - 1;
		
		while (l < r)
		{
			int m = (l + r) / 2;
			
			if (in[m] < in[r])
			{
				r = m;
			}
			
			else
			{
				l = m + 1;
			}
		}
		
		return in[l];
	}

	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		
		for(int i = 0; i < n; ++i)
		{
			in[i] = i+1;
		}
		
		int k = new Random().nextInt(n);
		System.out.println("K Value is: "+k);
		RotateArray.rotateArray3(in, k);
		System.out.println(Arrays.toString(in));
		System.out.println(minInRotatedSortedArray(in));		

	}

}
