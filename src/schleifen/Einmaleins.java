package schleifen;

public class Einmaleins {

    public static void main(String[] args) {
        for (int z=1;z<=10;z++){
            //System.out.println(z);
            for (int s=1;s<=10;s++){
                System.out.printf("%2dx%2d=%3d ",s,z,s*z);
            }
            System.out.println();
        }
    }
}
