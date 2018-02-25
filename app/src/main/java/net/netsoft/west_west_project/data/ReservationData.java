package net.netsoft.west_west_project.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HCKH on 22/2/18.
 */

public class ReservationData {

    public Map<String, String> reservation_type_array = new HashMap<>();
    public Map<String, String> reservation_layer1_array = new HashMap<>();
    public Map<String, String> reservation_layer2_array_1 = new HashMap<>();
    public Map<String, String> reservation_layer2_array_2 = new HashMap<>();
    public Map<String, String> reservation_layer2_array_3 = new HashMap<>();
    public Map<String, String[]> reservation_layer3_array_1 = new HashMap<>();
    public Map<String, String[]> reservation_layer3_array_2 = new HashMap<>();
    public Map<String, String[]> reservation_layer3_array_3 = new HashMap<>();

    private String[] reservation_layer5_type_1 = new String[]{
            "ABC1234", "624225252", "CBSSIFI"
    };
    private String[] reservation_layer5_type_2 = new String[]{
            "ABC1234", "624225252", "CBSSIFI"
    };
    private String[] reservation_layer5_type_3 = new String[]{
            "ABC1234", "624225252", "CBSSIFI"
    };
    public Map<String, String[]> reservation_layer5_data = new HashMap<>();
    public Map<String, Integer> reservation_layer5_register_max_num = new HashMap<>();

    public ReservationData(){
        reservation_type_array.put("1","籃球場");
        reservation_type_array.put("2","七人足球場");
        reservation_type_array.put("3","五人足球場");

        reservation_layer1_array.put("1","香港島");
        reservation_layer1_array.put("2","九龍");
        reservation_layer1_array.put("3","新界");

        //香港島
        reservation_layer2_array_1.put("1","中西區");
        reservation_layer2_array_1.put("2","灣仔區");
        reservation_layer2_array_1.put("3","東區");
        reservation_layer2_array_1.put("4","南區");
        //九龍
        reservation_layer2_array_2.put("5","油尖旺區");
        reservation_layer2_array_2.put("6","深水埗區");
        reservation_layer2_array_2.put("7","九龍城區");
        reservation_layer2_array_2.put("8","黃大仙區");
        reservation_layer2_array_2.put("9","觀塘區");
        //新界
        reservation_layer2_array_3.put("10","葵青區");
        reservation_layer2_array_3.put("11","荃灣區");
        reservation_layer2_array_3.put("12","屯門區");
        reservation_layer2_array_3.put("13","元朗區");
        reservation_layer2_array_3.put("14","北區");
        reservation_layer2_array_3.put("15","大埔區");
        reservation_layer2_array_3.put("16","沙田區");
        reservation_layer2_array_3.put("17","西貢區");
        reservation_layer2_array_3.put("18","離島區");

        //籃球場
        reservation_layer3_array_1.put("10",new String[]{"青康路遊樂場","坑坪街遊樂場","興芳路遊樂場"});
        reservation_layer3_array_1.put("11",new String[]{"沙咀道遊樂場","深井臨時遊樂場","城門谷公園"});
        //七人足球場
        reservation_layer3_array_2.put("10",new String[]{"中葵涌公園","長達路休憩處","楓樹窩村籃球場"});
        reservation_layer3_array_2.put("11",new String[]{"柴灣角遊樂場","海安路遊樂場","國瑞路公園"});
        //五人足球場
        reservation_layer3_array_3.put("10",new String[]{"中葵涌公園","長達路休憩處","楓樹窩村籃球場"});
        reservation_layer3_array_3.put("11",new String[]{"柴灣角遊樂場","海安路遊樂場","國瑞路公園"});

        reservation_layer5_data.put("1", reservation_layer5_type_1);
        reservation_layer5_data.put("2", reservation_layer5_type_2);
        reservation_layer5_data.put("3", reservation_layer5_type_3);

        reservation_layer5_register_max_num.put("1", 18);
        reservation_layer5_register_max_num.put("2", 20);
        reservation_layer5_register_max_num.put("3", 16);
    }

    public Map<String, String> get_reservation_layer2_array(String array_name){

        Map<String, String> return_array;

        switch (array_name){
            case "1":
                return_array = reservation_layer2_array_1;
                break;
            case "2":
                return_array = reservation_layer2_array_2;
                break;
            case "3":
                return_array = reservation_layer2_array_3;
                break;
            default:
                return_array = null;
        }

        return return_array;

    }

    public Map<String, String[]> get_reservation_layer3_array(String array_type){

        Map<String, String[]> return_array;

        switch (array_type){
            case "1":
                return_array = reservation_layer3_array_1;
                break;
            case "2":
                return_array = reservation_layer3_array_2;
                break;
            case "3":
                return_array = reservation_layer3_array_3;
                break;
            default:
                return_array = null;
        }

        return return_array;

    }
}
