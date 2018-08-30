package com.great.school.models.response;

/**
 * Created by Kibet on 01-Dec-17.
 */
public class DashboardStat {
    public String title;
    public String color;
    public String icon;
    public Object value;

    public DashboardStat(String title, String color, String icon, Object value) {
        this.title = title;
        this.color = color;
        this.icon = icon;
        this.value = value;
    }

    public class Colors {
        public  final String red ="#FF0";
        public  final String blue ="#FF0";
        public  final String green ="#FF0";
        public  final String yellow ="#FF0";
    }


    public class Icons {
        public  final String add ="group_add";
        public  final String users ="group";
        public  final String money ="group";
        public  final String attendance ="done";
        public  final String done ="done";
    }
}
