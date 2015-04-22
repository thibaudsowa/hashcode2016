package team.monalisa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gbilley on 12/03/2015.
 */
public class DataCenter {

    Integer r;
    Integer s;
    Integer u;
    Integer p;
    Integer m;
    List<List<Boolean>> raws = new ArrayList<>();
    List<Server> servers = new ArrayList<>();

    int groupe = -1;

    public DataCenter(List<String> inputLines) throws IOException {
        setHeadersInfo(inputLines);
        setInitialRaws();
        setUnavailableRaws(inputLines);
        setupServers(inputLines);


        servers.stream()
                .sorted((server1, server2) -> server2.compareTo(server1))
                .forEach(server -> {
                    boolean serverPlace = false;
                    int rawIndex = 0;
                    Integer x = rawIndex;
                    // On parcours les rangées
                    while (!serverPlace && rawIndex < this.r) {
                        int groupe = 0;
                        int columnIndex = 0;
                        groupe = (int)Math.random()*44;
                        x = rawIndex;
                        List<Boolean> raw = raws.get(rawIndex);
                        boolean placementAvailable = false;
                        int maxAvailableIndex = raw.size() - server.getSize();
                        columnIndex = 0;
                        int availablePlace = 0;
                        Integer y = 0;
                        //On parcours les colonnes
                        while (!placementAvailable && columnIndex < raw.size()) {
                            if (raw.get(columnIndex)) {
                                if (availablePlace == 0) {
                                    y = columnIndex;
                                }
                                availablePlace++;
                                if (availablePlace == server.getSize()) {
                                    placementAvailable = true;
                                    for (int i = server.getSize() - 1; i >= 0; i--) {
                                        raw.set(columnIndex - i, false);
                                    }
                                }
                            } else {
                                availablePlace = 0;
                            }
                            columnIndex++;
                        }
                        if (placementAvailable) {
                            serverPlace = true;
                            server.setX(x);
                            server.setY(y);
                            server.setGroupNumber(groupe);
                        }
                        rawIndex++;

                    }
                });


        Writer writer = new FileWriter("dc.out");

        servers.forEach(server -> {
            try {
                if (server.getY() == null) {
                    writer.write("x\n");
                } else {
                    writer.write(server.getX() + " " + server.getY() + " " + server.getGroupNumber() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }

    private void setupServers(List<String> inputLines) {
        for (int serverIndex = u + 1; serverIndex <= u + m; serverIndex++) {
            String[] serverInfo = inputLines.get(serverIndex).split(" ");

            Integer size = Integer.valueOf(serverInfo[0]);
            Integer capacity = Integer.valueOf(serverInfo[1]);
            Server server = new Server(size, capacity, capacity / size);
            servers.add(server);
        }
    }

    private void setHeadersInfo(List<String> inputLines) {
        String[] header = inputLines.get(0).split(" ");
        this.r = Integer.valueOf(header[0]);//           R​: le nombre de rangées du centre de données,
        this.s = Integer.valueOf(header[1]);//        ○ S​(1 ≤ S ≤ 1000) : le nombre d'emplacements de chaque rangée du centre de données,
        this.u = Integer.valueOf(header[2]);//        ○ U​(0 ≤ U ≤ R × S) : le nombre d'emplacements indisponibles,
        this.p = Integer.valueOf(header[3]);//        ○ P​(1 ≤ P ≤ 1000) : le nombre de groupes à créer,
        this.m = Integer.valueOf(header[4]);//        ○ M​(1 ≤ M ≤ R × S) : le nombre de serveurs à allouer;
    }

    private void setUnavailableRaws(List<String> inputLines) {
        for (int unavailableSpot = 0; unavailableSpot < u; unavailableSpot++) {
            String[] unavailabelSpotInfos = inputLines.get(unavailableSpot + 1).split(" ");
            int spotRow = Integer.valueOf(unavailabelSpotInfos[0]);
            int spotIndex = Integer.valueOf(unavailabelSpotInfos[1]);
            raws.get(spotRow).set(spotIndex, false);
        }
    }

    private void setInitialRaws() {
        for (int rawIndex = 0; rawIndex < r; rawIndex++) {
            List<Boolean> raw = new ArrayList<Boolean>();
            for (int spotIndex = 0; spotIndex < s; spotIndex++) {
                raw.add(true);
            }
            raws.add(raw);
        }
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getU() {
        return u;
    }

    public void setU(Integer u) {
        this.u = u;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public Integer getR() {

        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public List<List<Boolean>> getRaws() {
        return raws;
    }

    public void setRaws(List<List<Boolean>> raws) {
        this.raws = raws;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
}
