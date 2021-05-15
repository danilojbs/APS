package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Curso {
	private String nomeCurso;
	private String nivel;
	private Integer ano;
	private String idCurso;
	private double media;
	
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
	public void inscreverAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nome) {
		this.nomeCurso = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
		
		if(this.nivel.equals("GRADUACAO")) {
			this.media = 7;
		}
		
		if(this.nivel.equals("POS_GRADUACAO")) {
			this.media = 5;
		}
		
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	
	public boolean verificarCurso(String idCurso) {
            if(getIdCurso() == idCurso){
                return true;
            }else{
                return false;
            }
	}
	
	public void exibirDadosCurso() {
		System.out.println("\nNome do curso: " + getNomeCurso());
		System.out.println("Nível: " + getNivel());
		System.out.println("Ano: " + getAno());
		System.out.println("ID: " + getIdCurso());
	}
	
	public void exibirRelatorioDeRendimento() {
		double rendimentoTotal = 0;
		double mediaAluno = 0;
		
		int contador = 0;
                	System.out.println("\n--------------------");
			System.out.println("Relatório de Rendimento do Curso: " + this.nomeCurso + "_" + this.nivel + "_" + this.ano);
                        System.out.println("--------------------");
                        
		for(Aluno aluno : alunos) {
                    if(getIdCurso().equals(aluno.getIdCursoInscrito())){
                        System.out.println("Nome: " + aluno.getNomeAluno());
			System.out.println("ID: " + aluno.getId());
			System.out.println("");
			System.out.println("NP1: " + aluno.getNp1());
			System.out.println("NP2: " + aluno.getNp2());
			System.out.println("SUB: " + aluno.getSub());
			System.out.println("Exame: " + aluno.getExame());
			
			if((aluno.getNp1() + aluno.getNp2()) < this.media *  2) {
				if(aluno.getNp1() > 0 && aluno.getNp2() > 0) {
					mediaAluno = (aluno.getNp1() + aluno.getNp2()) / 2;
					if(mediaAluno + aluno.getExame() < this.media * 2) {
						mediaAluno = (mediaAluno + aluno.getExame()) / 2;
						aluno.setSituacao(false);
					} else {
						aluno.setSituacao(true);
					}
				}
				if(aluno.getNp1() <= 0) {
					if(aluno.getNp2() + aluno.getSub() < this.media * 2) {
						mediaAluno = (aluno.getNp2() + aluno.getSub()) / 2;
						if((mediaAluno + aluno.getExame()) / 2 < this.media * 2) {
							mediaAluno = (mediaAluno + aluno.getExame()) / 2;
							aluno.setSituacao(false);
						} else {
							mediaAluno = (mediaAluno + aluno.getExame()) / 2;
							aluno.setSituacao(true);
						}
					} else {
						mediaAluno = (aluno.getNp2() + aluno.getSub()) / 2;
						aluno.setSituacao(true);
					}
				} 
				
				if(aluno.getNp2() <= 0) {
					if(aluno.getNp1() + aluno.getSub() < this.media * 2) {
						mediaAluno = (aluno.getNp1() + aluno.getSub()) / 2;
						if((mediaAluno + aluno.getExame()) / 2 < this.media * 2) {
							aluno.setSituacao(false);
							mediaAluno = (mediaAluno + aluno.getExame()) / 2;
						} else {
							mediaAluno = (mediaAluno + aluno.getExame()) / 2;
							aluno.setSituacao(true);
						}
					} else {
						mediaAluno = (aluno.getNp1() + aluno.getSub()) / 2;
						aluno.setSituacao(true);
					}
				}
				
			} else {
				mediaAluno = (aluno.getNp1() + aluno.getNp2()) / 2;
				aluno.setSituacao(true);
			}
			
			if(aluno.isSituacao() == true) {
				System.out.println("\nAluno aprovado.");
			} else {
				System.out.println("\nAluno reprovado.");
			}
			
			rendimentoTotal = rendimentoTotal + mediaAluno;
		
			System.out.println("Média do aluno: " + mediaAluno + "\n");
                        System.out.println("--------------------");
			contador = contador + 1;
                    }
                }
                rendimentoTotal = rendimentoTotal / contador;
                if(rendimentoTotal >= 0){
                    System.out.println("Rendimento total: " + String.format("%.2f", rendimentoTotal));
                }else {
                    System.out.println("Não existe nenhum aluno cadastrado nesse curso.");
                }
        }
}
