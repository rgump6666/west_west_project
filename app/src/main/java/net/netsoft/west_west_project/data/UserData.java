package net.netsoft.west_west_project.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HCKH on 26/2/2018.
 */

public class UserData {

    public Map<String, String[]> userData = new HashMap<>();

    public UserData(){
        userData.put("-1", new String[]{"","Guest",""});
        userData.put("admin", new String[]{"admin","Admin","1"});
        userData.put("jasoniphk1238@hotmail.com", new String[]{"123456","Jason Ip","0"});
    }

}
