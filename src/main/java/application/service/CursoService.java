package application.service;

import application.dto.curso.*;
import application.mapper.CursoMapper;
import domain.model.Curso;
import domain.repository.CursoRepository;
import shared.exceptions.CursoException;

import java.util.List;

public class CursoService {

    private final CursoMapper cursoMapper;
    private final CursoRepository cursoRepository;

    public CursoService(CursoMapper cursoMapper, CursoRepository cursoRepository) {
        this.cursoMapper = cursoMapper;
        this.cursoRepository = cursoRepository;
    }

    public CadastrarCursoResponse cadastrarCurso(CadastrarCursoRequest request) {
        if(request == null) {
            throw new CursoException("O Curso Não Pode Ser Nulo.");
        }

        Curso curso = cursoMapper.toEntity(request);

        return cursoRepository.cadastrarCurso(curso);
    }

    public ExcluirCursoResponse excluirCurso(ExcluirCursoRequest request) {
        if(request == null) {
            throw new CursoException("O Curso Não Pode Ser Nulo.");
        }

        return cursoRepository.excluirCurso(request);
    }

    public List<ListarCursoResponse> listarCurso(ListarCursoRequest request) {
        if(request == null) {
            throw new CursoException("O Nome do Curso Não Pode Ser Nulo.");
        }

        return cursoRepository.listarCurso(request);
    }

    public List<ListarTodosCursoResponse> listarTodosCurso() {

        return cursoRepository.listarTodosCurso();
    }

    public EditarStatusCursoResponse editarStatusCurso(EditarStatusCursoRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("O Id do Curso Não Pode Ser Nulo.");
        }

        return cursoRepository.editarStatusCurso(request);
    }
}
