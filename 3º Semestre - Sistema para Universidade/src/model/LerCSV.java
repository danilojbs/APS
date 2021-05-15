package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerCSV {
    
    public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    public static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
public ArrayList<Curso> lerCsvCursos() {
    String arquivoCSV = "src\\csv\\cursos.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            Curso novoCurso = new Curso();
            String[] curso = linha.split(csvDivisor);
            novoCurso.setNomeCurso(curso[curso.length-3]);
            novoCurso.setNivel(curso[curso.length-2]);
            novoCurso.setAno(Integer.valueOf(curso[curso.length-1]));
            novoCurso.setIdCurso(curso[curso.length-3] + curso[curso.length-2] + curso[curso.length-1]);
            cursos.add(novoCurso);
        }
    
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return cursos;
    }
    
public ArrayList<Aluno> lerCsvAlunos() {
    String arquivoCSV = "src\\csv\\alunos.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            Aluno novoAluno = new Aluno();
            String[] aluno = linha.split(csvDivisor);
            novoAluno.setId(aluno[aluno.length-2]);
            novoAluno.setNomeAluno(aluno[aluno.length-1]);
            alunos.add(novoAluno);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return alunos;
    }
    
public ArrayList<Aluno> cadastroALPOO_GRADUACAO_2019() {
    
    String arquivoCSV = "src\\csv\\ALPOO_GRADUACAO_2019.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            String[] aluno = linha.split(csvDivisor);
            
            for(Curso cs : cursos){
                if("ALPOOGRADUACAO2019".equals(cs.getIdCurso())){
                    for(Aluno al : alunos){
                        if(al.getId().equalsIgnoreCase(aluno[aluno.length-5])){
                            Curso cs1 = new Curso();
                            al.setIdCursoInscrito("ALPOOGRADUACAO2019");
                            al.setNp1(Double.valueOf(aluno[aluno.length-4]));
                            al.setNp2(Double.valueOf(aluno[aluno.length-3]));
                            al.setSub(Double.valueOf(aluno[aluno.length-2]));
                            al.setExame(Double.valueOf(aluno[aluno.length-1]));
                            cs1.inscreverAluno(al);
                            
                        }
                    }
                }
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return alunos;
    }

public ArrayList<Aluno> cadastroALPOO_GRADUACAO_2018() {
    
    String arquivoCSV = "src\\csv\\ALPOO_GRADUACAO_2018.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            String[] aluno = linha.split(csvDivisor);
            
            for(Curso cs : cursos){
                if("ALPOOGRADUACAO2018".equals(cs.getIdCurso())){
                    for(Aluno al : alunos){
                        if(al.getId().equalsIgnoreCase(aluno[aluno.length-5])){
                            Curso cs1 = new Curso();
                            al.setIdCursoInscrito("ALPOOGRADUACAO2018");
                            al.setNp1(Double.valueOf(aluno[aluno.length-4]));
                            al.setNp2(Double.valueOf(aluno[aluno.length-3]));
                            al.setSub(Double.valueOf(aluno[aluno.length-2]));
                            al.setExame(Double.valueOf(aluno[aluno.length-1]));
                            cs1.inscreverAluno(al);
                            
                        }
                    }
                }
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return alunos;
    }

public ArrayList<Aluno> cadastroALPOO_POS_GRADUACAO_2019() {
    
    String arquivoCSV = "src\\csv\\ALPOO_POS_GRADUACAO_2019.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            String[] aluno = linha.split(csvDivisor);
            
            for(Curso cs : cursos){
                if("ALPOOPOS_GRADUACAO2019".equals(cs.getIdCurso())){
                    for(Aluno al : alunos){
                        if(al.getId().equalsIgnoreCase(aluno[aluno.length-5])){
                            Curso cs1 = new Curso();
                            al.setIdCursoInscrito("ALPOOPOS_GRADUACAO2019");
                            al.setNp1(Double.valueOf(aluno[aluno.length-4]));
                            al.setNp2(Double.valueOf(aluno[aluno.length-3]));
                            al.setSub(Double.valueOf(aluno[aluno.length-2]));
                            al.setExame(Double.valueOf(aluno[aluno.length-1]));
                            cs1.inscreverAluno(al);
                            
                        }
                    }
                }
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return alunos;
    }

public ArrayList<Aluno> cadastroLPOO_GRADUACAO_2020() {
    
    String arquivoCSV = "src\\csv\\LPOO_GRADUACAO_2020.csv";
    BufferedReader br = null;
    String linha = "";
    String csvDivisor = ";";
    try {
        br = new BufferedReader(new FileReader(arquivoCSV));
        while ((linha = br.readLine()) != null) {
            String[] aluno = linha.split(csvDivisor);
            
            for(Curso cs : cursos){
                if("LPOOGRADUACAO2020".equals(cs.getIdCurso())){
                    for(Aluno al : alunos){
                        if(al.getId().equalsIgnoreCase(aluno[aluno.length-5])){
                            Curso cs1 = new Curso();
                            al.setIdCursoInscrito("LPOOGRADUACAO2020");
                            al.setNp1(Double.valueOf(aluno[aluno.length-4]));
                            al.setNp2(Double.valueOf(aluno[aluno.length-3]));
                            al.setSub(Double.valueOf(aluno[aluno.length-2]));
                            al.setExame(Double.valueOf(aluno[aluno.length-1]));
                            cs1.inscreverAluno(al);
                            
                        }
                    }
                }
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
        return alunos;
    }


public ArrayList<Aluno> inscreverAlunosCsv() {
    alunos = lerCsvAlunos();
    alunos = cadastroALPOO_GRADUACAO_2018();
    alunos = cadastroALPOO_GRADUACAO_2019();
    alunos = cadastroALPOO_POS_GRADUACAO_2019();
    alunos = cadastroLPOO_GRADUACAO_2020();
    
    return alunos;
}

}