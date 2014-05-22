package jogodeserto;

import Exception.ForaPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class CaminhaoTest {
    private Caminhao caminhao;
    
    public CaminhaoTest() {}
    
    @Before
    public  void setUp() {
        caminhao = new Caminhao();
    }

    @Test
    public void getQtdCombustivel() {
        assertEquals(caminhao.getQtdCombustivel(), 6);
    }

    @Test
    public void getPosicao() {
        assertEquals(caminhao.getPosicao(), anyInt());
    }

    @Test(expected = Exception.class)
    public void comandosFalha()  throws Exception {
        caminhao.executarComandoUsuario(anyString());
    }

    @Test
    public void avancarSucesso() throws Exception {
        caminhao.executarComandoUsuario("avancar");
    }

    @Test(expected = GameOverException.class)
    public void avancarFalha() throws GameOverException, Exception {
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("avancar");
    }

    @Test(expected = ForaPostoException.class)
    public void carregarFalhaForaDoPosto() throws ForaPostoException, Exception {
        //como o caminhao andou nao esta no posto (posicao 0)
        caminhao.executarComandoUsuario("avancar");
        caminhao.executarComandoUsuario("carregar");
    }

    @Test(expected = TanqueCheioException.class)
    public void carregarFalhaTanqueCheio() throws TanqueCheioException, Exception {
        caminhao.executarComandoUsuario("carregar");
    }

    @Test
    public void carregarSucesso() throws Exception {
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("carregar");
    }

    @Test
    public void descarregarSucesso() throws Exception {
        caminhao.executarComandoUsuario("descarregar");
    }
    
    @Test(expected = Exception.class)
    public void descarregarFalha() throws Exception {
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
        caminhao.executarComandoUsuario("descarregar");
    }
}