import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();
        ArrayList<Hardware> hardwareList = repo.getAllHardware();


        System.out.println("All Hardware Records:");
        System.out.printf("%-5s %-15s %-20s %-10s%n", "ID", "Brand", "Spec", "Type");
        System.out.println("--------------------------------------------------------");
        for (Hardware hw : hardwareList) {
            String type = hw instanceof Laptop ? "Laptop" : "Phone";
            System.out.printf("%-5d %-15s %-20s %-10s%n",
                    hw.getId(),
                    hw.getBrand(),
                    hw.interpretSpec(),
                    type);
        }

        System.out.println("\n--- Counting Summary ---\n");

        // Dynamic arrays for laptops
        int[] laptopSpecs = new int[0];
        int[] laptopCounts = new int[0];

        // Dynamic arrays for phones
        int[] phoneSpecs = new int[0];
        int[] phoneCounts = new int[0];

        // Loop through hardware list to count dynamically
        for (Hardware hw : hardwareList) {
            int spec = hw.getSpec();
            String type = hw instanceof Laptop ? "laptop" : "phone";

            if (type.equals("laptop")) {
                boolean found = false;
                for (int i = 0; i < laptopSpecs.length; i++) {
                    if (laptopSpecs[i] == spec) {
                        laptopCounts[i]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    int[] newSpecs = new int[laptopSpecs.length + 1];
                    int[] newCounts = new int[laptopCounts.length + 1];
                    System.arraycopy(laptopSpecs, 0, newSpecs, 0, laptopSpecs.length);
                    System.arraycopy(laptopCounts, 0, newCounts, 0, laptopCounts.length);
                    newSpecs[newSpecs.length - 1] = spec;
                    newCounts[newCounts.length - 1] = 1;
                    laptopSpecs = newSpecs;
                    laptopCounts = newCounts;
                }

            } else if (type.equals("phone")) {
                boolean found = false;
                for (int i = 0; i < phoneSpecs.length; i++) {
                    if (phoneSpecs[i] == spec) {
                        phoneCounts[i]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    int[] newSpecs = new int[phoneSpecs.length + 1];
                    int[] newCounts = new int[phoneCounts.length + 1];
                    System.arraycopy(phoneSpecs, 0, newSpecs, 0, phoneSpecs.length);
                    System.arraycopy(phoneCounts, 0, newCounts, 0, phoneCounts.length);
                    newSpecs[newSpecs.length - 1] = spec;
                    newCounts[newCounts.length - 1] = 1;
                    phoneSpecs = newSpecs;
                    phoneCounts = newCounts;
                }
            }
        }

        // Display laptop counts (original format)
        System.out.println("Laptop counts:");
        for (int i = 0; i < laptopSpecs.length; i++) {
            System.out.println(laptopSpecs[i] + "GB Laptop: " + laptopCounts[i]);
        }

        // Display phone counts (original format)
        System.out.println("\nPhone counts:");
        for (int i = 0; i < phoneSpecs.length; i++) {
            System.out.println(phoneSpecs[i] + "MP Phone: " + phoneCounts[i]);
        }
    }
}