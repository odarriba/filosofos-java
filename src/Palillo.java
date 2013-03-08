/*
 * Implementaci—n del problema de los fil—sofos en Java
 * 
 * Autor: îscar de arriba <odarriba@gmail.com>
 * Fecha: 08/03/13
 * Fichero: Palillo.java
 * 
 */

import java.util.concurrent.Semaphore;

public class Palillo {
	Semaphore semaforo;
	Integer id;
	
	Palillo(Integer id){
		this.semaforo = new Semaphore(1);
		this.id = id;
	}
	
	public boolean coger(){
		return semaforo.tryAcquire(); // tryAcquire para no bloquear los hilos y poder dejar libres los recursos si no se usan.
	}
	
	public void soltar(){
		semaforo.release();
	}
}
