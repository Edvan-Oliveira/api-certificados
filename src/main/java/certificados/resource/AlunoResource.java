package certificados.resource;

import certificados.domain.entity.Aluno;
import certificados.domain.mapper.AlunoMapper;
import certificados.domain.request.AlunoConcluiCursoRequest;
import certificados.domain.request.AlunoPostRequest;
import certificados.domain.request.AlunoPutRequest;
import certificados.domain.response.AlunoGetResponse;
import certificados.domain.response.PaginacaoResponse;
import certificados.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static certificados.domain.response.PaginacaoResponse.obterPaginacao;
import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    private static final String URL_ID = "/{id}";

    private final AlunoService alunoService;
    private final AlunoMapper alunoMapper;

    @GetMapping
    public ResponseEntity<PaginacaoResponse<Aluno>> listar(Pageable pageable) {
        return ResponseEntity.status(OK).body(obterPaginacao(alunoService.listar(pageable)));
    }

    @GetMapping(URL_ID)
    public ResponseEntity<AlunoGetResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(alunoMapper.converterParaAlunoGetResponse(alunoService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<AlunoGetResponse> cadastrar(@Valid @RequestBody AlunoPostRequest alunoPostRequest) {
        Aluno aluno = alunoService.cadastrar(alunoMapper.converterParaAluno(alunoPostRequest));
        return ResponseEntity.status(CREATED).body(alunoMapper.converterParaAlunoGetResponse(aluno));
    }

    @PutMapping(URL_ID)
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoPutRequest alunoPutRequest) {
        alunoPutRequest.setId(id);
        alunoService.atualizar(alunoMapper.converterParaAluno(alunoPutRequest));
        return ResponseEntity.status(NO_CONTENT).body(null);
    }

    @DeleteMapping(URL_ID)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.status(NO_CONTENT).body(null);
    }

    @PatchMapping(URL_ID)
    public ResponseEntity<Void> concluirCurso(@PathVariable Long id
            , @Valid @RequestBody AlunoConcluiCursoRequest alunoConcluiCursoRequest) {
        alunoConcluiCursoRequest.setId(id);
        alunoService.concluirCurso(alunoMapper.converterParaAluno(alunoConcluiCursoRequest));
        return ResponseEntity.status(NO_CONTENT).body(null);
    }
}
