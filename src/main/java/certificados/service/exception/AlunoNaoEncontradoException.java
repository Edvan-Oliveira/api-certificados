package certificados.service.exception;

public class AlunoNaoEncontradoException extends RuntimeException {

    public AlunoNaoEncontradoException() {
        super("Aluno não foi encontrado");
    }
}
