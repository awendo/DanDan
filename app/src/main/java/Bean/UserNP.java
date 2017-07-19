package Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/7/16.
 */

public class UserNP extends BmobObject{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
