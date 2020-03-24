import java.util.*;

public class TypeCheckVisitor implements CalVisitor
{
	public SymbolTable symTable;
	public String scope = "global";
	
	public boolean arith = true;
	public boolean compop = true;
	public boolean assign = true;
	public boolean logical = true;
	public boolean declared = true;	
	
	public Object visit(SimpleNode node, Object data) {
		throw new RuntimeException("Visit SimpleNode");
	}

	//remember to check if function was invoked
	public Object visit(ASTProgram node, Object data) {
		symTable = (SymbolTable)data;
		node.childrenAccept(this, data);
		
		boolean dups = symTable.dedups();
		if(!declared)System.out.println("\nYou are using a variable, constant, or function that has not been declared yet.");
		if(arith) System.out.println("\nAll binary operations for plus and minus are legal.");
		if(compop) System.out.println("All comparisons are legal.");
		if(assign) System.out.println("The left hand side of assignments are valid.");
		if(logical) System.out.println("All logical comparisons for AND and OR are legal.");
		if(dups)System.out.println("There are no duplicate variables.");
		if(declared)System.out.println("All variables, constants, and functions are declared before being used.");
		return DataType.Program; //return data?
	}

	public Object visit(ASTVariableDecl node, Object data) {
		node.childrenAccept(this, data);
		return DataType.VariableDecl;
	}

	public Object visit(ASTConstantDecl node, Object data) {
		node.childrenAccept(this,data);
		
		SimpleNode simpleNode = (SimpleNode)node.jjtGetChild(0);
		DataType t1 = (DataType)node.jjtGetChild(1).jjtAccept(this, data);
		DataType t2 = (DataType)node.jjtGetChild(2).jjtAccept(this, data);
		
		if(t1 != t2)
		{
			assign = false;
			System.out.printf("\nProblem: %s assigned to incorrect type.\nExpected %s but found: %s\n", node,t1,t2);
		}
		return DataType.ConstantDecl;
	}

	public Object visit(ASTFuncBody node, Object data) {
		SimpleNode identifier = (SimpleNode)node.jjtGetChild(1);
		scope = (String)identifier.value;
		node.childrenAccept(this, data);
		return DataType.FuncBody;
	}

	public Object visit(ASTFunctionReturn node, Object data) {
		node.childrenAccept(this, data);
		scope = "global";
		return DataType.TypeUnknown; //check here
	}

	
	public Object visit(ASTType node, Object data) {
		String type = (String)node.value;
		if(type.equals("integer"))
		{
			return DataType.Number;
		}
		if(type.equals("boolean"))
		{
			return DataType.BooleanOperator;
		}
		return DataType.TypeUnknown;
	}

	public Object visit(ASTParameterList node, Object data) {
		for(int child = 0; child < node.jjtGetNumChildren(); child++)
		{
			node.jjtGetChild(child).jjtAccept(this, data);
		}
		return DataType.ParameterList;
	}

	public Object visit(ASTMain node, Object data) {
		scope = "main";
		node.childrenAccept(this, data);	
		scope = "global";
		return DataType.Main;
	}

	public Object visit(ASTStatement node, Object data) {
		node.childrenAccept(this, data);
		return DataType.Statement;
	}

	public Object visit(ASTAssignment node, Object data) {
		
		SimpleNode node1 = (SimpleNode) node.jjtGetChild(0);
        SimpleNode node2 = (SimpleNode) node.jjtGetChild(1);
        DataType t1 = (DataType) node1.jjtAccept(this, data);
        DataType t2 = (DataType) node2.jjtAccept(this, data);
        
        if(t1 != t2)
        {
        	assign = false;
        	System.out.printf("\nProblem: %s was assigned value of wrong type.\nExpected %s but found %s.\n", node1.value, t1, t2);
        }
		
		node.childrenAccept(this, data);
		return DataType.Assignment;
	}
	
	public Object visit(ASTFunctionAssignment node, Object data)
	{
		node.childrenAccept(this, data);
		return DataType.FunctionAssignment;
	}

	public Object visit(ASTConditionStm node, Object data) {
		node.childrenAccept(this, data);
		return DataType.ConditionStm;
	}

	public Object visit(ASTPlusOperator node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.Number;
		}
		arith = false;
		System.out.printf("\nProblem: incorrect type used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}
	
	public Object visit(ASTMinusOperator node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.Number;
		}
		arith = false;
		System.out.printf("\nProblem: incorrect type used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTOrCond node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.BooleanOperator) && (t2 == DataType.BooleanOperator))
		{
			return DataType.BooleanOperator;
		}
		
		logical = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two boolean operators but got: %s and %s.\n", node,t1,t2);
		return DataType.TypeUnknown;
		
	}

	public Object visit(ASTAndCond node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.BooleanOperator) && (t2 == DataType.BooleanOperator))
		{
			return DataType.BooleanOperator;
		}
		
		logical = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two boolean operators but got: %s and %s.\n", node,t1,t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTEqualTo node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if(t1 == t2)
		{
			return t1;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two of the same type but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}
	
	public Object visit(ASTNequalTo node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if(t1 == t2)
		{
			return t1;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two of the same type but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTLessThan node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.BooleanOperator;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTLequalTo node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.BooleanOperator;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTGreaterThan node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.BooleanOperator;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTGequalTo node, Object data) {
		SimpleNode node1 = (SimpleNode)node.jjtGetChild(0);
		SimpleNode node2 = (SimpleNode)node.jjtGetChild(1);
		DataType t1 = (DataType)node1.jjtAccept(this, data);
		DataType t2 = (DataType)node2.jjtAccept(this, data);
		
		if((t1 == DataType.Number) && (t2 == DataType.Number))
		{
			return DataType.BooleanOperator;
		}
		compop = false;
		System.out.printf("\nProblem: incorrect types used for: %s.\nExpected two numbers but got: %s and %s.\n", node,t1, t2);
		return DataType.TypeUnknown;
	}

	public Object visit(ASTArglist node, Object data) {
		for(int child = 0; child < node.jjtGetNumChildren(); child++)
		{
			node.jjtGetChild(child).jjtAccept(this, data);
		}
		return DataType.Arglist;
	}

	public Object visit(ASTBooleanOperator node, Object data) {
		return DataType.BooleanOperator;
	}
	
	public Object visit(ASTNumber node, Object data) {
		return DataType.Number;
	}

	//look at the node and see if its parent is a declaration
	//if the parent node is a declaration then it has no type yet
	//check scopes
	public Object visit(ASTId node, Object data) 
	{
		SimpleNode parentNode = (SimpleNode)node.jjtGetParent();
		String dataType = parentNode.toString();
		
		if(dataType != "ConstantDecl" && dataType != "VariableDecl" && dataType != "FuncBody")
		{
			String value = (String) node.jjtGetValue();
            boolean check = symTable.detectScope(scope,value);
            if (check) 
            {
                String type = symTable.getDataType(scope,value);
                if(type.equals("boolean")) return DataType.BooleanOperator;
                if(type.equals("integer")) return DataType.Number;
                else
                {
                	return DataType.TypeUnknown;
                }
            } 
            else 
            {
                boolean global = symTable.detectScope("global",value);
                if (global) {
                    String type = symTable.getDataType("global", value);
                    if(type.equals("boolean")) return DataType.BooleanOperator;
                    if(type.equals("integer")) return DataType.Number;
                    else
                    {
                    	return DataType.TypeUnknown;
                    }
                }
            }
            declared = false;
		}
		return DataType.TypeUnknown;
	}
	
}