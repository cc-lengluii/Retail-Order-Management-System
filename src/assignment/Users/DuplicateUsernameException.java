/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Users;

/**
 *
 * @author User
 */
public class DuplicateUsernameException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Duplicate Username!";
    }
}
