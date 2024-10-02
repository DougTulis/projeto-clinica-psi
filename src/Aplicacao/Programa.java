package Aplicacao;

import Exceções.ConsultException;
import entidades.Consulta;
import entidades.Paciente;

import java.time.LocalDateTime;
import java.util.*;

public class Programa {
    public static void main(String[] args)  {

        List<Paciente> listaPaciente = new ArrayList<>();
        Set<LocalDateTime> listaDataAgenda = new HashSet<>();
        Set<Consulta> listaConsulta = new HashSet<>();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int decisao;
        do {
            System.out.println("---- SISTEMA DE GESTÃO PSICOLÓGICA ----");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Ver histórico de consultas");
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
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("-----AGENDAMENTO DE CONSULTA-----");
                        System.out.print("Digite o nome da paciente cadastrado: ");
                        nome = sc.nextLine();
                        System.out.print("Digite a data da consulta: ");
                        String stringData = sc.nextLine();
                        LocalDateTime data = LocalDateTime.parse(stringData, Consulta.fmt);
                        Consulta consulta = new Consulta(listaDataAgenda, listaPaciente, nome, data);
                        listaConsulta.add(consulta);
                    } catch (ConsultException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("-----HISTORICO DE CONSULTAS-----");
                    for (Consulta c: listaConsulta) {
                        System.out.println("Nome: " + c.getNomePaciente());
                        System.out.println("Data agendada: " + c.getData());
                        System.out.println("================================");
                    }
            }
        } while (decisao < 6);
    }
}
