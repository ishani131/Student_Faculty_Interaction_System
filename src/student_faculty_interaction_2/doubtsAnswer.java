/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

/**
 *
 * @author Ishani
 */
public class doubtsAnswer {
    String username;
    String subject;
    String doubt;
    String answer;
    String status;

    public doubtsAnswer(String username, String subject, String doubt, String answer, String status) {
        this.username = username;
        this.subject = subject;
        this.doubt = doubt;
        this.answer = answer;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
