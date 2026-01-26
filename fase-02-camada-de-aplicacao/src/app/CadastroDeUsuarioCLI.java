package app;

import application.dto.BuscarPorEmailInput;
import application.dto.BuscarPorEmailOutput;
import application.dto.CadastrarUsuarioInput;
import application.dto.CadastrarUsuarioOutput;
import application.ports.UsuarioRepository;
import application.usecase.BuscarPorEmailUseCase;
import application.usecase.CadastrarUsuarioUseCase;
import dominio.UsuarioJaExisteException;
import infra.InMemoryUsuarioRepository;

import java.util.Scanner;

public class CadastroDeUsuarioCLI {

    public static void main(String[] args){

        UsuarioRepository repository = new InMemoryUsuarioRepository();

        CadastrarUsuarioUseCase cadastrar = new CadastrarUsuarioUseCase(repository);
        BuscarPorEmailUseCase buscar = new BuscarPorEmailUseCase(repository);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("MENU: \n0: Sair. \n1: Cadastro de Usuário.\n2: Buscar por Usuário.");
            System.out.println("Informe um numero do menu: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 0: {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                case 1: {

                    System.out.println("Cadastro de Usuários:");

                    System.out.println("Informe o nome do usuário: ");
                    String nome = sc.nextLine();

                    System.out.println("Informe o email do usuário: ");
                    String email = sc.nextLine();

                    System.out.println("Informe a idade do usuário: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    try {
                        CadastrarUsuarioInput input = new CadastrarUsuarioInput(nome, email, idade);

                        CadastrarUsuarioOutput output = cadastrar.executar(input);

                        System.out.println("Usuário cadastrado com sucesso!!");
                        System.out.println(output.nome() + " - " + output.email() + " - " + output.idade());

                    } catch (UsuarioJaExisteException e) {
                        System.out.println("Já existe um usuário com esse email.");
                    } catch (IllegalAccessError e){
                        System.out.println("Dados inválidos: " + e.getMessage());
                    } catch (RuntimeException e){
                        System.out.println("Erro inesperado: " + e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Buscar por email:");
                    System.out.println("Informe o email do usuário: ");
                    String email = sc.nextLine();

                    try {
                        BuscarPorEmailInput input = new BuscarPorEmailInput(email);

                        BuscarPorEmailOutput output = buscar.executar(input);

                        System.out.println("Usuário encontrado: ");
                        System.out.println(output.nome() + " - " + output.email() + " - " + output.idade());

                    } catch (RuntimeException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;
                }
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}
