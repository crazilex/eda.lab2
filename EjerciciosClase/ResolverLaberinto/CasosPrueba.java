package ResolverLaberinto;

public class CasosPrueba 
{
	public static void main(String[] args)
	{
		int[][] mariz = { {0 , 1 , 0 , 0} , {0 , 0 , 0 , 1} , {0 , 1 , 0 , 1} , {0 , 1 , 0 , 0} }; 
		Laverinto laberinto = new Laverinto(mariz);
		
		laberinto.imprimirLaberinto();
		System.out.println(" ");

		laberinto.imprimirRecorrido();
	}
}
