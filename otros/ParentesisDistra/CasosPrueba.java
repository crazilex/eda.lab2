package ParentesisDistra;

public class CasosPrueba 
{
	public static void main(String[] args)
	{
		ExpresionAritmetica exp = new ExpresionAritmetica();
		System.out.println( exp.evaluar( "(1+((2+3)*(4*5)))" ) );			
	}
}
