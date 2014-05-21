package jogodeserto;

import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import static org.mockito.Mockito.*;

public class CaminhaoTest {
    private Caminhao caminhao;
    
    public CaminhaoTest() {}
    
    @Before
    public  void setUp() {
        caminhao = new Caminhao();
    }

    @Test
    public void testGetQtdCombustivel() {
        Assert.assertEquals(caminhao.getQtdCombustivel(), anyInt());
    }

    @Test
    public void testSetQtdCombustivel() {
        caminhao.setQtdCombustivel(6);
        Assert.assertEquals(6, caminhao.getQtdCombustivel());
    }

    @Test(expected = Exception.class)
    public void testAbastecerFalha() throws Exception {
        caminhao.setQtdCombustivel(6);
        caminhao.abastecer();
    }

    @Test
    public void testAbastecerSucesso() throws Exception {
        caminhao.abastecer();
    }

}