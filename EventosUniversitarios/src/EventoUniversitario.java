import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos; // de forma predeterminada se inicializa en 0
    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, boolean gratuito, double costoBase) {
        this.id = id;
        this.titulo = titulo;
        this.gratuito = gratuito;
        if (this.gratuito) {  // No hace falta hacer la comparación this.gratuito == true, ya que de por si es valor booleano
            this.costoBase = 0.0;
        } else {
            this.costoBase = costoBase;
        }
        EventoUniversitario.cantidadEventos = cantidadEventos + 1; // Queremos sumar 1 por cada evento creado, lo hacemos static
        this.actividades = new ArrayList<>();

    }


    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id + "- COPIA";   // Constructor sobrecargado para pasar un objeto como argumento
        this.titulo = otro.titulo;
        this.gratuito = otro.gratuito;
        this.costoBase = otro.costoBase;

    }

    public double calcularCostoEstimado() {
        return this.costoBase * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;  // al ser una agregación pasas los datos por main y listo
    }
    // al crear sala en main con constructor la asignas al atributo sala del objeto evento
    // mediante este metodo, guardando una referencia a this.sala

    public void crearActividad(int id, String titulo, int cupoMaximo) {
        Actividad actividad = new Actividad(id, titulo, cupoMaximo); // al ser var local actividad, cuando se acaba el
        this.actividades.add(actividad);  //metodo se pierde esa referencia  pero queda la  de la lista actividades
    }

    public List<Actividad> getActividades() {
        return Collections.unmodifiableList(actividades);
    }
    public String getId() {
        return id;
    }

//    public void setId(String id) {  ERROR: No podes setear una final, solo le asignas en constructor
//        this.id = id;
//    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String id) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean getGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public void mostrarDatos() {
        System.out.printf("========================================%n");
        System.out.printf("DATOS DEL EVENTO: %s%n", this.titulo);
        System.out.printf("========================================%n");
        System.out.printf("ID del evento: %s%n", this.id);
        System.out.printf("Costo estimado del evento: $%.2f%n", this.calcularCostoEstimado());
        System.out.printf("Sala asignada: %s (ID: %d)%n", this.sala.getNombre(), this.sala.getId());


        System.out.printf("%nActividades registradas: %d%n", this.actividades.size());
        for (Actividad actividad : this.actividades) {
                System.out.printf("  - %s (ID: %d) | Cupo máximo: %d%n",
                        actividad.getTitulo(), actividad.getId(), actividad.getCupoMaximo());
                actividad.mostrarInscripciones();
            }

        System.out.printf("========================================%n%n");
    }

    public static int getCantidadEventos() {
        return EventoUniversitario.cantidadEventos;
    }




}
