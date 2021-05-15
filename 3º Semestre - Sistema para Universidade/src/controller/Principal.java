package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Aluno;
import model.Curso;
import model.LerCSV;

public class Principal {

	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
        
	
	public static void main(String[] args) {
            
                LerCSV ls = new LerCSV();
                cursos = ls.lerCsvCursos();
                alunos = ls.inscreverAlunosCsv();
                
                Aluno al = new Aluno();
                al.setListaIds(alunos);
            
		Scanner scanner = new Scanner(System.in);
		
		Boolean executando = true;
		
		while(executando) {
			
			System.out.println("------------------------");
			System.out.println("Bem vindo ao Controle da Faculdade!");
			System.out.println("Escolha uma opção");
			System.out.println("1 - Listar cursos");
			System.out.println("2 - Listar alunos");
			System.out.println("3 - Listar relatório de rendimento");
			System.out.println("4 - Cadastrar aluno");
			System.out.println("5 - Cadastrar curso");
			System.out.println("6 - Cadastrar rendimento aluno");
			System.out.println("7 - Sair");
			System.out.println("------------------------");
			
			String resposta = scanner.next();
			
			//Ações das Opções 
			if(resposta.equals("1")) {
                            System.out.println("\n---- Lista de cursos ----");
				for(Curso curso : cursos) {
					curso.exibirDadosCurso();
				}
			}
			
			if(resposta.equals("2")) {
                            System.out.println("\n---- Lista de alunos ----");
				for(Aluno aluno : alunos) {
					aluno.exibirDadosAluno();
				}
			}
			
			if(resposta.equals("3")) {				
					int controle = 1;
					while(controle == 1) {
						System.out.println("Digite o curso desejado: ");
						String nomeCurso = scanner.next();
                                                System.out.println("Digite o nivel do curso: ");
                                                String nivelCurso = scanner.next();
                                                System.out.println("Digite o ano do curso: ");
                                                int anoCurso = scanner.nextInt();
					for(Curso curso : cursos) {
						if(nomeCurso.equals(curso.getNomeCurso()) && nivelCurso.equals(curso.getNivel()) && anoCurso == curso.getAno()) {
							curso.exibirRelatorioDeRendimento();
							controle = 0;
						} 	
					}
					
					if(controle == 1) {
					System.out.println("O curso desejado não existe.");
					}
					
					}				
			}
			
			if(resposta.equals("4")) {
				
                            Aluno novoAluno = new Aluno();

                            System.out.println("Digite o nome do aluno: ");
                            novoAluno.setNomeAluno(scanner.next());

                            while(true){
                                System.out.println("Digite o ID do aluno: ");
                                String idAluno = scanner.next();
                                boolean verificarId = false;
                                
                                for(Aluno al1 : alunos){
                                    if(al1.getId().equals(idAluno)){
                                        verificarId = false;
                                        break;
                                    } else {
                                        verificarId = true;
                                    }
                                }
                                
                                if(verificarId == false){
                                    System.out.println("Já existe um aluno cadastrado com esse ID.");
                                }else {
                                    novoAluno.setId(idAluno);
                                    break;
                                }
                            }
                            
                            while(true){
                                System.out.println("Digite a nota da Np1: ");
                                novoAluno.setNp1(Double.parseDouble(scanner.next()));
                                if(novoAluno.getNp1() >= 0 && novoAluno.getNp1() <= 10){
                                    break;
                                }else {
                                    System.out.println("Informe a nota da NP1 corretamente!");
                                }
                            }
                            
                            while(true){
                                System.out.println("Digite a nota da Np2: ");
                                novoAluno.setNp2(Double.parseDouble(scanner.next()));
                                if(novoAluno.getNp2() >= 0 && novoAluno.getNp2() <= 10){
                                    break;
                                }else {
                                    System.out.println("Informe a nota da NP2 corretamente!");
                                }
                            }
                            
                            while(true){
                                System.out.println("Digite a nota da Substitutiva: ");
                                novoAluno.setSub(Double.parseDouble(scanner.next()));
                                if(novoAluno.getSub() >= 0 && novoAluno.getSub() <= 10){
                                    break;
                                }else {
                                    System.out.println("Informe a nota da Substitutiva corretamente!");
                                }
                            }
                            
                            while(true){
                                System.out.println("Digite a nota do Exame: ");
                                novoAluno.setExame(Double.parseDouble(scanner.next()));
                                if(novoAluno.getExame() >= 0 && novoAluno.getExame() <= 10){
                                    break;
                                }else {
                                    System.out.println("Informe a nota do Exame corretamente!");
                                }
                            }

                            int controle = 1;
                            while(controle == 1) {
                                System.out.println("\nInforme alguns dados sobre o Curso em que este aluno está inscrito.");
                                System.out.println("Digite o nome do curso: ");
                                String nomeCurso = scanner.next();
                                System.out.println("Digite o nivel do curso: ");
                                String nivelCurso = scanner.next();
                                System.out.println("Digite o ano do curso: ");
                                int anoCurso = scanner.nextInt();
                                for(Curso curso : cursos) {
                                    String nomeDoCurso = curso.getNomeCurso();
                                    if(nomeCurso.equals(curso.getNomeCurso()) && nivelCurso.equals(curso.getNivel()) && anoCurso == curso.getAno()) {
                                        curso.inscreverAluno(novoAluno);
                                        novoAluno.setIdCursoInscrito(curso.getIdCurso());
                                        System.out.println("Aluno cadastrado no curso: " + nomeDoCurso);
                                        alunos.add(novoAluno);
                                        controle = 0;
                                    } 	
                                }

                                if(controle == 1) {
                                System.out.println("O curso desejado não existe.");
                                }
                            }
			}
			
			if(resposta.equals("5")) {
				Curso novoCurso = new Curso();
                            
				System.out.println("Digite o nome do curso: ");
				String nomeCurso = scanner.next();
				String nivel = "";
                                while(true){
                                    System.out.println("Digite o nível do curso (GRADUACAO ou POS_GRADUACAO): ");
                                    nivel = scanner.next();
                                    if("GRADUACAO".equals(nivel) || "POS_GRADUACAO".equals(nivel)){
                                        novoCurso.setNivel(nivel);
                                        break;
                                    }else{
                                        System.out.println("Nivel de curso inválido.");
                                    }
                                }
				
				System.out.println("Digite o ano do curso: ");
				int ano = Integer.valueOf(scanner.next());
				String idCurso = nomeCurso+nivel+String.valueOf(ano);
				novoCurso.setNomeCurso(nomeCurso);
				novoCurso.setAno(ano);
				
				novoCurso.setIdCurso(nomeCurso+nivel+String.valueOf(ano));
                                
                                cursos.add(novoCurso);
                                
			}
			
			
			if(resposta.equals("6")) {
				int controle = 1;
				while(controle == 1) {
					System.out.println("Digite o ID do aluno que deseja cadastrar o novo rendimento: ");
					String alunoDesejado = scanner.next();
				for(Aluno aluno : alunos) {
					String idDoAluno = aluno.getId();
					if(idDoAluno.equals(alunoDesejado)) {
						System.out.println("Digite a nota da Np1: ");
						aluno.setNp1(Double.parseDouble(scanner.next()));
						
						System.out.println("Digite a nota da Np2: ");
						aluno.setNp2(Double.parseDouble(scanner.next()));
						
						System.out.println("Digite a nota da Substitutiva: ");
						aluno.setSub(Double.parseDouble(scanner.next()));
						
						System.out.println("Digite a nota do Exame: ");
						aluno.setExame(Double.parseDouble(scanner.next()));
						
						controle = 0;						
					} 	
				}
				
				if(controle == 1) {
				System.out.println("O aluno desejado não existe.");
				}
				
				}
			}
			
			if(resposta.equals("7")) {
				System.out.println("--------------------");
				System.out.println("Programa encerrado.");
				System.out.println("--------------------");
				
				executando = false;
				break;
			}
				
			}
		
		scanner.close();
			
		}
		
		
	}


