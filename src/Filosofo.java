import java.util.concurrent.Semaphore;
import java.util.Date;

public class Filosofo extends Thread {
	boolean palillos_cogidos;
	Palillo pal_derecha;
	Palillo pal_izquierda;
	Integer id;
	
	static Semaphore lock = new Semaphore(1);
	
	Filosofo(Palillo pal_derecha, Palillo pal_izquierda, Integer id)
	{
		this.pal_derecha = pal_derecha;
		this.pal_izquierda = pal_izquierda;
		this.id = id;
		this.palillos_cogidos = false;
	}
	
	public void run(){
		while(true)
		{
			while(this.palillos_cogidos == false){
				esperar_lock();
				if (this.pal_izquierda.coger())
				{
					if (this.pal_derecha.coger())
					{
						this.palillos_cogidos = true;
					}
					else
					{
						this.pal_izquierda.soltar();
					}
				}
				soltar_lock();
			}
			
			comer();
			
			esperar_lock();
			this.pal_derecha.soltar();
			this.pal_izquierda.soltar();
			palillos_cogidos = false;
			soltar_lock();
			
			pensar();
		}
	}
	
	private void esperar_lock(){
			try{
				lock.acquire();
			}catch(InterruptedException e){
				System.err.println("Error al esperar el filosofo "+this.id+" : "+e);
			}
	}
	
	private void soltar_lock(){
		lock.release();
	}
	
	private void comer()
	{
		try{
			System.out.println((new Date())+" - Filosofo "+id+" est‡ comiendo...");
			Thread.sleep(5000);
		} catch (InterruptedException e){
			System.err.println("Error mientras el filosofo "+id+" come: "+e);
		}
	}
	
	private void pensar()
	{
		try{
			System.out.println((new Date())+" - Filosofo "+id+" est‡ pensando...");
			Thread.sleep(5000);
		} catch (InterruptedException e){
			System.err.println("Error mientras el filosofo "+id+" pensando: "+e);
		}
	}
}
