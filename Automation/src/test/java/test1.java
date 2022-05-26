
public class test1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		boolean result = true;
		String pattern = "abba";
		String val = "this is a"
				+ " this";
		String[] values = val.split(" ");
		
		int j ;
		for(int i=0;i<pattern.length();i++)
		{
						
			for( j =i+1;j<pattern.length();j++)
			{

				if(pattern.charAt(i)==pattern.charAt(j))
				{
					if(values[i].equals(values[j]))
					{
					System.out.println(values[i]);
					System.out.println(values[j] + " both are equal");
					System.out.println(values[i].equals(values[j]));
					continue;
					}
					else
					{
						System.out.println(values[i] + " both are not equal " +values[j] );
						System.out.println(values[i].equals(values[j]));
						result = false;
						break;
					}
				}
				
			}
			
			if(j!=pattern.length())
			{
				break;
			}	
			
		}
		
	}

}
