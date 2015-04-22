package team.monalisa;

/**
 * Created by gbilley on 12/03/2015.
 */
public class Server implements Comparable<Server>{
    Integer capacity;
    Integer size;
    Double score;
    Integer x;
    Integer y;
    int groupNumber;

    public Server(int size, int capacity, double score) {
        this.capacity = capacity;
        this.size = size;
        this.score = score;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Server{" +
                "score=" + score +
                ", x=" + x +
                ", y=" + y +
                ", groupNumber=" + groupNumber +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public int compareTo(Server o) {
        return Double.compare(this.getScore(), o.getScore());
    }
}
