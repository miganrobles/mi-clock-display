
/**
 *Añade al proyecto donde desarrollaste la clase NumberDisplay una nueva clase llamada ClockDisplay. 
 *Esta nueva clase debe:
 *Tener 2 atributos de tipo NumberDisplay, uno para las horas y otro para los minutos.
 *Tener un atributo de tipo String donde se almacena la hora actual del reloj con 5 caracteres.
 *Tener 2 constructores: uno sin parámetros, que fija la hora a "00:00" y otro con 2 parámetros de tipo
 *int, que representan las horas y los minutos a los que fijar la hora actual.
 *Tener un método setTime que acepte dos parámetros de tipo int, que representan horas y minutos,
 *y que fije dichos valores como el tiempo actual del reloj.
 *Tener un método getTime que devuelva la hora como String de 5 caracteres.
 *Tener un método timeTick que haga avanzar un minuto la hora actual (sea esta la que sea originalmente).

 *Una vez que hayas comprobado que funciona, sube el repositorio a GitHub e indica la URL del último 
 *commit como respuesta de esta actividad.
 */
public class ClockDisplay
{
    // Atributo para las horas
    private NumberDisplay horas;
    // Atributos para los minutos
    private NumberDisplay minutos;
    // Atributo donde almacenar la hora actual
    private String horaActual;
    // Atributo para definir si el reloj es de 24 o de 12 horas
    private boolean formatoHora;
    
    /**
     * Constructor que fija la hora a "00:00" y nos permite elejir si queremos un reloj
     * en formato de 24 o de 12 horas(si el valor es false funciona como 24 y si es true en formato de 12 horas).
     */
    public ClockDisplay(boolean formatoH)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        formatoHora = formatoH;
        modificarDisplay();
        
    }
    
    /**
     * Constructor que representan las horas y los minutos a los que fijar la hora actual y nos permite elejir si queremos un reloj
     * en formato de 24 o de 12 horas(si el valor es false funciona como 24 y si es true en formato de 12 horas).
     */ 
    public ClockDisplay(int horaAct, int minutosAct, boolean formatoH)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        horas.setValue(horaAct);
        minutos.setValue(minutosAct);
        formatoHora = formatoH;
        modificarDisplay();
    }
    
    /**
     * Método setTime que acepta dos parámetros de tipo int, que representan horas y minutos,
     * y que fija dichos valores como el tiempo actual del reloj.
     */
    public void setTime(int horaAc, int minutosAc)
    {
        horas.setValue(horaAc);
        minutos.setValue(minutosAc);
        modificarDisplay();
    }
    
    /**
     * Método getTime que devuelva la hora como String de 5 caracteres.
     */
    public String getTime()
    {
        return horaActual;
    }
    
    /**
     * Método timeTick que hace avanzar un minuto la hora actual.
     */
    public void timeTick()
    {
        minutos.increment();
        if (minutos.getValue() == 0) {
            horas.increment();
        }
        modificarDisplay();
    }
    
    /**
     * Este método hace que nuestro reloj funcione como un reloj en formato de 12 horas en vez de 24.
     */
    public void modificarDisplay()
    {
        if (formatoHora == true) {
            String formato = "";
            int horaAhora = horas.getValue(); 
            if (horaAhora >= 12){
                formato = "p.m.";
            }
            else {
                formato = "a.m.";
            }
            if (horaAhora > 12) {
                horaAhora = horaAhora - 12;
            }
            if (horaAhora == 0) {
                horaAhora = 12;
            }
            horaActual = horaAhora + ":" + minutos.getDisplayValue() + " " + formato;
        }
        else {
            horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        }
    }
    
      /**
     * Este método nos permite cambiar el formato de la hora de 12 a 24 dependiento del formato que tenga de hora
     */
    public void modifFormato()
    {
        if (formatoHora == true) {
            formatoHora = false;
        }
        else {
            formatoHora = true;
        }
        modificarDisplay();
    }
}
