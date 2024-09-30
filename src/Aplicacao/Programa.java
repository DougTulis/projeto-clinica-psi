package Aplicacao;

import entidades.Paciente;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        List<Paciente> lista = new ArrayList<>();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int decisao;
        do {
            System.out.println("---- SISTEMA DE GESTÃO PSICOLÓGICA ----");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Ver histórico de consultas");
            System.out.println("4. Gerenciar pagamentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            decisao = sc.nextInt();
            switch (decisao) {
                case 1:
                    System.out.println("-----CADASTRO DE PACIENTE-----");
                    System.out.print("Digite o nome do paciente: ");
                    String nome = sc.nextLine();
                    sc.next();
                    System.out.print("Digite o email do paciente: ");
                    String email = sc.next();
                    System.out.print("Digite o cpf do paciente: ");
                    String cpf = sc.next();
                    System.out.print("Digite o historico do paciente: ");
                    sc.next();
                    String historico = sc.nextLine();
                    Paciente paciente = new Paciente(nome, email, cpf, historico);
                    paciente.adicionarPaciente(lista, paciente);
                    System.out.println("PACIENTE CADASTRADO COM SUCESSO NO SISTEMA!");
                    System.out.println("Retornando ao menu principal...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    break;
                


            }
        } while (decisao < 6);

    }
}
