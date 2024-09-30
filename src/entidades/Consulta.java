package entidades;

import Exceções.ConsultException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class Consulta {

    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Set<LocalDateTime> historicoConsulta;
    private Paciente paciente;
    private LocalDateTime data;
    private String nomePaciente;

    public Consulta() {
    }

    public Consulta(Set<LocalDateTime> historicoConsulta, List<Paciente> listaPaciente, String nomePaciente, LocalDateTime data) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        if (data.isBefore(dataHoraAtual)) {
            throw new ConsultException("A data informada deve ser posterior á data atual");
        } else {
            for (LocalDateTime agendamentosExistentes : historicoConsulta) {
                if (agendamentosExistentes.isEqual(data)) {
                    throw new ConsultException("A data informada já consta agendada no sistema");
                }
            }
        }
            for (LocalDateTime agendamentosExistentes : historicoConsulta) {
                if (data.isBefore(agendamentosExistentes.plusHours(1)) && data.isAfter(agendamentosExistentes.minusHours(1))) {
                    throw new ConsultException("É obrigatório agendar uma hora de diferença entre as consultas.");
                }
            }
            for (Paciente pc : listaPaciente) {
                if (!pc.getNome().contains(nomePaciente)) {
                    throw new ConsultException("O nome do paciente informado não consta no sistema.");
                }
            }
        this.paciente = paciente;
        this.data = data;
        this.nomePaciente = nomePaciente;
        this.historicoConsulta = historicoConsulta;
    }

    public Set<LocalDateTime> getHistoricoConsulta() {
        return historicoConsulta;
    }

    public void setHistoricoConsulta(Set<LocalDateTime> historicoConsulta) {
        this.historicoConsulta = historicoConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}
