package jogodeserto;

import Exception.TanqueCheioException;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;


public class PostoTest {
    private Caminhao caminhao;
    private Posto posto;

    public PostoTest() {}

    @Before
    public void setUp() {
       this.caminhao = mock(Caminhao.class);
       this.posto = new Posto();
    }


//    @Test(expected = ForaPostoException.class)
//    public void carregarFalhaForaDoPosto() throws ForaPostoException, Exception {
//        caminhao.executarComandoUsuario("avancar");
//        caminhao.executarComandoUsuario("carregar");
//    }

    @Test(expected = TanqueCheioException.class)
    public void carregarFalhaTanqueCheio() throws TanqueCheioException, Exception {
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
        this.posto.carregar(this.caminhao);
    }

    @Test
    public void carregarSucesso() throws Exception {
        this.posto.carregar(this.caminhao);
    }    
}
