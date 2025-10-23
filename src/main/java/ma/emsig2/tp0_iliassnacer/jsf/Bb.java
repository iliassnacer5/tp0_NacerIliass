package ma.emsig2.tp0_iliassnacer.jsf;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;


@Named
@ViewScoped
public class ChatBean implements Serializable {

    private String roleAPI;
    private String question;
    private String reponse;
    private String conversation = "";



    public String envoyerQuestion() {
        if (question == null || question.trim().isEmpty()) {
            return null;
        }

        String reponseAPI = question.toUpperCase();

        if (roleAPI != null && !roleAPI.trim().isEmpty()) {
            reponseAPI = "|| [Rôle: " + roleAPI + "] " + reponseAPI + " ||";
        } else {
            reponseAPI = "|| [Rôle: Non Défini] " + reponseAPI + " ||";
        }

        this.reponse = reponseAPI;

        this.conversation += "-> Utilisateur : " + question + "\n";
        this.conversation += "<- API : " + reponseAPI + "\n\n";

        this.question = "";

        return null;
    }

    public String effacerQuestionReponse() {
        this.question = "";
        this.reponse = "";
        return null;
    }

    public String nouveauChat() {
        return "index.xhtml?faces-redirect=true";
    }

    public String getRoleAPI() {
        return roleAPI;
    }

    public void setRoleAPI(String roleAPI) {
        this.roleAPI = roleAPI;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }
}
