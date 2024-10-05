import java.util.ArrayList;
import java.util.List;

class Gaanth {
    int data;
    Gaanth daayi, baayi;

    Gaanth(int maan)
    {
        data = maan;
        daayi = baayi = null;
    }
}

public class Ped_Koi_MoolGaanthNahi {

    Gaanth jad;
    private List<Integer> raasta1 = new ArrayList<>();
    private List<Integer> raasta2 = new ArrayList<>();

    int paayiLCA(int maan1, int maan2)
    {
        raasta1.clear();
        raasta2.clear();
        return antarikPaayiLCA(jad, maan1, maan2);
    }

    private int antarikPaayiLCA(Gaanth jad, int maan1, int maan2)
    {

        if (!raastaKhojo(jad, maan1, raasta1) || !raastaKhojo(jad, maan2, raasta2)) {
            System.out.println((raasta1.size() > 0) ? "maan1 maujood hai" : "maan1 nahi hai");
            System.out.println((raasta2.size() > 0) ? "maan2 maujood hai" : "maan2 nahi hai");
            return -1;
        }

        int i;
        for (i = 0; i < raasta1.size() && i < raasta2.size(); i++) {
            if (!raasta1.get(i).equals(raasta2.get(i)))
                break;
        }

        return raasta1.get(i - 1);
    }

    private boolean raastaKhojo(Gaanth jad, int maan, List<Integer> raasta)
    {
        if (jad == null) {
            return false;
        }

        raasta.add(jad.data);

        if (jad.data == maan || raastaKhojo(jad.daayi, maan, raasta) || raastaKhojo(jad.baayi, maan, raasta)) {
            return true;
        }

        raasta.remove(raasta.size() - 1);

        return false;
    }

    public static void main(String[] args)
    {
        Ped_Koi_MoolGaanthNahi vriksh = new Ped_Koi_MoolGaanthNahi();
        vriksh.jad = new Gaanth(1);
        vriksh.jad.daayi = new Gaanth(2);
        vriksh.jad.baayi = new Gaanth(3);
        vriksh.jad.daayi.daayi = new Gaanth(4);
        vriksh.jad.daayi.baayi = new Gaanth(5);
        vriksh.jad.baayi.daayi = new Gaanth(6);
        vriksh.jad.baayi.baayi = new Gaanth(7);

        System.out.println("LCA(4, 5) = " + vriksh.paayiLCA(4, 5));
        System.out.println("LCA(4, 6) = " + vriksh.paayiLCA(4, 6));
        System.out.println("LCA(3, 4) = " + vriksh.paayiLCA(3, 4));
        System.out.println("LCA(2, 4) = " + vriksh.paayiLCA(2, 4));
    }
}
