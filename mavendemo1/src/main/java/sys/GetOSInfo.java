package sys;

public class GetOSInfo {

    public static void main(String[] args) {

        System.out.println("OS Name : " + System.getProperty("os.name"));
        System.out.println("OS Architecture : " + System.getProperty("os.arch"));
        System.out.println("OS Version : " +System.getProperty("os.version"));
        System.out.println("OS Data Model : " + System.getProperty("sun.arch.data.model"));


    }

}
