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
    public void getQtdCargaCombustivel() {
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
    public void voltarSucesso() throws Exception {
        caminhao.executarComandoUsuario("avancar");
        caminhao.executarComandoUsuario("voltar");
    }

    @Test(expected = Exception.class)
    public void voltarFalha() throws Exception {
        caminhao.executarComandoUsuario("voltar");
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