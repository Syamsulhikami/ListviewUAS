package simple.example.hewanpedia;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import simple.example.hewanpedia.model.Anjing;
import simple.example.hewanpedia.model.Hewan;
import simple.example.hewanpedia.model.Kucing;
import simple.example.hewanpedia.model.Buah;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Kucing> initDataKucing(Context ctx) {
        List<Kucing> kucings = new ArrayList<>();
        kucings.add(new Kucing(ctx.getString(R.string.aku), ctx.getString(R.string.kamu),
                ctx.getString(R.string.dia), R.drawable.cat_angora));
        kucings.add(new Kucing(ctx.getString(R.string.mereka), ctx.getString(R.string.kami),
                ctx.getString(R.string.kita), R.drawable.cat_bengal));
        kucings.add(new Kucing(ctx.getString(R.string.rex), ctx.getString(R.string.ona),
                ctx.getString(R.string.rexona), R.drawable.cat_birman));
        kucings.add(new Kucing(ctx.getString(R.string.ivan), ctx.getString(R.string.typing),
                ctx.getString(R.string.keybo), R.drawable.cat_persia));
        kucings.add(new Kucing(ctx.getString(R.string.mam), ctx.getString(R.string.dung),
                ctx.getString(R.string.iba), R.drawable.cat_siam));
        kucings.add(new Kucing(ctx.getString(R.string.alu), ctx.getString(R.string.card),
                ctx.getString(R.string.egy), R.drawable.cat_siberian));
        return kucings;
    }

    private static List<Anjing> initDataAnjing(Context ctx) {
        List<Anjing> anjings = new ArrayList<>();
        anjings.add(new Anjing(ctx.getString(R.string.chou), ctx.getString(R.string.in),
                ctx.getString(R.string.finix), R.drawable.dog_bulldog));
        anjings.add(new Anjing(ctx.getString(R.string.win), ctx.getString(R.string.won),
                ctx.getString(R.string.shin), R.drawable.dog_husky));
        anjings.add(new Anjing(ctx.getString(R.string.zui), ctx.getString(R.string.lilit),
                ctx.getString(R.string.gor), R.drawable.dog_kintamani));
        anjings.add(new Anjing(ctx.getString(R.string.casa), ctx.getString(R.string.acnes),
                ctx.getString(R.string.cuan), R.drawable.dog_samoyed));
        anjings.add(new Anjing(ctx.getString(R.string.aman), ctx.getString(R.string.gawat),
                ctx.getString(R.string.dar), R.drawable.dog_shepherd));
        anjings.add(new Anjing(ctx.getString(R.string.panik), ctx.getString(R.string.ser),
                ctx.getString(R.string.hit), R.drawable.dog_shiba));
        return anjings;
    }

    private static List<Buah> initDataBuah(Context ctx) {
        List<Buah> buahs = new ArrayList<>();
        buahs.add(new Buah(ctx.getString(R.string.bul), ctx.getString(R.string.jar),
                ctx.getString(R.string.smart), R.drawable.vivo));
        buahs.add(new Buah(ctx.getString(R.string.zenn), "USA",
                ctx.getString(R.string.giga), R.drawable.iphone));
        buahs.add(new Buah(ctx.getString(R.string.irit), ctx.getString(R.string.glow),
                ctx.getString(R.string.noss), R.drawable.oppo));

        return buahs;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKucing(ctx));
        hewans.addAll(initDataAnjing(ctx));
        hewans.addAll((Collection<? extends Hewan>) initDataBuah(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
