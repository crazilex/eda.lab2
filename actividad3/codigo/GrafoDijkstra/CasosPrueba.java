package GrafoDijkstra;

public class CasosPrueba 
{
	public static void main(String[] args)
	{
		Web w0 = new Web(0, "AAA");
		Web w1 = new Web(1, "BBB");
		Web w2 = new Web(2, "CCC");
		Web w3 = new Web(3, "DDD");
		Web w4 = new Web(4, "EEE");
		Web w5 = new Web(5, "FFF");
		Web w6 = new Web(6, "GGG");
		Web w7 = new Web(7, "HHH");
		Web w8 = new Web(8, "III");
		Web w9 = new Web(9, "JJJ");
		
		w0.add(2); w0.add(4); w0.add(5);        
		w1.add(0); w1.add(3); w1.add(7);
		w2.add(9); w2.add(0);
		w3.add(8);
		w4.add(5);
		w6.add(2);
		w7.add(3);
		w8.add(6); 
		w9.add(6);
		
		ListaWebs lista = new ListaWebs();
		lista.anadirPrimero(w0); lista.anadirPrimero(w1); lista.anadirPrimero(w2);
		lista.anadirPrimero(w3); lista.anadirPrimero(w4); lista.anadirPrimero(w5);
		lista.anadirPrimero(w6); lista.anadirPrimero(w7); lista.anadirPrimero(w8);
		lista.anadirPrimero(w9);
		
		Grafo grafo = new Grafo( lista );
		grafo.imprimirGrafo();		
	}
}
