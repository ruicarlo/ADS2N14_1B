package jogodeserto;

import Exception.ForaPostoException;
import Exception.TanqueCheioException;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;


public class PostoTest {
    private Caminhao caminhao;
    
    public PostoTest() {}

    @Before
    public void setUp() {
       this.caminhao = mock(Caminhao.class);
    }


    @Test(expected = ForaPostoException.class)
    public void carregarFalhaForaDoPosto() throws ForaPostoException, Exception {
        caminhao.executarComandoUsuario("avancar");
        caminhao.executarComandoUsuario("carregar");
    }

    @Test(expected = TanqueCheioException.class)
    public void carregarFalhaTanqueCheio() throws TanqueCheioException, Exception {
        caminhao.executarComandoUsuario("carregar");
    }

    @Test
    public void carregarSucesso() throws Exception {
        caminhao.executarComandoUsuario("avancar");
        caminhao.executarComandoUsuario("voltar");
        caminhao.executarComandoUsuario("carregar");
    }    

}
