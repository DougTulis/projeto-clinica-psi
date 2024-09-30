package Aplicacao;

import entidades.Consulta;
import entidades.Paciente;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Programa {
    public static void main(String[] args)  {

        List<Paciente> listaPaciente = new ArrayList<>();
        Set<LocalDateTime> listaAgendamento = new HashSet<>();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int decisao;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        do {
            System.out.println("---- SISTEMA DE GESTÃO PSICOLÓGICA ----");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Ver histórico de consultas");
            System.out.println("4. Gerenciar pagamentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            decisao = sc.nextInt();
            sc.nextLine();
            switch (decisao) {
                case 1:
                    System.out.println("-----CADASTRO DE PACIENTE-----");
                    System.out.print("Digite o nome do paciente: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o email do paciente: ");
                    String email = sc.next();
                    System.out.print("Digite o cpf do paciente: ");
                    String cpf = sc.next();
                    System.out.print("Digite o historico do paciente: ");
                    sc.next();
                    String historico = sc.nextLine();
                    Paciente paciente = new Paciente(nome, email, cpf, historico);
                    paciente.adicionarPaciente(listaPaciente, paciente);
                    System.out.println("PACIENTE CADASTRADO COM SUCESSO NO SISTEMA!");
                    System.out.println("Retornando ao menu principal...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    LocalDateTime dataHoraAtual = LocalDateTime.now();
                    boolean conflito = false;
                    System.out.println("-----AGENDAMENTO DE CONSULTA-----");
                    System.out.print("Digite o nome da paciente cadastrado: ");
                    sc.next();
                    nome = sc.nextLine();
                    for (Paciente p: listaPaciente) {
                        if (p.getNome().contains(nome)) {
                            System.out.print("Digite a data da consulta: ");
                            String stringData = sc.nextLine();
                            LocalDateTime data = LocalDateTime.parse(stringData, fmt);
                            if(data.isBefore(dataHoraAtual)) {
                                System.out.println("DATA INVALIDA! SELECIONE UMA DATA FUTURA.");
                                conflito = true;
                            } else {
                                for (LocalDateTime ldt : listaAgendamento) {
                                    if (ldt.equals(data) || (data.isBefore(ldt.plusHours(1)) && data.isAfter(ldt.minusHours(1)))) {
                                        System.out.println("CONFLITO DE AGENDA!");
                                        conflito = true;
                                        break;
                                    }
                                }
                            }
                            if(!conflito) {
                                listaAgendamento.add(data);
                                System.out.println("CONSULTA AGENDADA COM SUCESSO!");
                            }
                        } else {
                            System.out.println("PACIENTE NÃO EXISTENTE NO SISTEMA!");
                        }
                    }
                    break;
            }
        } while (decisao < 6);

    }
}
