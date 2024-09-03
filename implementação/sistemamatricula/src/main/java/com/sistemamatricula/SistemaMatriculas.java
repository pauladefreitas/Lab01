package com.sistemamatricula;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SistemaMatriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sistemamatricula_id", unique = true, nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplina_id")
    private List<Disciplina> disciplinas;

    @ManyToOne
    @JoinColumn(name = "cobranca_id")
    private Cobranca sistemaCobranca;

    @Column(name = "pMatricula")
    private boolean pMatricula; 

    public SistemaMatriculas(List<Disciplina> disciplinas, Cobranca sistemaCobranca) {
        this.disciplinas = disciplinas != null ? disciplinas : new ArrayList<>();
        this.sistemaCobranca = sistemaCobranca;
        this.pMatricula = false;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public Cobranca getSistemaCobranca() {
        return this.sistemaCobranca;
    }

    public void matricularAluno(Aluno aluno, Disciplina disciplina) {

        if (!pMatricula) {
            System.out.println("O período de matrículas está fechado. Matrícula não permitida.");
            return;
        }

        if (aluno == null || disciplina == null) {
            System.err.println("Aluno ou disciplina não fornecidos para matrícula.");
            return;
        } 
        
        else if (disciplina.getAlunos() != null && disciplina.getAlunos().contains(aluno)) {
            System.out.println("O aluno " + aluno.getNome() + " já está matriculado na disciplina: " + disciplina.getNome());
            return;
        } 
        
        else if (disciplina.getAlunos().size() < 60) {

            long obrigatorias = aluno.getCurso().getDisciplinas().stream()
            .filter(d -> d.isObrigatorio() && d.getAlunos().contains(aluno))
            .count();
    
            long optativas = aluno.getCurso().getDisciplinas().stream()
                .filter(d -> !d.isObrigatorio() && d.getAlunos().contains(aluno))
                .count();

                if (disciplina.isObrigatorio()) {
                    if (obrigatorias >= 4) {
                        System.out.println("O aluno " + aluno.getNome() + " já está matriculado em 4 disciplinas obrigatórias.");
                        return;
                    }
                } else {
                    if (optativas >= 2) {
                        System.out.println("O aluno " + aluno.getNome() + " já está matriculado em 2 disciplinas optativas.");
                        return;
                    }
                } 

            disciplina.addAluno(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na disciplina: " + disciplina.getNome());
            notificarSistemaCobrancas(aluno, disciplina);
        }
    }
    
    public void cancelarMatricula(Aluno aluno, Disciplina disciplina) {
        if (aluno == null || disciplina == null) {
            System.err.println("Aluno ou disciplina não fornecidos para cancelamento de matrícula.");
            return;
        }

        else if (!disciplina.getAlunos().contains(aluno)) {
            System.out.println("O aluno " + aluno.getNome() + " não está matriculado na disciplina: " + disciplina.getNome());
            return;
        } 

        else {
            disciplina.removerAluno(aluno);
            System.out.println("Matrícula do aluno " + aluno.getNome() + " cancelada na disciplina: " + disciplina.getNome());
            notificarSistemaCobrancas(aluno, disciplina);
        }
    }

    public void finalizarPeriodoMatriculas() {
        pMatricula = false;
        System.out.println("Finalizando o período de matrículas.");
        
        for (Disciplina disciplina : disciplinas) {
            disciplina.periodoMatricula();
        }
    }

    public void abrirPeriodoMatriculas() {
        pMatricula = true;
        System.out.println("Abrindo o período de matrículas.");
    }

    private void notificarSistemaCobrancas(Aluno aluno, Disciplina disciplina) {
        if (sistemaCobranca == null) {
            System.out.println("Sistema de cobrança não configurado.");
            return;
        }

        sistemaCobranca.notificarCobranca(aluno, disciplina);
    }
}
