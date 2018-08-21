package framework.enums;

public enum RegularExpression {

    DOWNLOAD_LINK("(http.+Installer.+serviceId.*%s.+osTypeId.*%s.*u)");

    private String regExp;

    RegularExpression(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}
