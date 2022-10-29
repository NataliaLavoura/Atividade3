package atividade3;

import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar = "n";
        int i = 0;
        Funcionario funcionario[] = new Funcionario[10];

        do {
            String tipoContrato;
            System.out.println("tipo de contrato: assalariado ou horista");
            tipoContrato = sc.next();
            sc.nextLine();

            if (i == 10) {
                System.out.println("\nnumero maximo atingido\n");

                break;
            } else if ("assalariado".equals(tipoContrato)) {

                System.out.println("informe o nome e o cpf:");

                String nome = sc.nextLine();
                String cpf = sc.nextLine();

                System.out.println("informe o endereço e o telefone:");
                String endereco = sc.nextLine();
                String telefone = sc.nextLine();

                System.out.println("informe o setor em que trabalha e salario:");
                String setor = sc.nextLine();
                double salario = sc.nextDouble();

                funcionario[i] = new Assalariado(salario, nome, cpf, endereco, telefone, setor);
                funcionario[i].mostrarDados();
                System.out.println("salario: " + String.format("%.3f", funcionario[i].calcularPagamento()));
                i++;
            } else if ("horista".equals(tipoContrato)) {

                System.out.println("informe o nome e o cpf:");
                String nome = sc.nextLine();
                String cpf = sc.nextLine();

                System.out.println("informe o endereço e o telefone:");
                String endereco = sc.nextLine();
                String telefone = sc.nextLine();

                System.out.println("informe o setor em que trabalha:");
                String setor = sc.nextLine();

                System.out.println("informe a quantidade de horas trabalhadas e o valor da hora");
                float horaTrabalhada = sc.nextFloat();
                double valorHora = sc.nextDouble();

                funcionario[i] = new Horista(horaTrabalhada, valorHora, nome, cpf, endereco, telefone, setor);
                funcionario[i].mostrarDados();
                System.out.println("salario: " + String.format("%.3f", funcionario[i].calcularPagamento()));
                i++;
            }
            System.out.println("");
            System.out.println("deseja continuar? ");
            continuar = sc.next();
            sc.nextLine();

        } while ("s".equals(continuar));

        for (i = 0; i < 10; i++) {

            if (funcionario[i] == null) {
                break;
            } else {
                funcionario[i].mostrarDados();
                System.out.println("salario: " + String.format("%.3f", funcionario[i].calcularPagamento()));
                System.out.println("");
            }
        }
        System.out.println("informe a porcentagem de aumento para aplicar:");
        int aumento = sc.nextInt();

        for (i = 0; i < 10; i++) {
            if (funcionario[i] == null) {
                break;
            } else {

                System.out.println("funcionario " + funcionario[i].getNome());
                System.out.println("salario após  o aumento: " + String.format("%.3f", funcionario[i].aplicarAumento(aumento)));
                System.out.println("");
            }
        }

    }

}
