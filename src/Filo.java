
public class Filo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palillo pal1 = new Palillo(1);
		Palillo pal2 = new Palillo(2);
		Palillo pal3 = new Palillo(3);
		Palillo pal4 = new Palillo(4);
		Palillo pal5 = new Palillo(5);
		
		Filosofo fil1 = new Filosofo(pal5, pal1, 1);
		Filosofo fil2 = new Filosofo(pal1, pal2, 2);
		Filosofo fil3 = new Filosofo(pal2, pal3, 3);
		Filosofo fil4 = new Filosofo(pal3, pal4, 4);
		Filosofo fil5 = new Filosofo(pal4, pal5, 5);
		
		fil1.start();
		fil2.start();
		fil3.start();
		fil4.start();
		fil5.start();
	}

}
