package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Consulta {

    private Set<LocalDateTime> historicoConsulta;
    private  Paciente paciente;

    public Consulta() {
    }

    public Consulta(Set<LocalDateTime> historicoConsulta, Paciente paciente) {
        this.historicoConsulta = historicoConsulta;
        this.paciente = paciente;
    }

}
