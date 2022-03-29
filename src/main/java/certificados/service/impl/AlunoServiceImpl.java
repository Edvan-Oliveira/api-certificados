package certificados.service.impl;

import certificados.domain.entity.Aluno;
import certificados.repository.AlunoRepository;
import certificados.service.AlunoService;
import certificados.service.exception.AlunoNaoEncontradoException;
import certificados.service.exception.DataConclusaoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        Aluno alunoSalvo = buscarPorId(aluno.getId());
        aluno.setDataInicio(alunoSalvo.getDataInicio());
        aluno.setDataConclusao(alunoSalvo.getDataConclusao());
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
        validarDataConclusao(alunoSalvo);
        alunoRepository.save(alunoSalvo);
    }

    private void validarDataConclusao(Aluno aluno) {
        if (aluno.getDataConclusao().getTime() > new Date().getTime())
            throw new DataConclusaoException("Data conclusão não pode ser maior que a data atual");
        if (aluno.getDataConclusao().getTime() < aluno.getDataInicio().getTime())
            throw new DataConclusaoException("Data conclusão não pode ser menor que a data início");
    }
}
