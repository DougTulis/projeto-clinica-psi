package entidades;

import java.util.List;
import java.util.Objects;

public class Paciente {

    private String nome;
    private String email;
    private String cpf;
    private String historico;
    public Paciente() {
    }

    public Paciente(String nome, String email, String cpf, String historico) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.historico = historico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void adicionarPaciente(List<Paciente> lista, Paciente paciente) {
        lista.add(paciente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(email, paciente.email) && Objects.equals(cpf, paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, cpf);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "CPF: " + cpf + "\n" +
                "Historico do paciente:" + historico;
    }
}
