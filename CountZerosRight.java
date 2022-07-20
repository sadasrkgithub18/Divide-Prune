package divide;

import java.util.Arrays;
import java.util.Random;

public class CountZerosRight 
{

	// TC:Theta(n) SC:O(1)
	// 1 5 4 3 2
	public static int countZerosRight1(int[] in)
	{
		if (in.length == 0)
		{
			return 0;
		}
		
		for (int i = in.length - 1; i >= 0; --i) 
		{
			if (in[i] != 0)
			{
				return in.length - i - 1;
			}
		}
		
		return in.length;
	}

	// TC:Theta(log n) SC:O(1)
	public static int countZerosRight2(int[] in) 
	{
		if (in.length == 0 || in[in.length - 1] != 0)
		{
			return 0;
		}
		
		int l = 0, r = in.length - 1;
		
		while (l < r) 
		{
			int m = (l + r) / 2;
			
			if (in[m] == 0)
			{
				r = m;
			}
			else
			{
				l = m + 1;
			}
		}
		
		return in.length - l;
	}

	public static void main(String[] args) 
	{
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		int k = r.nextInt(n);
		System.out.println("K value is: "+k);
		
		for (int i = 0; i < k; ++i)
		{
			in[i] = r.nextInt(n) + 1;
		}

		System.out.println(Arrays.toString(in));
		System.out.println(countZerosRight1(in));
		System.out.println(countZerosRight2(in));

	}

}
