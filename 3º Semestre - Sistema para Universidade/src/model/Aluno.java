package model;


import java.util.ArrayList;


public class Aluno {
	private String id; 
	private String nomeAluno;
	private double np1;
	private double np2;
	private double sub;
	private double exame;
	private boolean situacao = false;
        private String idCursoInscrito;
        
        public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public Aluno() {
	}
        
        public String getIdCursoInscrito(){
            return this.idCursoInscrito;
        }
        
        public void setIdCursoInscrito(String idCursoInscrito){
            this.idCursoInscrito = idCursoInscrito;
        }
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
        
        public void setListaIds(ArrayList<Aluno> alunos){
            this.alunos = alunos;
        }
        
        public boolean verificarId(String id){
            if(alunos.contains(id)){
                return false;
            }else {
                return true;
            }
        }
	
	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}
	
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	
	public double getNp1() {
		return np1;
	}
	public void setNp1(double np1) {
		this.np1 = np1;
	}
	public double getNp2() {
		return np2;
	}
	public void setNp2(double np2) {
		this.np2 = np2;
	}
	public double getSub() {
		return sub;
	}
	public void setSub(double sub) {
		this.sub = sub;
	}
	public double getExame() {
		return exame;
	}
	public void setExame(double exame) {
		this.exame = exame;
	}
	
	public void exibirDadosAluno() {
		System.out.println("\nID: " + getId());
		System.out.println("Nome: " + getNomeAluno());
                System.out.println("Id do Curso: " + getIdCursoInscrito());

	}
	
	
}
