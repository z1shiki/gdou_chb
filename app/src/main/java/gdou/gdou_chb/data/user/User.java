package gdou.gdou_chb.data.user;

/**
 * Created by Z1shiki on 2016/11/23.
 */

public final class User {
    private String uId;
    private final String uName;
    private final String uPassword;
//    private final boolean uSucessed;

    public User(String name, String password) {
        uId= null;
        uName = name;
        uPassword = password;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuId() {
        return uId;
    }

    public String getuName() {
        return uName;
    }

    public String getuPassword() {
        return uPassword;
    }
}
