<%-- 
    Document   : index
    Created on : Sep 1, 2016, 10:39:29 PM
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <script src="https://use.fontawesome.com/2572aa44c6.js"></script>
        <link rel="shortcut icon" href="http://i.imgur.com/rlx1Kb2.png">

        <title>Nền Dota2 Sập CMNR</title>
    </head>
    <body>
        <div style="padding-bottom: 30px; padding-top: 30px;"></div>
        <div id="wrap">
            <div class="container">
                <jsp:include page="header.html"/>

                <!--Page Content-->
                <div style="margin-left: auto; margin-right: auto; width: 70%;">
                    <input type="text" id="txtSearch" name="txtSearch" placeholder="&#xf002; Search" style="outline: 0;
                           outline: none;
                            border-color: #d9ff35;
                            box-shadow: 0 0 18px #d9ff35;
                            border: 1px solid #b1da13;
                           background: #f2f2f2;
                           width: 100%;
                           margin: 10px 0 15px;
                           padding: 10px;
                           box-sizing: border-box;
                           font-size: 17px;
                           font-family: Roboto, FontAwesome" />
                </div>
                <table id="playerDataTable" class="display" cellspacing="0" width="100%">
                    <thead >
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Player</th>
                            <th>Team</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${requestScope.data}">
                            <tr>
                                <td>${item.date}</td>
                                <td>${item.time}</td>
                                <td style="color: #b3e32d; font-weight: bold;">${item.player} <img style="width: 29px" src="assets/image/TI6.png" alt=""/><img style="width: 29px" src="assets/image/TI5.png" alt=""/></td>
                        
                                
                                
                                <td>${item.team}</td>
                                <td>${item.action}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


                <!--Page Content-->
            </div>
        </div>
        <div style="padding-bottom: 30px; padding-top: 30px;"></div>
        <jsp:include page="footer.html"/>
    </body>
    <script type="text/javascript">

        $.fn.dataTable.ext.search.push(
                function (settings, data, dataIndex) {
                    var searchtxt = $('#txtSearch').val().toLowerCase();

                    var name = data[2].toLowerCase(); // use data for the age column
                    var team = data[3].toLowerCase();
                    if (name.indexOf(searchtxt) != -1 || team.indexOf(searchtxt) != -1)
                    {
                        return true;
                    }
                    return false;
                }
        );

        $(document).ready(function () {

            var table = $('#playerDataTable').DataTable({
                "oLanguage": {
                    "sZeroRecords": "No matched data.",
                    "sEmptyTable": function () {
                        $('button[id="btnExport"]').prop('disabled', true);
                        return "No data.";
                    },
                    "sProcessing": "Processing...",
                    "oPaginate": {
                        "sNext": "<i class='fa fa-chevron-right'></i>",
                        "sPrevious": "<i class='fa fa-chevron-left'></i>",
                    },
                },
                "bProcessing": true,
                "iDisplayLength": -1,
                "bInfo": false,
                "bPaginate": false,
                "bLengthChange": false,
                "bFilter": true,
            });

            $('#txtSearch').keyup(function () {
                table.draw();
            });
        });

    </script>
</html>
