package io.deoki.blog.service;

import io.deoki.blog.entity.Account;
import io.deoki.blog.entity.Login;
import io.deoki.blog.repository.LoginRepository;
import io.deoki.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository users;
    LoginRepository logins;

    /**
     * Use the Account entity to save or update one Account.
     * @param account
     * @return savedAccount
     */
    public Account saveAccount(Account account) {
        Account savedAccount = users.save(account);
        return savedAccount;
    }

    /**
     * Use the Login entity to save or update one Login.
     * @param login
     * @return savedLogin
     */
    public Login saveLogin(Login login) {
        Login savedLogin = logins.save(login);
        return savedLogin;
    }

    /**
     * Use the id to find one Account.
     * Returns null in case the Account does not exist
     * @param id
     * @return account
     */
    public Account findAccountById(Long id){
        return users.findById(id).orElse(null);
    }

    /**
     * Check the exist Account using Account ID.
     * @param id
     * @return boolean
     **/
    public boolean existsAccountById(Long id){
        return users.existsById(id);
    }

    /**
     * Delete Account using the Account ID.
     * @param id
     */
    public void deleteAccount(Long id){
        users.deleteById(id);
    }

    /**
     * Delete Account using the Account list.
     * @param account
     */
    public void deleteAccount(Account account){
        users.delete(account);
    }

}
