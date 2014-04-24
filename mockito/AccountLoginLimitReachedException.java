/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mockito;

/**
 *
 * @author aluno
 */
public class AccountLoginLimitReachedException extends Exception{
    public AccountLoginLimitReachedException (){
        super("limite de logins atingido");
    }
}
