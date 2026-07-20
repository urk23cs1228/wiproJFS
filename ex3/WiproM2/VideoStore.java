package WiproM2;
public class VideoStore {

    private Video[] store;
    private int count;

    public VideoStore() {
        store = new Video[100];
        count = 0;
    }

    public void addVideo(String name) {
        store[count] = new Video(name);
        count++;
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    public void doCheckout(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void doReturn(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void receiveRating(String name, int rating) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void listInventory() {
        if (count == 0) {
            System.out.println("No videos in inventory.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Video Name : " + store[i].getName());
            System.out.println("Checkout Status : " + store[i].getCheckout());
            System.out.println("Rating : " + store[i].getRating());
            
        }
    }
}