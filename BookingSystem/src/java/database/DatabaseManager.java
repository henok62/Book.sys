package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {

    public static void main(String[] args) throws IOException {
        try {
            DatabaseManager.dBConnectionOpen();

            System.out.println(DatabaseManager.createDB());

        } catch (SQLException e) {
            System.out.println("Databas ej skapad: " + e);
        }
    }
    static String connectionString = "jdbc:mysql://localhost:3306/book_sys_data";
//    static String connectionString = "jdbc:mysql://aa1buv8d4lrojci.cz2hdy4d2yab.us-"
//            + "west-2.rds.amazonaws.com/giron_schema";
    static String selectResult = null;
    static Connection cn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static ArrayList selectResultArrayList = null;

    public static void dBConnectionOpen() throws SQLException {
        // Class.forName("com.mysql.jdbc.Driver");
        // obs ändra till mickedb på aws
        cn = DriverManager.getConnection(connectionString, "root", "mickemicke");
        st = cn.createStatement();


    }

    public static void dBConnectionClose() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (cn != null) {
            cn.close();
        }


    }
// Creates a MySQL database from scratch

    public static String createDB() throws SQLException, IOException {
        String h = "";
        try {
            dBConnectionOpen();
            st.execute("drop database if exists book_sys_data;");
            st.execute("create database if not exists book_sys_data;");
            st.execute("use book_sys_data;");
            st.execute("create table business_type(business_type_id int not null auto_increment, business_type_name varchar(100), primary key(business_type_id));");
            st.execute("create table destination(destination_id int not null auto_increment, destination_name varchar(100), destination_description varchar(300), primary key(destination_id));");
            st.execute("create table address(address_id int not null auto_increment, address varchar(200), city varchar(100),\n"
                    + "country varchar(100), primary key(address_id));");
            st.execute("create table business(business_id int not null auto_increment, business_name varchar(100), business_type_id int, org_number varchar(50), mobile_phone_number varchar(30), \n"
                    + "landline_phone_number varchar(30), fax_no varchar(30), email varchar(100), address_id int, destination_id int, business_description varchar(300), logo blob,\n"
                    + "foreign key(address_id) references address(address_id), foreign key(destination_id) references destination(destination_id),\n"
                    + "foreign key(business_type_id) references business_type(business_type_id), primary key(business_id));");
            st.execute("create table person(person_id int not null auto_increment, personal_number char(10), first_name varchar(50), last_name varchar(50),\n"
                    + "address_id int null, foreign key(address_id) references address(address_id),\n"
                    + "primary key(person_id));");
            st.execute("create table role(role_id int not null auto_increment, primary key(role_id), role_name varchar(100), role_description varchar(200));");
            st.execute("create table user_instance(user_id int not null auto_increment, primary key(user_id),\n"
                    + "role_id int null, foreign key(role_id) references role(role_id),\n"
                    + "person_id int null, foreign key(person_id) references person(person_id),\n"
                    + "business_id int null, foreign key(business_id) references business(business_id),\n"
                    + "username varchar(30) null, user_password varchar(30) null);");
            st.execute("create table booking(booking_id int not null auto_increment, primary key(booking_id), "
                    + "timestamp TIMESTAMP, "
                    + "user_id int null, foreign key(user_id) references user_instance(user_id));");
            st.execute("create table tour_type(tour_type_id int not null auto_increment, primary key(tour_type_id),\n"
                    + "business_id int, foreign key(business_id) references business(business_id));");
            st.execute("create table tour(tour_id int not null auto_increment, primary key(tour_id),\n"
                    + "tour_type_id int null, foreign key(tour_type_id) references tour_type(tour_type_id));");
            st.execute("create table scheduled_tour(scheduled_tour_id int not null auto_increment, primary key(scheduled_tour_id), "
                    + "tour_id int null, foreign key(tour_id) references tour(tour_id));");
            st.execute("create table activity_type(activity_type_id int not null auto_increment, primary key(activity_type_id), \n"
                    + "activity_type_name varchar(100), description varchar(300));");
            st.execute("create table activity(activity_id int not null auto_increment, primary key(activity_id),\n"
                    + "business_id int null, foreign key(business_id) references business(business_id),\n"
                    + "activity_type_id int null, foreign key(activity_type_id) references activity_type(activity_type_id),\n"
                    + "activity_name varchar(100),"
                    + "activity_information varchar(500),"
                    + "activity_resources varchar(300),"
                    + "activity_transports varchar(500),"
                    + "activity_pricing varchar(30),"
                    + "activity_description varchar(500));");
            st.execute("create table scheduled_activity(scheduled_activity_id int not null auto_increment, primary key(scheduled_activity_id),\n"
                    + "activity_id int null, foreign key(activity_id) references activity(activity_id), "
                    + "date_start date, date_end date, "
                    + "scheduled_tour_id int null, foreign key(scheduled_tour_id) references scheduled_tour(scheduled_tour_id));");
            st.execute("create table booking_row(booking_row_id int not null auto_increment, primary key(booking_row_id),\n"
                    + "booking_id int, foreign key(booking_id) references booking(booking_id), \n"
                    + "scheduled_tour_id int, foreign key(scheduled_tour_id) references scheduled_tour(scheduled_tour_id),\n"
                    + "scheduled_activity_id int, foreign key(scheduled_activity_id) references scheduled_activity(scheduled_activity_id));");
            st.execute("create table allotment_list(allotment_list_id int not null auto_increment, primary key(allotment_list_id),"
                    + "description varchar(300))");
            st.execute("create table allotment_list_item(allotment_list_item_id int not null auto_increment, primary key(allotment_list_item_id), "
                    + "description varchar(300));");
            st.execute("create table allotment(allotment_id int not null auto_increment, primary key(allotment_id), "
                    + "description varchar(300));");
            st.execute("create table partner_list(partner_list_id int not null auto_increment, "
                    + "primary key(partner_list_id), description varchar(300));");
            st.execute("create table destination_list(destination_list_id int not null auto_increment, "
                    + "primary key(destination_list_id), destination_list_name varchar(300), description varchar(300));");
            st.execute("create table destination_list_item(destination_list_item_id int not null auto_increment, "
                    + "primary key(destination_list_item_id), description varchar(300));");

            // added 10/11/2013 Mikael
            st.execute("create table resource_type(resource_type_id int not null auto_increment, "
                    + "primary key(resource_type_id), resource_type_name varchar(200), "
                    + "resource_type_description varchar(400))");
            st.execute("create table resource(resource_id int not null auto_increment, "
                    + "primary key(resource_id), "
                    + "resource_type_id int, foreign key(resource_type_id) references resource_type(resource_type_id), "
                    + "resource_name varchar(100), resource_description varchar(400), "
                    + "person_id int, foreign key(person_id) references person(person_id));");
            st.execute("create table resource_booking(resource_booking_id int not null auto_increment, "
                    + "primary key(resource_booking_id), "
                    + "timestamp TIMESTAMP, "
                    + "start_time DATETIME, "
                    + "end_time DATETIME, "
                    + "scheduled_activity_id int, "
                    + "foreign key(scheduled_activity_id) references scheduled_activity(scheduled_activity_id),"
                    + "resource_id int, foreign key(resource_id) references resource(resource_id));");
            st.execute("create table pricing_category(pricing_category_id int not null auto_increment, "
                    + "primary key(pricing_category_id),"
                    + "pricing_category_description varchar(200))");
            st.execute("create table pricing(pricing_id int not null auto_increment, "
                    + "primary key(pricing_id), "
                    + "pricing_category_id int, "
                    + "foreign key(pricing_category_id) references pricing_category(pricing_category_id), "
                    + "scheduled_activity_id int, "
                    + "foreign key(scheduled_activity_id) references scheduled_activity(scheduled_activity_id), "
                    + "start_time datetime, "
                    + "end_time datetime, "
                    + "discount int)");
            st.execute("insert into resource_booking values();");
            st.execute("insert into resource values();");
            st.execute("insert into resource_type values();");
            st.execute("insert into pricing values();");
            st.execute("insert into pricing_category values();");
            // end of add

            st.execute("insert into role values();");
            st.execute("insert into person values();");
            st.execute("insert into role values();");
            st.execute("insert into booking values();");
            st.execute("insert into booking_row values();");
            st.execute("insert into scheduled_activity values();");
            st.execute("insert into activity values();");
            st.execute("insert into activity_type values();");
            st.execute("insert into tour values();");
            st.execute("insert into tour_type values();");
            st.execute("insert into scheduled_tour values();");
            st.execute("insert into user_instance values();");
            st.execute("insert into person values();");
            st.execute("insert into destination values();");
            st.execute("insert into address values();");
            st.execute("insert into business values();");
            st.execute("insert into business_type values();");
            st.execute("insert into allotment_list values();");
            st.execute("insert into allotment_list_item values()");
            st.execute("insert into allotment values()");
            st.execute("insert into scheduled_activity(activity_id, date_start, date_end) values\n"
                    + "(1, '2014-12-31', '2014-12-11');");
            st.execute("insert into activity (business_id, activity_type_id) values\n"
                    + "(1,1);");
            st.execute("insert into tour (tour_type_id) values\n"
                    + "(1);");
            st.execute("insert into tour_type(business_id) values\n"
                    + "(1);");
            st.execute("insert into scheduled_tour(tour_id) values\n"
                    + "(1);");
            st.execute("insert into user_instance(role_id, person_id, business_id, username, user_password) values\n"
                    + "(1, 1, 1, 'Håkan', 'giron12345');");
            st.execute("insert into destination(destination_name, destination_description) values\n"
                    + "('Kiruna', 'Activities and services in Kiruna');");
            st.execute("insert into address (address, city, country) values\n"
                    + "('Skebokvarnsvägen 1', 'Bandhagen', 'Sweden');");
            st.execute("insert into address (address, city, country) values\n"
                    + "('Norrlandsgatan 1', 'Kiruna', 'Sweden');");
            st.execute("insert into address (address, city, country) values\n"
                    + "('Hälsingforsgatan 1', 'Kiruna', 'Sweden');");
            st.execute("insert into booking(user_id) values\n"
                    + "(1);");
            st.execute("insert into person(first_name, last_name) values\n"
                    + "('Håkan', 'Enoksson');");
            st.execute("insert into person(first_name, last_name) values\n"
                    + "('Joel', 'Tjäder');");
            st.execute("insert into person(personal_number, first_name, last_name) values\n"
                    + "('820219xxxx', 'Mikael', 'Saltzman');");
            st.execute("insert into business_type(business_type_name) values\n"
                    + "('Supplier'),\n"
                    + "('Travel Agency'),\n"
                    + "('System Owner');");
            st.execute("insert into activity_type (activity_type_name, description) values \n"
                    + "('Trip', 'A trip or other activity'),"
                    + "('Accommodation', 'A sleeping accommodation'),"
                    + "('Transport', 'A transportation');");
            st.execute("insert into business(business_name, org_number, mobile_phone_number, landline_phone_number, fax_no, email, business_description) values\n"
                    + "('Kiruna Travels', '0986734523', '07034534545', '083453453', '0877774345', 'myemail@gmail.com', 'Kiruna based business');");
            st.execute("insert into role(role_name, role_description) values\n"
                    + "('Super Administrator', 'Unlimited system access'),\n"
                    + "('Administrator', 'Unlimited administrative access'),\n"
                    + "('Administrative Assistant', 'Restricted administrative access'),\n"
                    + "('Final Customer', 'Final Customer access'),\n"
                    + "('Employee', 'Unlimited system access');");
            st.execute("insert into booking_row(booking_id, scheduled_tour_id, scheduled_activity_id) values\n"
                    + "(1,1,1);");

            dBConnectionClose();
            h = "Databas skapad";
        } catch (Exception ex) {
            System.out.println("Databas ej skapad" + h);
        }

        return h;
    }
}
