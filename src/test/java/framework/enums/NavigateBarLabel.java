package framework.enums;

public enum NavigateBarLabel {

    DEVICES("Devices"), LICENSES("Licenses"), DOWNLOADS("Downloads");

    private String category;

    NavigateBarLabel(String category) {
            this.category = category;
        }

    public String getNavigateBarLabel() {
        return category;
    }
    }


