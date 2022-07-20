package divide;

import java.util.Arrays;
import java.util.Random;

public class CountZerosLeft 
{

	// TC:Theta(n) SC:O(1)
	public static int countZerosLeft1(int[] in) 
	{
		if (in.length == 0)
		{
			return 0;
		}
		
		for (int i = 0; i < in.length; ++i) 
		{
			if (in[i] != 0)
			{
				return i;
			}
		}
		
		return in.length;
	}

	// TC:Theta(log n) SC:O(1)
	public static int countZerosLeft2(int[] in) 
	{
		if (in.length == 0 || in[0] != 0)
		{
			return 0;
		}
		
		int l = 0, r = in.length - 1;
		
		while (l < r) 
		{
			int m = (int)Math.ceil((l + r) / 2.0);
			
			if (in[m] == 0)
			{
				l = m;
			}
			else
			{
				r = m - 1;
			}
		}
		
		return l+1;
	}

	public static void main(String[] args) 
	{
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		int k = r.nextInt(n);
		System.out.println("K value is: "+k);
		
		for (int i = k; i < n; ++i)
		{
			in[i] = r.nextInt(n) + 1;
		}

		System.out.println(Arrays.toString(in));
		System.out.println(countZerosLeft1(in));
		System.out.println(countZerosLeft2(in));

	}

}
