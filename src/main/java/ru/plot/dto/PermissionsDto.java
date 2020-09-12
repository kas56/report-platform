package ru.plot.dto;

public class PermissionsDto {

    private boolean admin;

    private boolean oper;

    private boolean auditor;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isOper() {
        return oper;
    }

    public void setOper(boolean oper) {
        this.oper = oper;
    }

    public boolean isAuditor() {
        return auditor;
    }

    public void setAuditor(boolean auditor) {
        this.auditor = auditor;
    }
}
