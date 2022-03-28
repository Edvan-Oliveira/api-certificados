package certificados.service;

import certificados.domain.entity.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoService {
    Aluno cadastrar(Aluno aluno);
    Page<Aluno> listar(Pageable pageable);
    Aluno buscarPorId(Long id);
    void atualizar(Aluno aluno);
    void deletar(Long id);
    void concluirCurso(Aluno aluno);
}
