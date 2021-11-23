public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;

    private int billetesVendidos;

    private boolean maquinaPremio;

    private int numeromaximoBilletes;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio,int numeromaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaPremio = premio;
        numeromaximoBilletes = numeromaximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (billetesVendidos <= numeromaximoBilletes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }  
        else{
            System.out.println("todos los billetes vendidos" + numeromaximoBilletes);
        }   
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta=precioBillete - balanceClienteActual;
        if (billetesVendidos <= numeromaximoBilletes){
            if (cantidadDeDineroQueFalta <= 0) {    
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                billetesVendidos+=1;

                if (maquinaPremio == true){
                    System.out.println("descuento de"+precioBillete*0.1+"precio en �");
                } 

            }
            else{
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
            }
        }
        else{
                System.out.println("todos los billetes vendidos" + numeromaximoBilletes);
            }
        }
    
        
    
        /**
         * Cla la operacion de compra del cliente actual y le
         * devuelve al cliente el dinero que ha introducido hasta el momento
         */

        public int cancelarOperacionYDevolverDinero() {
            int cantidadDeDineroADevolver;
            cantidadDeDineroADevolver = balanceClienteActual;
            balanceClienteActual = 0;
            return cantidadDeDineroADevolver;
        } 

        public int vaciarDineroDeLaMaquina() {   
            int vaciarDinero;
            vaciarDinero=totalDineroAcumulado + balanceClienteActual;

            if (balanceClienteActual > 0){
                System.out.println("No se puede vaciar la maquina");
                vaciarDinero = -1;  
            }
            else {
                balanceClienteActual = 0;
                totalDineroAcumulado = 0;
            }

            return vaciarDinero;
        }

        public int getNumeroBilletesVendidos() {

            return billetesVendidos;  

        }

        public void imprimeNumeroBilletesVendidos() {

            System.out.println ("NumeroBilletesVendidos"+ billetesVendidos);
        }  
    }

