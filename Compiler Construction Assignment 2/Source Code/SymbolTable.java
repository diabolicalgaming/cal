import java.util.*;

public class SymbolTable extends Object
{
	public Hashtable<String, LinkedList<String>> symTable;
	public Hashtable<String, String> dataTypes;
	public Hashtable<String, String> keywords;
	
	public SymbolTable()
	{	
		this.symTable = new Hashtable<>();
		this.dataTypes = new Hashtable<>();
		this.keywords = new Hashtable<>();
		
		symTable.put("global", new LinkedList<>());
	}
	
	public void push(String scope, String keyword, String identifier, String type)
	{
		LinkedList<String> ll = symTable.get(scope);
		if(ll == null)
		{
			ll = new LinkedList<>();
			ll.add(identifier);
			symTable.put(scope, ll);
		}
		else
		{
			ll.addFirst(identifier);
		}
		
		dataTypes.put(identifier + scope, type);
		keywords.put(identifier + scope, keyword);
	}
	
	public void output()
	{
		Enumeration enumerates = symTable.keys();
		
		while(enumerates.hasMoreElements())
		{
			String scope = (String) enumerates.nextElement();
			System.out.printf("The scope is: %s\n", scope);
			
			LinkedList<String> llIds = symTable.get(scope);
			
			for(int i = 0; i < llIds.size(); i++)
			{
				String keyword = keywords.get(llIds.get(i)+scope);
				String dataType = dataTypes.get(llIds.get(i)+scope);
				System.out.printf("(%s, %s, %s)\n",keyword,dataType,llIds.get(i));
			}
			System.out.println();
		}
		
	}
	
	public String getDataType(String scope, String identifier)
	{
		return dataTypes.get(identifier + scope);
	}
	
	public String getKeyword(String scope, String identifier)
	{
		return keywords.get(identifier + scope);
	}
	
	public boolean detectScope(String scope, String identifier)
	{
		LinkedList<String> ll = symTable.get(scope);
		if(ll == null)
		{
			return false;
		}
		if(ll.contains(identifier))
		{
			return true;
		}
		return false;
	}
	
	public boolean dedups()
	{	
		boolean detect = true;
		Enumeration enumerates = symTable.keys();
		
		while(enumerates.hasMoreElements())
		{
			String scope = (String) enumerates.nextElement();
			LinkedList<String> ll = symTable.get(scope);
			
			while(ll.size() > 0)
			{
				String identifier = ll.pop();
				if(ll.contains(identifier))
				{
					detect = false;
					System.out.println("\nProblem: " + identifier + " has already been defined in " + scope + ".");
				}
			}
		}
		return detect;
	}
}
