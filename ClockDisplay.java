
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
    
    /**
     * Constructor que fija la hora a "00:00"
     */
    public ClockDisplay()
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
    }
    
    /**
     * Constructor que representan las horas y los minutos a los que fijar la hora actual.
     */ 
    public ClockDisplay(int horaActual, int minutosActual)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        horas.setValue(horaActual);
        minutos.setValue(minutosActual);
        
    }
}
