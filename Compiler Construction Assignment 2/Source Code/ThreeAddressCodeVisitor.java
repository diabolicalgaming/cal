public class ThreeAddressCodeVisitor implements CalVisitor{

	public static boolean activeLabel = false;
	public static int labelCounter = 1;
	public static int tmp = 1;
	
	public void isLabelActive(String str)
	{
		System.out.println(str);
		activeLabel = true;
		labelCounter++;
	}
	
	public void printer(String str)
	{
		if(!activeLabel)
		{
			System.out.println("\t" + str);
		}
		else
		{
			System.out.println("\t" + str); activeLabel = false;
		}
	}
	
	public Object visit(SimpleNode node, Object data) {
		throw new RuntimeException("Visit SimpleNode");
	}

	public Object visit(ASTProgram node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}
	
	public Object visit(ASTVariableDecl node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}
	
	public Object visit(ASTConstantDecl node, Object data) {
		String identifier = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String type = (String)node.jjtGetChild(1).jjtAccept(this, data);
		String expression = (String)node.jjtGetChild(2).jjtAccept(this, data);
		printer(identifier + " = " + expression);
		return null;
	}

	
	public Object visit(ASTFuncBody node, Object data) {
		SimpleNode identifier =  (SimpleNode)node.jjtGetChild(1);
		String iden = (String)identifier.jjtAccept(this, data).toString();
		isLabelActive(iden + ":");
		node.childrenAccept(this, data);
		return null;
	}

	//return value is always the second last child node in my Abstract Syntax Tree
	//in three address code a function return is either
	//'return' if you return no value
	//or 'return x' if you decide to return a value
	//the least number of child nodes can only be 3, because FuncBody -> Type(1) -> Id(2) -> FunctionReturn(3)
	public Object visit(ASTFunctionReturn node, Object data) {
		SimpleNode parent = (SimpleNode)node.jjtGetParent();
        int numOfChildren = parent.jjtGetNumChildren();
		if(parent.jjtGetNumChildren() == 3)
		{
			System.out.println("\treturn");
		}
		else if(parent.jjtGetNumChildren() > 3)
		{
			SimpleNode position = (SimpleNode)parent.jjtGetChild(numOfChildren-2);
			String value = "";
			if(position.toString().equals("Id"))
			{
				value = "\treturn " + position.value;
			}
			else
			{
				value = "\treturn";
			}
			System.out.println(value);
		}
		return null;
	}

	
	public Object visit(ASTType node, Object data) {
		return node.jjtGetValue();
	}

	
	public Object visit(ASTParameterList node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	
	public Object visit(ASTMain node, Object data) {
		isLabelActive("main:");
		node.childrenAccept(this, data);
		return null;
	}

	
	public Object visit(ASTStatement node, Object data) {
		node.childrenAccept(this, data);
		return null;
	}

	
	public Object visit(ASTAssignment node, Object data) {
		Node arglist = node.jjtGetChild(1);
		String arglistStr = (String)arglist.toString();
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		int argsCounter = 0;
		String str = "";
		if(arglistStr.equals("Arglist"))
		{
			SimpleNode parent = (SimpleNode)node.jjtGetParent();
			String child = (String)parent.jjtGetChild(0).jjtAccept(this, data);
			for(int i = 0; i < arglist.jjtGetNumChildren(); i++)
			{
				argsCounter++;
			}
			String identifier = (String)node.jjtGetChild(0).jjtAccept(this, data);
			System.out.println("\t" + child + " = call " + identifier + ", " + argsCounter);
		}
		else
		{
			str = node1 + " = " + node2;
			printer(str);
		}
		return str;
	}

	
	public Object visit(ASTFunctionAssignment node, Object data) {
		String identifier = (String)node.jjtGetChild(0).jjtAccept(this, data);
		Node arglist = node.jjtGetChild(1);
		int argsCounter = 0;
		for(int i = 0; i < arglist.jjtGetNumChildren(); i++)
		{
			argsCounter++;
		}
		node.childrenAccept(this, data);
		System.out.println("\tcall " + identifier + ", " + argsCounter);
		return null;
	}

	
	public Object visit(ASTConditionStm node, Object data) {
		String value = (String)node.jjtGetValue();
		String label;
		String ifOrWhile;
		String gotoLabel;
		String exitLabel;
		
		if(value.equals("while"))
		{
			label = "L" + labelCounter;
			isLabelActive(label + ":");
			gotoLabel =  "L" + labelCounter;
			labelCounter++;
			ifOrWhile = (String)node.jjtGetChild(0).jjtAccept(this, data);
			printer("if " + ifOrWhile + " goto " + gotoLabel);
			exitLabel = "L" + labelCounter;
			labelCounter++;
			printer("goto " + exitLabel);
			isLabelActive(gotoLabel + ":");
			for(int i = 1; i < node.jjtGetNumChildren(); i++)
			{
				node.jjtGetChild(i).jjtAccept(this,data);
			}
			printer("goto " + label);
			isLabelActive(exitLabel + ":");
			return null;
		}
		else if(value.equals("if"))
		{
			if(node.jjtGetNumChildren() > 2)
			{
				label = "L" + labelCounter;
				labelCounter++;
				gotoLabel =  "L" + labelCounter;
				labelCounter++;
				exitLabel = "L" + labelCounter;
				labelCounter++;
				ifOrWhile = (String)node.jjtGetChild(0).jjtAccept(this, data);
				printer("if " + ifOrWhile + " goto " + label);
				printer("goto " + gotoLabel);
				isLabelActive(label + ":");
				node.jjtGetChild(1).jjtAccept(this,data);
				printer("goto " + exitLabel);
				
				isLabelActive(gotoLabel + ":");
				node.jjtGetChild(2).jjtAccept(this,data);
				isLabelActive(exitLabel + ":");
			}
			else
			{
				label = "L" + labelCounter;
				labelCounter++;
				gotoLabel =  "L" + labelCounter;
				labelCounter++;
				ifOrWhile = (String)node.jjtGetChild(0).jjtAccept(this, data);
				printer("if " + ifOrWhile + " goto " + label);
				printer("goto " + gotoLabel);
				isLabelActive(label + ":");
				node.jjtGetChild(1).jjtAccept(this,data);
				
				isLabelActive(gotoLabel + ":");
			}
			return null;
		}
		return null;
	}
	
	public Object visit(ASTPlusOperator node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		String mt = "mt" + tmp++;
		System.out.println("\t" + mt + " = " + node1 + " " + node.jjtGetValue() + " " + node2);
		return mt;
	}

	public Object visit(ASTMinusOperator node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		String mt = "mt" + tmp++;
		System.out.println("\t" + mt + " = " + node1 + " " + node.jjtGetValue() + " " + node2);
		return mt;
	}

	public Object visit(ASTOrCond node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		String mt = "mt" + tmp++;
		System.out.println("\t" + mt + " = " + node1 + " || " + node2);
		return mt;
	}
	
	public Object visit(ASTAndCond node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		String mt = "mt" + tmp++;
		System.out.println("\t" + mt + " = " + node1 + " && " + node2);
		return mt;
	}
	
	public Object visit(ASTEqualTo node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + "==" + " " + node2;
	}
	
	public Object visit(ASTNequalTo node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + node.jjtGetValue() + " " + node2;
	}
	
	public Object visit(ASTLessThan node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + node.jjtGetValue() + " " + node2; 
	}
	
	public Object visit(ASTLequalTo node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + node.jjtGetValue() + " " + node2;
	}
	
	public Object visit(ASTGreaterThan node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + node.jjtGetValue() + " " + node2;
	}

	public Object visit(ASTGequalTo node, Object data) {
		String node1 = (String)node.jjtGetChild(0).jjtAccept(this, data);
		String node2 = (String)node.jjtGetChild(1).jjtAccept(this, data);
		
		return node1 + " " + node.jjtGetValue() + " " + node2;
	}
	
	public Object visit(ASTArglist node, Object data) {
		for(int i = node.jjtGetNumChildren()-1; i >= 0; i--)
		{
			SimpleNode identifier = (SimpleNode)node.jjtGetChild(i);
			String iden = (String)identifier.jjtAccept(this, data).toString();
			printer("param " + iden);
		}
		return null;
	}

	public Object visit(ASTBooleanOperator node, Object data) {
		return node.jjtGetValue();
	}

	public Object visit(ASTNumber node, Object data) {
		return node.jjtGetValue();
	}

	public Object visit(ASTId node, Object data) {
		return node.jjtGetValue();
	}

}
