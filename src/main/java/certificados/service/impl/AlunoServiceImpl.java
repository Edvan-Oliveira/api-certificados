package certificados.service.impl;

import certificados.domain.entity.Aluno;
import certificados.repository.AlunoRepository;
import certificados.service.AlunoService;
import certificados.service.exception.AlunoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Page<Aluno> listar(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(AlunoNaoEncontradoException::new);
    }

    @Override
    public void atualizar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public void deletar(Long id) {
        alunoRepository.delete(buscarPorId(id));
    }

    @Override
    public void concluirCurso(Aluno aluno) {
        Aluno alunoSalvo = buscarPorId(aluno.getId());
        alunoSalvo.setDataConclusao(aluno.getDataConclusao());
        alunoRepository.save(alunoSalvo);
    }
}
