package ipk404.bisindosdict.Dao;

/**
 * Created by Undetected on 3/18/2018.
 */

public class DictDao {
    final int id;
    int is_favorite=0,is_common=0;
    final String kata,arti,video,pict;

    public DictDao(int id, int is_favorite, int is_common, String kata, String arti, String video, String pict) {
        this.id = id;
        this.is_favorite = is_favorite;
        this.is_common = is_common;
        this.kata = kata;
        this.arti = arti;
        this.video = video;
        this.pict = pict;
    }

    public int getId() {
        return id;
    }

    public void setIs_common(int is_common) {
        this.is_common = is_common;
    }

    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    public int getIs_common() {
        return is_common;
    }

    public int getIs_favorite() {
        return is_favorite;
    }

    public String getArti() {
        return arti;
    }

    public String getKata() {
        return kata;
    }

    public String getPict() {
        return pict;
    }

    public String getVideo() {
        return video;
    }
}
