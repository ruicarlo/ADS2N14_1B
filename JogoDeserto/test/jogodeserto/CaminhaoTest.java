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
    public void setQtdCombustivel() {
        caminhao.setQtdCombustivel(6);
        assertEquals(6, caminhao.getQtdCombustivel());
    }

    @Test(expected = Exception.class)
    public void abastecerFalha() throws Exception {
        caminhao.setQtdCombustivel(6);
        caminhao.abastecer();
    }

    @Test
    public void abastecerSucesso() throws Exception {
        caminhao.abastecer();
    }

    @Test
    public void comandosSucesso()  throws Exception {
        String[] comandos = {"avançar","avancar","voltar","carregar","descarregar"};
        for(String comando : comandos) {
            assertEquals(true, caminhao.validarComando(comando));
            assertEquals(true, caminhao.validarComando(comando.toUpperCase()));
        }
    }

    @Test(expected = Exception.class)
    public void comandosFalha()  throws Exception {
        assertEquals(true, caminhao.validarComando(anyString()));
    }
    
    @Test
    public void andarSucesso() throws Exception {
        caminhao.abastecer();
        caminhao.andar();
    }
}