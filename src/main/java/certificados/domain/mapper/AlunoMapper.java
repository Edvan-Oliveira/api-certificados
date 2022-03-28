package certificados.domain.mapper;

import certificados.domain.entity.Aluno;
import certificados.domain.request.AlunoConcluiCursoRequest;
import certificados.domain.request.AlunoPostRequest;
import certificados.domain.request.AlunoPutRequest;
import certificados.domain.response.AlunoGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {
    public static final AlunoMapper INSTANCIA = Mappers.getMapper(AlunoMapper.class);
    public abstract AlunoGetResponse converterParaAlunoGetResponse(Aluno aluno);
    public abstract Aluno converterParaAluno(AlunoPostRequest alunoPostRequest);
    public abstract Aluno converterParaAluno(AlunoPutRequest alunoPutRequest);
    public abstract Aluno converterParaAluno(AlunoConcluiCursoRequest alunoConcluiCursoRequest);
}
