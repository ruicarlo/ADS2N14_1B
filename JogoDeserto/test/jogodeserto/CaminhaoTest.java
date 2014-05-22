package jogodeserto;

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
        assertEquals(caminhao.getQtdCombustivel(), anyInt());
    }

    @Test
    public void getPosicao() {
        assertEquals(caminhao.getPosicao(), anyInt());
    }

    @Test(expected = Exception.class)
    public void comandosFalha()  throws Exception {
        caminhao.setComandoUsuario(anyString());
    }

    @Test
    public void avancarSucesso() throws Exception {
        caminhao.setComandoUsuario("carregar"); //pra avançar o caminhao precisa ter combustivel
        caminhao.setComandoUsuario("avancar");
    }

    @Test(expected = Exception.class)
    public void avancarFalha() throws Exception {
        caminhao.setComandoUsuario("avancar");
    }

    @Test(expected = Exception.class)
    public void carregarFalhaForaDoPosto() throws Exception {
        //como o caminhao andou nao esta no posto (posicao 0)
        caminhao.setComandoUsuario("avancar");
        caminhao.setComandoUsuario("carregar");
    }

    @Test(expected = Exception.class)
    public void carregarFalhaTanqueCheio() throws Exception {
        //nao é permitido carregar quando ja tem seis unidades de combustivel
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
        caminhao.setComandoUsuario("carregar");
    }

    @Test
    public void carregarSucesso() throws Exception {
        caminhao.setComandoUsuario("carregar");
    }

    @Test
    public void descarregarSucesso() throws Exception {
        caminhao.setComandoUsuario("carregar"); //pra descarregar o caminhao precisa ter combustivel
        caminhao.setComandoUsuario("descarregar");
    }
    
    @Test(expected = Exception.class)
    public void descarregarFalha() throws Exception {
        caminhao.setComandoUsuario("descarregar");
    }
}