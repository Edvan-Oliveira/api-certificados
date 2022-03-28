package certificados.domain.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter @Setter
public class PaginacaoResponse <T> {
    private List<?> conteudo;
    private int totalDePaginas;
    private int paginaAtual;
    private long totalDeElementos;
    private int elementosPorPagia;

    public PaginacaoResponse(Page<T> page) {
        conteudo = page.getContent();
        totalDePaginas = page.getTotalPages();
        paginaAtual = page.getPageable().getPageNumber();
        totalDeElementos = page.getTotalElements();
        elementosPorPagia = page.getPageable().getPageSize();
    }

    public static <E> PaginacaoResponse<E> obterPaginacao(Page<E> page) {
        return new PaginacaoResponse<>(page);
    }
}
