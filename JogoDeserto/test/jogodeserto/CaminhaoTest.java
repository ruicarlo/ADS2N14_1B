package jogodeserto;

import Exception.CaminhaoJaNoPostoException;
import Exception.ForaPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class CaminhaoTest {

    private Caminhao caminhao;
    private Posto posto;

    public CaminhaoTest() {
    }

    @Before
    public void setUp() {
        caminhao = new Caminhao();
        posto = new Posto();
    }

    @Test(expected = Exception.class)
    public void comandosFalha() throws Exception {
        caminhao.executarComandoUsuario(anyString());
    }

    @Test
    public void voltarSucesso() throws Exception {
        posto.carregar(caminhao);
        posto.carregar(caminhao);
        caminhao.executarComandoUsuario("avancar");
        caminhao.executarComandoUsuario("voltar");
    }

    @Test(expected = CaminhaoJaNoPostoException.class)
    public void voltarFalhaJaNoPosto() throws Exception {
        posto.carregar(caminhao);
        caminhao.executarComandoUsuario("voltar");
    }

    @Test(expected = GameOverException.class)
    public void voltarFalhaSemCombustivel() throws Exception {
        caminhao.executarComandoUsuario("voltar");
    }

    @Test
    public void avancarSucesso() throws Exception {
        posto.carregar(caminhao);
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
        posto.carregar(caminhao);
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