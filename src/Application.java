import simulation.Simulation;

public class Application {
    public static void main(String[] args) {

        Simulation simulation = new Simulation(18, 18);

        simulation.initSimulation();
        simulation.runSimulation();



    }
}
