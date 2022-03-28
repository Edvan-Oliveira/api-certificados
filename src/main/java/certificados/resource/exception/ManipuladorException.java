package certificados.resource.exception;

import certificados.service.exception.AlunoNaoEncontradoException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ManipuladorException {

    @ExceptionHandler(AlunoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> alunoNaoEncontradoException(AlunoNaoEncontradoException excecao,
                                                                  HttpServletRequest requisicao) {
        ErroPadrao erro = ErroPadrao.builder()
                .caminho(requisicao.getRequestURI())
                .status(NOT_FOUND.value())
                .mensagem(excecao.getMessage())
                .momento(LocalDateTime.now())
                .build();
        return ResponseEntity.status(NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> methodArgumentNotValidException(MethodArgumentNotValidException excecao,
                                                                      HttpServletRequest requisicao) {
        ErroPadrao erro = ErroPadrao.builder()
                .caminho(requisicao.getRequestURI())
                .status(BAD_REQUEST.value())
                .mensagem(obterMensagemDeValidacao(excecao))
                .momento(LocalDateTime.now())
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(erro);
    }

    private String obterMensagemDeValidacao(MethodArgumentNotValidException excecao) {
        List<String> erros = excecao.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        StringBuilder mensagem = new StringBuilder();
        for (String erro: erros) mensagem.append(" => ").append(erro);
        return mensagem.toString();
    }
}
