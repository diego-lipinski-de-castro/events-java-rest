package d2.api.events.enums;

public enum AccountStatus {

    ENABLED("Ativada"),
    DISABLED("Desativada"),
    BLOCKED("Bloqueada");

    private String status;

    AccountStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
