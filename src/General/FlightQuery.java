package General;// Imported packages
import General.AccountFunctions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@WebServlet(name="Flight Query", value="/General.FlightQuery")
public class FlightQuery extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dState = request.getParameter("departState");
        String dCity = request.getParameter("departCity");
        String aState = request.getParameter("arriveState");
        String aCity = request.getParameter("arriveCity");
        String model = request.getParameter("planeModel");
        String tickets = request.getParameter("numberPassengers");
        String pref = request.getParameter("preference");
        String travelType = request.getParameter("travelType");

        String queryList = attemptFlightQuery(dCity,aCity,model,tickets,pref,travelType);

        System.out.println("----------");
        System.out.println(dCity+","+dState+"   "+aCity+","+aState+"    "+model);
        System.out.println("----------");

        System.out.println(queryList);

        response.setContentType("text/plain");
        response.getWriter().print(queryList);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public static String getDateAndTimeSrc(){
        String htmlCode = "";
        htmlCode += "<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">";
        //htmlCode += "<link rel=\"stylesheet\" href=\"/resources/demos/style.css\">";
        htmlCode += "<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>";
        htmlCode += "<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>";

        htmlCode += "<link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css\">";
        htmlCode += "<script src=\"//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js\"></script>";

        //htmlCode += "<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>";

        //htmlCode += "<script type=\"text/javascript\" src=\"http://jonthornton.github.io/jquery-timepicker/jquery.timepicker.js\"></script>";
        //htmlCode += "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://jonthornton.github.io/jquery-timepicker/jquery.timepicker.css\">";
        //htmlCode += "<script type=\"text/javascript\" src=\"http://jonthornton.github.io/jquery-timepicker/lib/bootstrap-datepicker.js\"></script>";
        //htmlCode += "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://jonthornton.github.io/jquery-timepicker/lib/bootstrap-datepicker.css\">";

        return htmlCode;
    }

    public static String addPickers(String type){
        String htmlCode = "";
        htmlCode += "<script> $( function() { $( \"#"+type+"datepicker\" ).datepicker();} ); </script>";
        htmlCode += "<script> $( function() { $(\"#"+type+"timepicker\").timepicker();}) </script>";//{" +
                /*"timeFormat: 'h:mm p'," +
                "interval: 30," +
                "minTime: '12:00 am'," +
                "maxTime: '11:30 pm'," +
                "defaultTime: '12:00 am'," +
                "startTime: '12:00 pm'," +
                "dynamic: false," +
                "dropdown: true," +
                "scrollbar: true" +
                "}); </script>\n";*/
        return htmlCode;
    }

    private static String attemptFlightQuery(String dCity, String aCity, String model, String tickets, String pref, String travelType){
        Connection con = AccountFunctions.OpenDatabase();
        String queryList = queryTOJSON(FlightsFunctions.getFlightQuery(con,dCity,aCity,model,tickets,pref,travelType));
        AccountFunctions.closeConnection(con);
        return queryList;
    }

    private static String queryTOJSON(ArrayList<ArrayList<String>> queryList){
        String[] list = {"fID","pID","mID","dLoc","aLoc","aEcon","aBus","aFirst","Dem","DP","dDate","dTime","aDate","aTime"};
        String jsonQuery = "{\"flights\":[  ";
        for(int i=0; i<queryList.size(); i++){
            jsonQuery +="{";
            for(int j=0; j<queryList.get(i).size()-4;j++){
                jsonQuery += "\""+list[j]+"\":"+queryList.get(i).get(j)+",";
            }
            for(int k=queryList.get(i).size()-4;k<queryList.get(i).size();k++){
                jsonQuery += "\""+list[k]+"\":\""+queryList.get(i).get(k)+"\",";
            }
            jsonQuery = jsonQuery.substring(0,jsonQuery.length()-1)+"},";
        }
        return jsonQuery.substring(0,jsonQuery.length()-1)+"]}";
    }
}
