public class Position {

    private int xCoor;
    private int yCoor;

    private String status;
    private String letter;
    private String compView;
    private String humView;
    private String hidView;

    public Position (int x, int y) {
        this.xCoor = x;
        this.yCoor = y;
        this.letter = "z";

        this.status = "empty";
        this.compView = "\uD83C\uDF0A";
        this.humView = "\uD83C\uDF0A";
        this.hidView = "\uD83C\uDF0A";
    }

    public String selectString(String type) {
        String result = "";

        if (type.equals("human")) {
            result = getHumView();
        } else if (type.equals("computer")) {
            result = getCompView();
        } else if (type.equals("hidden")) {
            result = getHidView();
        }

        return result;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public String getLetter() {
        return letter;
    }

    public String getStatus() {
        return status;
    }

    public String getCompView() {
        return compView;
    }

    public String getHumView() {
        return humView;
    }

    public String getHidView() {
        return hidView;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCompView(String compView) {
        this.compView = compView;
    }

    public void setHumView(String humView) {
        this.humView = humView;
    }

    public void setHidView(String hidView) {
        this.hidView = hidView;
    }
}
