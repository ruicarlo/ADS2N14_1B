package jogodeserto;

import Exception.CaminhaoJaNoPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class CaminhaoTest {

    private Caminhao caminhao;

    public CaminhaoTest() {
    }

    @Before
    public void setUp() {
        this.caminhao = new Caminhao();
    }

    @Test(expected = Exception.class)
    public void comandosFalha() throws Exception {
        this.caminhao.executarComandoUsuario(anyString());
    }

    @Test
    public void voltarSucesso() throws Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.executarComandoUsuario("avancar");
        this.caminhao.executarComandoUsuario("voltar");
    }

    @Test(expected = CaminhaoJaNoPostoException.class)
    public void voltarFalhaJaNoPosto() throws Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.executarComandoUsuario("voltar");
    }

    @Test(expected = GameOverException.class)
    public void voltarFalhaSemCombustivel() throws Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.executarComandoUsuario("avancar");
        this.caminhao.executarComandoUsuario("voltar");
    }

    @Test
    public void avancarSucesso() throws Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.executarComandoUsuario("avancar");
    }

    @Test(expected = GameOverException.class)
    public void avancarFalha() throws GameOverException, Exception {
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("descarregar");
        this.caminhao.executarComandoUsuario("avancar");
    }

    @Test(expected = TanqueCheioException.class)
    public void carregarFalha() throws GameOverException, Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.adicionarQtdCombustivel();
    }

    @Test
    public void descarregarSucesso() throws Exception {
        this.caminhao.adicionarQtdCombustivel();
        this.caminhao.executarComandoUsuario("descarregar");
        assertEquals(0, this.caminhao.getQtdCombustivel());
    }

    @Test(expected = Exception.class)
    public void descarregarFalha() throws Exception {
        this.caminhao.executarComandoUsuario("descarregar");
    }
}