
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
    // Atributo para definir si el reloj tiene formato de 24 o de 12 horas.
    private boolean formatoHora;
    // Atributo para el año de nuestro display
    private NumberDisplay year;
    // Atributo para el mes de nuestro display
    private NumberDisplay mes;
    // Atributo para el dia de nuestro display
    private NumberDisplay dia;
 
    /**
     * Constructor que fija la hora a "00:00" y nos permite elejir si queremos un reloj
     * en formato de 24 o de 12 horas(si el valor es false el reloj tendra el formato de 24 horas y si es true tendrá formato de 12 horas).
     * Además nos añade la fecha de hoy en formato de dos digitos para el día, dos para el mes y dos para el año (dd-mm-aa).
     */
    public ClockDisplay(boolean formatoH)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        year = new NumberDisplay(100);
        mes = new NumberDisplay(13);
        dia = new NumberDisplay(31);
        formatoHora = formatoH;
        year.setValue(15);
        mes.setValue(11);
        dia.setValue(20);
        modificarDisplay();
    }
    
    /**
     * Constructor que representan las horas y los minutos a los que fijar la hora actual y nos permite elejir si queremos un reloj
     * en formato de 24 o de 12 horas(si el valor es false el reloj tendra el formato de 24 horas y si es true tendrá formato de 12 horas).
     * Además nos permmite introducir la fecha que deseemos en formato de dos digitos para el día, dos para el mes y dos para el año (dd-mm-aa).
     */ 
    public ClockDisplay(int horaAct, int minutosAct, boolean formatoH, int confYear, int confMes, int confDia)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        year = new NumberDisplay(100);
        mes = new NumberDisplay(13);
        dia = new NumberDisplay(31);
        horas.setValue(horaAct); 
        minutos.setValue(minutosAct); 
        formatoHora = formatoH;
        year.setValue(confYear);
        mes.setValue(confMes);
        dia.setValue(confDia);
        modificarDisplay();
    }
    
    /**
     * Método setTime que acepta dos parámetros de tipo int, que representan horas y minutos,
     * y que fija dichos valores como el tiempo actual del reloj.
     * También acepta tres parámetros de tipo int, que representan la fecha en formato (dd-mm-aa) para poder
     * cambiar la fecha anterior de nuestro reloj.
     */
    public void setTime(int changeHoras, int changeMinutos, int changeYear, int changeMes, int changeDia)
    {
        horas.setValue(changeHoras);
        minutos.setValue(changeMinutos);
        year.setValue(changeYear);
        mes.setValue(changeMes);
        dia.setValue(changeDia);
        modificarDisplay();
    }
    
    /**
     * Método getTime que devuelva la hora como String con el formato adecuado según se haya elegido
     * en el constructor del reloj.
     */
    public String getTime()
    {
        return horaActual;
    }
    
    /**
     * Método timeTick que hace avanzar un minuto la hora actual y realiza los cambios pertinentes 
     * para que se actualicen todos los datos que luego se muestra en el display de nuestro reloj.
     */
    public void timeTick()
    {
        minutos.increment();
        if (minutos.getValue() == 0) {
            horas.increment();
            if (horas.getValue() == 0) {
                dia.increment();
                if (dia.getValue() == 0){
                    dia.increment();
                    mes.increment();
                    if (mes.getValue() == 0) {
                        mes.increment();
                        year.increment();
                    }
                }
            }
        }
        modificarDisplay();
    }
    
    /**
     * Este método hace que nuestro reloj, funcione como un reloj en formato de 12 horas o de 24 según lo
     * elijamos a la hora de crearlo en nuestro constructor y tambíen nos muestra la fecha.
     */
    public void modificarDisplay()
    {
        String fecha = dia.getDisplayValue() + "-" + mes.getDisplayValue() + "-" + year.getDisplayValue();
        String nuevaHora = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + "  " + fecha;
        if (formatoHora) {
            String formato = "a.m.";
            int horaAhora = horas.getValue(); 
            if (horaAhora >= 12){
                formato = "p.m.";
            }
            if (horaAhora > 12) {
                horaAhora = horaAhora - 12;
            }
            else if (horaAhora == 0) {
                horaAhora = 12;
            }
            nuevaHora = horaAhora + ":" + minutos.getDisplayValue() + " " + formato + "  " + fecha;
        }
        horaActual = nuevaHora;
    }
    
      /**
     * Este método nos permite cambiar el formato de la hora de 12 a 24 dependiento del formato que tenga de hora
     */
    public void modifFormato()
    {
        formatoHora = !formatoHora;
        modificarDisplay();
    }
}