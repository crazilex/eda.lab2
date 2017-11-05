package ParentesisDistra;
import java.util.Stack;

public class ExpresionAritmetica 
{
	public ExpresionAritmetica(){}
	
	public Double evaluar ( String expresionAritmetica )
	{
		Stack<Character> operadores = new Stack<Character>();
		Stack<Double> operandos = new Stack<Double>();
		
		int i = expresionAritmetica.length();
		while ( i != 0 ) 
		{
			Character c = expresionAritmetica.charAt(i); i--;
				 if ( c == '+' || c == '-' || c == '*') { operadores.push(c); }
			else if ( c == ')' ) 
			{
				Double x = operandos.pop();
				Double y = operandos.pop();
				Double z = 0.0;
				Character op = operadores.pop();
				     if ( op == '+' ) { z = x+y; }
				else if ( op == '-' ) { z = x-y; }
				else if ( op == '*' ) { z = x*y; }
				operandos.push(z);
			} 
			else 
			{
				String d = ""+c;
				Double e = Double.parseDouble(d); 
				operandos.push(e);
			}
		}
		Double w = operandos.pop(); 
		return w;
	}
}
