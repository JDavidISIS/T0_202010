package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <K extends Comparable <K>> implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private K[] elementos;

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (K[]) new Comparable[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar(Comparable dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    K[] copia = (K[]) elementos;
                    elementos = (K[]) new Comparable[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = (K) dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
			
			if(i > elementos.length)return null;
			return (String) elementos[i];
			
		}

		public String buscar(Comparable dato) {
			
			String buscado = null;
			for (int i = 0; i < elementos.length; i++) {
				if(darElemento(i).compareTo((String) dato) == 0)
				{
					buscado = darElemento(i);
				}
			}
			
			return buscado;
		}

		public String eliminar(Comparable dato) {
			
			K[] copia = elementos;
			String eliminado = null;
			for (int i = 0; i < elementos.length; i++) {
				
				if(darElemento(i).compareTo((String) dato) == 0)
				{
					eliminado = (String) elementos[i];
					
					if(i == 0 || (i > 0 && i < elementos.length) )
					{
						tamanoAct--;
						copia [i] = elementos[i+1] ;
						elementos[i] = copia[i];
					}
					else if ( i == elementos.length)
					{
						tamanoAct--;
					}
					
				}
				
			}
			
			return eliminado;
			
		}
}


