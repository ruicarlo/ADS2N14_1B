package jogodeserto;

import Exception.TanqueCheioException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostoTest {
    private Caminhao caminhao;
    private Posto posto;

    public PostoTest() {}

    @Before
    public void setUp() {
       this.caminhao = new Caminhao();
       this.posto = new Posto();
    }

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
        assertEquals(1,this.caminhao.getQtdCombustivel());
    }    
}
