public class Position {

    private int xCoor;
    private int yCoor;

    private String status;
    private String letter;
    private String compView;
    private String humView;

    public Position (int x, int y) {
        this.xCoor = x;
        this.yCoor = y;
        this.letter = "z";

        this.status = "empty";
        this.compView = "\uD83C\uDF0A";
        this.humView = "\uD83C\uDF0A";
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setLetter(String letter) {
        this.letter = letter;
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

    public void setStatus(String status) {
        this.status = status;

        switch (status) {
            case "empty":
                setCompView("\uD83C\uDF0A");
                setHumView("\uD83C\uDF0A");
                break;
            case "hum":
                setCompView("⛵");
                setHumView("⛵");
                break;
            case "comp":
                setCompView("\uD83D\uDEA2");
                setHumView("\uD83D\uDEA2");
                break;
            case "hidHumanShip":
                setCompView("\uD83C\uDF0A");
                setHumView(this.getLetter());
                break;
            case "hidCompShip":
                setCompView(this.getLetter());
                setHumView("\uD83C\uDF0A");
                break;
            case "foundHumanShip":
                setCompView("☠");
                setHumView("\uD83D\uDCA5");
                break;
            case "foundCompShip":
                setCompView("\uD83D\uDCA5");
                setHumView("☠");
                break;
            case "hidLandmine":
                setCompView("\uD83C\uDF0A");
                setHumView("\uD83C\uDF0A");
                break;
            case "foundLandmine":
                setHumView("\uD83D\uDCA3");
                setCompView("\uD83D\uDCA3");
                break;
        }

    }

    public void setCompView(String compView) {
        this.compView = compView;
    }

    public void setHumView(String humView) {
        this.humView = humView;
    }

}
