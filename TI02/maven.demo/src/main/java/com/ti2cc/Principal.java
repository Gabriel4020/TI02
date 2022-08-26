package com.ti2cc;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
        int opcao;
        Scanner entrada = new Scanner(System.in);		
		dao.conectar();
        do{
            System.out.println("\tCadastro de clientes");
            System.out.println("0. Sair");
            System.out.println("1. Inserir um elemento na tabela");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Excluir usuário");
            System.out.println("4. Mostrar usuários");
            System.out.println("Opcao:");
            opcao = entrada.nextInt();
            Usuario carro = new Usuario(11, "pablo", "pablo",'M');
            switch(opcao){
            case 1:
        		//Inserir um elemento na tabela
        		carro = new Usuario(4, "bugatti", "def321",'N');
        		if(dao.inserirUsuario(carro) == true) {
        			System.out.println("Inserção com sucesso -> " + carro.toString());
        		}
                break;
                
            case 2:
        		//Atualizar usuário
        		carro.setPlaca("nova placa");
        		dao.atualizarUsuario(carro);
        		break;
                
            case 3:
        		//Excluir usuário
        		dao.excluirUsuario(carro.getCodigo());
        		break;
            case 4:
        		//Mostrar usuários
            	Usuario[] carros = dao.getUsuarios();
        		System.out.println("==== Mostrar usuários === ");		
        		for(int i = 0; i < carros.length; i++) {
        			System.out.println(carros[i].toString());
        		}
        		break;
        		
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
		dao.close();
	}
}