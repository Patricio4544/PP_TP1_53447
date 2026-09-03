import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    private final static int CUPO_MINIMO = 5;  // se mantiene constante para todas las actividades
    private List<Inscripcion> inscripciones; //lo pide al final del punto 2
    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.inscripciones = new ArrayList<>();
        if (cupoMaximo < CUPO_MINIMO) {
            this.cupoMaximo = CUPO_MINIMO;
        } else {
            this.cupoMaximo = cupoMaximo;
        }
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "REGISTRADA", this, estudiante);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.printf("    Inscriptos (%d/%d):%n", this.inscripciones.size(), this.cupoMaximo);
        if (this.inscripciones.isEmpty()) {
            System.out.println("      - No hay inscriptos aún.");
        } else {
            for (Inscripcion inscripcion : this.inscripciones) {
                System.out.printf("      - %s (Legajo: %s)%n",
                        inscripcion.getEstudiante().getNombre(),
                        inscripcion.getEstudiante().getLegajo());
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }
}
